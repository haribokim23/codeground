package scpc7.p138;

// 제목 : 친구들

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    private static TreeMap<Integer, TreeSet<Integer>> tm;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            tm = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int d = j + Integer.parseInt(st.nextToken());

                if (d < n) {
                    if (tm.containsKey(j)) {
                        tm.get(j).add(d);
                    } else {
                        TreeSet<Integer> ts = new TreeSet<>();
                        ts.add(d);
                        tm.put(j, ts);
                    }

                    if (tm.containsKey(d)) {
                        tm.get(d).add(j);
                    } else {
                        TreeSet<Integer> ts = new TreeSet<>();
                        ts.add(j);
                        tm.put(d, ts);
                    }
                }
            }

            visited = new boolean[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    visit(j);
                    count++;
                }
            }

            System.out.println("Case #" + (i + 1) + "\n" + count);
        }
    }

    private static void visit(int index) {
        if (!visited[index]) {
            visited[index] = true;

            if (tm.containsKey(index)) {
                TreeSet<Integer> values = tm.get(index);

                for (int value : values) {
                    visit(value);
                }
            }
        }
    }
}
