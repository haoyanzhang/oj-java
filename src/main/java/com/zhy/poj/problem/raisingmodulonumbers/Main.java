package com.zhy.poj.problem.raisingmodulonumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            long mod = scanner.nextLong();
            int n = scanner.nextInt();
            long res = 0;
            for (int k = 0; k < n; k++) {
                long a = scanner.nextLong();
                long b = scanner.nextLong();
                res = (res + pow(a, b, mod)) % mod;
            }
            System.out.println(res);
        }
    }

    public static long pow(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}
