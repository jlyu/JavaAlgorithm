#!/usr/bin/python3
# -*- coding: utf8 -*

## 仅处理2点之间，带权有向无环图的最短路径（不考虑负权）

"""
        ┏━━(6)━━→A ━━(1)━━┓
        ┃            ↑             ↓
START ━┫           (3)           ┣━ END
 		┃		      ┃            ↑
        ┗━━(2)━━→B ━━(5)━━┛
"""

# Build Graph
graph = {}
graph["start"] = {}
graph["start"]["a"] = 6
graph["start"]["b"] = 2
graph["a"] = {}
graph["a"]["end"] = 1
graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["end"] = 5
graph["end"] = {}

# Build Cost
infinity = float("inf")
costs = {}
costs["a"] = 6
costs["b"] = 2
costs["end"] = infinity

# Build Parents
parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["end"] = None

# Build Processed
processed = []


def find_lowest_cost_node(costs):
	lowest_cost = float("inf")
	lowest_cost_node = None
	for node in costs:
		cost = costs[node]
		if cost < lowest_cost and node not in processed:
			lowest_cost = cost
			lowest_cost_node = node
	return lowest_cost_node



node = find_lowest_cost_node(costs)
while node is not None:
	cost = costs[node]
	neighbors = graph[node]
	for n in neighbors.keys():
		new_cost = cost + neighbors[n]
		if costs[n] > new_cost:
			costs[n] = new_cost
			parents[n] = node
	processed.append(node)
	node = find_lowest_cost_node(costs)

print(graph)
print(costs)
print(parents)
print(processed)
print(node)



