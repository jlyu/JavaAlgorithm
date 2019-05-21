/*93. Restore IP Addresses
* https://leetcode.com/problems/restore-ip-addresses/
* M

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

    Input: "25525511135"
    Output: ["255.255.11.135", "255.255.111.35"]
*
*
*
*  4-16
*  1111111
* */


package ds.string;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;

public class RestoreIpAddresses {
    private boolean isIp(String ip) {
        final Pattern PATTERN = Pattern.compile(
                "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

        return PATTERN.matcher(ip).matches();
    }

    private String ipTail(String s) {
        if (s.isEmpty() || s.length() > 3) { return ""; }
        Long ip = Long.valueOf(s);
        if (ip > 255 || (String.valueOf(ip).length() != s.length())) { return ""; }
        return s;
    }

    private List<String> restoreIp(String s, int p) {
        final int d = p;
        final int sl = s.length();
        if (sl > (5-d) * 3) { return null; }

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < Math.min(3, sl); i++) {
            String s1 = s.substring(0, i + 1);
            Long i1 = Long.valueOf(s1);

            if (i1 > 255 || (String.valueOf(i1).length() != s1.length())) { continue; }
            String s2 = s.substring(i + 1, s.length());

            if (d + 1 == 4) {
                String ip = this.ipTail(s2);
                if (ip.length() > 0) {
                    res.add(s1 + "." + ip);
                }
            } else {
                List<String> tmp = this.restoreIp(s2, d + 1);
                if (tmp == null) { continue; }
                for (int j = 0; j < tmp.size(); j++) {
                    res.add(s1 + "." + tmp.get(j));
                }

            }
        }
        return res;
    }



    public List<String> restoreIpAddresses(String s) {
        return this.restoreIp(s,1);
    }


    public static void main(String[] args) {
        RestoreIpAddresses ins = new RestoreIpAddresses();
        System.out.println( ins.restoreIpAddresses("25525511135") );
        System.out.println( ins.restoreIpAddresses("010010") ); //["0.10.0.10","0.100.1.0"]
        System.out.println( ins.restoreIpAddresses("255255255255") );
    }
}
