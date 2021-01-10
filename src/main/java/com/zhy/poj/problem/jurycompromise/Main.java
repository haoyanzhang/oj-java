package com.zhy.poj.problem.jurycompromise;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int index = 1;

        while (true) {
            int m = scanner.nextInt();
            int p = scanner.nextInt();

            if (m == 0 && p == 0) {
                return;
            }

            ArrayList<HashMap<Integer, DpNode>> dp = new ArrayList<HashMap<Integer, DpNode>>();

            for (int i = 0; i <= p; i++) {
                dp.add(new HashMap<Integer, DpNode>());
            }

            dp.get(0).put(0, new DpNode(0, 0, 0));

            int cIndex = 1;
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                for (int j = dp.size() - 2; j >= 0; j--) {
                    for (Map.Entry<Integer, DpNode> entry : dp.get(j).entrySet()) {
                        DpNode value = entry.getValue();
                        Integer c = entry.getKey();
                        if (dp.get(j + 1).containsKey(c + a - b)) {
                            if (value.s + a + b > dp.get(j + 1).get(c + a - b).s) {
                                DpNode dpNode = new DpNode(value.s + a + b, value.a + a, value.b + b);
                                dpNode.chose.addAll(value.chose);
                                dpNode.chose.add(cIndex);
                                dp.get(j + 1).put(c + a - b, dpNode);
                            }
                        } else {
                            DpNode dpNode = new DpNode(value.s + a + b, value.a + a, value.b + b);
                            dpNode.chose.addAll(value.chose);
                            dpNode.chose.add(cIndex);
                            dp.get(j + 1).put(c + a - b, dpNode);
                        }
                    }
                }
                cIndex++;
            }

            int minC = Integer.MAX_VALUE;
            DpNode result = null;

            for (Map.Entry<Integer, DpNode> entry : dp.get(dp.size() - 1).entrySet()) {
                if (Math.abs(entry.getKey()) < minC || (Math.abs(entry.getKey()) == minC && entry.getValue().s > result.s)) {
                    minC = Math.abs(entry.getKey());
                    result = entry.getValue();
                }
            }

            System.out.println("Jury #" + index);
            index++;
            System.out.println("Best jury has value " + result.a + " for prosecution and value " + result.b + " for defence:");
            for (Integer integer : result.chose) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }
    }

    private static class DpNode {

        public DpNode(int s, int a, int b) {
            this.s = s;
            this.a = a;
            this.b = b;
            chose = new ArrayList<Integer>();
        }


        public int s;

        public int a;

        public int b;

        public List<Integer> chose;
    }


}
