package com.zhy.poj.problem.snowflakesnowsnowflakes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, List<SnowFlakes>> map = new HashMap<Integer, List<SnowFlakes>>(100000);
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            int[] ints = new int[6];
            for (int index = 0; index < ints.length; index++) {
                ints[index] = scanner.nextInt();
            }
            SnowFlakes snowFlakes = new SnowFlakes(ints);
            if (ok) {
                continue;
            }
            int hash = snowFlakes.hash();
            if (map.containsKey(hash)) {
                List<SnowFlakes> list = map.get(hash);
                for (SnowFlakes flakes : list) {
                    if(flakes.isEquals(snowFlakes)) {
                        ok = true;
                        break;
                    }
                }
                list.add(snowFlakes);
            } else {
                map.put(hash, new ArrayList<SnowFlakes>());
                map.get(hash).add(snowFlakes);
            }
        }
        if (ok) {
            System.out.println("Twin snowflakes found.");
        } else {
            System.out.println("No two snowflakes are alike.");
        }
    }

    private static class SnowFlakes {
        public int[] value;

        SnowFlakes(int[] value) {
            this.value = value;
        }

        public int hash() {
            int s = 0;
            for (int i = 0; i < value.length; i++) {
                s += ((value[(i + 50) % 6] & value[(i + 1) % 6]) + value[i]) % 9833807;
            }
            return s;
        }

        public boolean isEquals(SnowFlakes other) {
            int i = value[0];
            for (int index = 0; index < other.value.length; index++) {
                if (other.value[index] == i) {
                    boolean ok = true;
                    for (int k = 1; k < 6; k++) {
                        if (other.value[(index + k) % 6] != value[k]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        return true;
                    }
                    ok = true;
                    for (int k = 1; k < 6; k++) {
                        if (other.value[(index - k + 6) % 6] != value[k]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        return true;
                    }
                }
            }
            return false;

        }

    }
}
