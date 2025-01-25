package scpc6.p123;

// 제목 : 다이어트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st1, st2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st1.nextToken());
                b[j] = Integer.parseInt(st2.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);
            int max = 0;

            for (int j = 0; j < k; j++) {
                int sum = a[j] + b[k - j - 1];

                if (sum > max) {
                    max = sum;
                }
            }

            sb.append("Case #").append(i + 1).append("\n").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
