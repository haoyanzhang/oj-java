package com.zhy.poj.problem.rochambeau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            ArrayList<Relation> data = new ArrayList<Relation>();
            for (int i = 0; i < n; i++) {
                data.add(new Relation(scanner.next()));
            }
            List<Integer> result = new ArrayList<Integer>();
            int maxLine = 0;
            for (int i = 0; i < m; i++) {
                UnionSet unionSet = new UnionSet(m);
                boolean isOk = true;
                for (int line = 0; line < data.size(); line++) {
                    Relation datum = data.get(line);
                    if (datum.p1 == i || datum.p2 == i) {
                        continue;
                    }
                    UnionSet.QueryResult queryResult1 = unionSet.get(datum.p1);
                    UnionSet.QueryResult queryResult2 = unionSet.get(datum.p2);
                    if (queryResult1.root == queryResult2.root) {
                        int d = queryResult1.d - queryResult2.d;
                        if ((d - datum.result.getD()) % 3 == 0) {
                            continue;
                        } else {
                            isOk = false;
                            maxLine = Math.max(maxLine, line + 1);
                            break;
                        }
                    } else {
                        unionSet.merge(queryResult1.root, queryResult2.root, datum.result.getD());
                    }
                }
                if (isOk) {
                    result.add(i);
                }
            }
            if (result.isEmpty()) {
                System.out.println("Impossible");
            } else if (result.size() > 1) {
                System.out.println("Can not determine");
            } else {
                System.out.println("Player " + result.get(0) + " can be determined to be the judge after " + maxLine + " lines");
            }
        }
    }

    public static class UnionSet {

        int[] parent;
        int[] d;

        UnionSet(int i) {
            parent = new int[i];
            for (int i1 = 0; i1 < parent.length; i1++) {
                parent[i1] = i1;
            }
            d = new int[i];
        }

        QueryResult get(int i) {
            int dd = 0;
            while (parent[i] != i) {
                dd += d[i];
                i = parent[i];
            }
            return new QueryResult(i, dd);
        }

        void merge(int r1, int r2, int dd) {
            parent[r1] = r2;
            d[r1] = dd;
        }
        public static class QueryResult {
            public int root;
            public int d;

            public QueryResult(int root, int d) {
                this.root = root;
                this.d = d;
            }
        }
    }

    public static class Relation {
        public int p1;
        public int p2;
        public RESULT result;

        Relation(String s) {
            p1 = 0;
            p2 = 0;
            boolean isP2 = false;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    if (!isP2) {
                        p1 = p1 * 10 + c - '0';
                    } else {
                        p2 = p2 * 10 + c - '0';
                    }
                } else {
                    result = c == '>'? RESULT.P1_WIN: c == '<'? RESULT.P2_WIN: RESULT.DRAW;
                    isP2 = true;
                }
            }
        }

        enum RESULT {
            P1_WIN(1),
            P2_WIN(-1),
            DRAW(0);

            private int d;

            RESULT(int i) {
                this.d = i;
            }

            public int getD() {
                return d;
            }
        }
    }
}
