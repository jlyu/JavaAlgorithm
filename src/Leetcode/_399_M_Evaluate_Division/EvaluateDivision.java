package Leetcode._399_M_Evaluate_Division;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

/*
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number
(floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.


https://leetcode-cn.com/problems/evaluate-division
 */
public class EvaluateDivision {

    private HashMap<String, HashMap<String, Double>> build(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> m = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String start = equation.get(0);
            String end = equation.get(1);
            double weight = values[i];

            if (m.containsKey(start)) {
                m.get(start).put(end, Double.valueOf(weight));
            } else {
                m.put(start, new HashMap<String, Double>() {{
                    put(end, Double.valueOf(weight));
                }});
            }

            if (m.containsKey(end)) {
                m.get(end).put(start, Double.valueOf(1.0 / weight));
            } else {
                m.put(end, new HashMap<String, Double>() {{
                    put(start, Double.valueOf(1.0 / weight));
                }});
            }
        }
        return m;
    }

    private Pair<Double, Boolean> dfs(HashMap<String, HashMap<String, Double>> g, Set<String> visited, String start, String end, boolean found) {
        if ((!g.containsKey(start) || !g.containsKey(end)) || (visited.contains(start))) {
            return new Pair<>(-1.0, false);
        }
        if (g.get(start).containsKey(end)) {
            return new Pair<>(g.get(start).get(end), true);
        }

        visited.add(start);
        for (Map.Entry<String, Double> item: g.get(start).entrySet()) {
            Pair<Double, Boolean> p = dfs(g, visited, item.getKey(), end, found);
            if (p.getValue()) {
                double res = p.getKey() * item.getValue();
                return new Pair<>(res, true);
            }
        }
        visited.remove(start);
        found = false;
        return new Pair<>(-1.0, false);
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = build(equations, values);
        List<Double> res = new ArrayList<>();
        for (List<String> q : queries) {
            Set<String> visited = new HashSet<>();
            boolean found = false;
            Pair<Double, Boolean> p = dfs(graph, visited, q.get(0), q.get(1), found);
            if (p.getValue()) {
                res.add(p.getKey());

                graph.get(q.get(0)).put(q.get(1), Double.valueOf(p.getKey()));
                graph.get(q.get(1)).put(q.get(0), Double.valueOf(1.0 / p.getKey()));

            } else {
                res.add(-1.0);
            }
        }

        double[] results = new double[res.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = res.get(i);
        }
        return results; //ArrayUtils.toPrimitive(res.toArray(new Double[res.size()]));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void unittest1() {
        List<List<String>> equations = new ArrayList<List<String>>() {{ // [ ["a", "b"], ["b", "c"] ],
            add(new ArrayList<String>() {{ add("a"); add("b"); }});
            add(new ArrayList<String>() {{ add("b"); add("c"); }});
        }};
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<List<String>>() {{ //[ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
            add(new ArrayList<String>() {{ add("a"); add("c"); }});
            add(new ArrayList<String>() {{ add("b"); add("a"); }});
            add(new ArrayList<String>() {{ add("a"); add("e"); }});
            add(new ArrayList<String>() {{ add("a"); add("a"); }});
            add(new ArrayList<String>() {{ add("x"); add("x"); }});
        }};
        double[] bs = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(bs)); // [6.0, 0.5, -1.0, 1.0, -1.0 ].
    }
    public void unittest2() {
        List<List<String>> equations = new ArrayList<List<String>>() {{ // [["a","b"],["b","c"],["bc","cd"]]
            add(new ArrayList<String>() {{ add("a"); add("b"); }});
            add(new ArrayList<String>() {{ add("b"); add("c"); }});
            add(new ArrayList<String>() {{ add("bc"); add("cd"); }});
        }};
        double[] values = new double[] {1.5,2.5,5.0}; //[1.5,2.5,5.0]
        List<List<String>> queries = new ArrayList<List<String>>() {{ // [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
            add(new ArrayList<String>() {{ add("a"); add("c"); }});
            add(new ArrayList<String>() {{ add("c"); add("b"); }});
            add(new ArrayList<String>() {{ add("bc"); add("cd"); }});
            add(new ArrayList<String>() {{ add("cd"); add("bc"); }});
        }};
        double[] bs = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(bs)); // [3.75,0.4,5.0,0.2]
    }

    public static void main(String[] args) {
        EvaluateDivision a = new EvaluateDivision();
        //a.unittest1();
        a.unittest2();
    }
}





