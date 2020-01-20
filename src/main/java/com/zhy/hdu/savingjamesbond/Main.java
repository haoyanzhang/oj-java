package com.zhy.hdu.savingjamesbond;

import java.text.DecimalFormat;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();

            double[][] data = new double[n + 2][n + 2];
            ArrayList<Point> points = new ArrayList<>(n + 1);
            points.add(new Point(0, 0));

            for (int i = 0; i < n; i++) {
                points.add(new Point(scanner.nextInt(), scanner.nextInt()));
            }

            if (l >= 42.5) {
                System.out.println("42.5 1");
                continue;
            }


            for (int i = 1; i < points.size(); i++) {
                double d = points.get(i).toStartPoint();
                data[i][0] = data[0][i] = d <= l? d: Double.MAX_VALUE;

            }

            for (int i = 1; i < points.size(); i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    double d = points.get(i).dis(points.get(j));
                    data[i][j] = data[j][i] = d <= l? d: Double.MAX_VALUE;
                }
            }

            for (int i = 1; i < points.size(); i++) {
                double d = points.get(i).toEdge();
                data[i][n + 1] = data[n + 1][i] = d <= l? d: Double.MAX_VALUE;

            }

            data[0][n+1] = data[n+1][0] = Double.MAX_VALUE;

            double[] dis = new double[n + 2];
            boolean[] visited = new boolean[n + 2];
            int[] time = new int[n + 2];
            Arrays.fill(time, Integer.MAX_VALUE);
            Arrays.fill(dis, Double.MAX_VALUE);
            dis[0] = 0;
            time[0] = 0;

            Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o1.dis, o2.dis);
                }
            });
            queue.add(new Node(0, 0D));
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (visited[poll.i]) {
                    continue;
                }
                visited[poll.i] = true;
                for (int i = 0; i < n + 2; i++) {
                    if (!visited[i] && data[poll.i][i] != Double.MAX_VALUE && Math.abs(dis[i] - dis[poll.i] + data[poll.i][i]) < 1e-4) {
                        time[i] = Math.min(time[i], time[poll.i] + 1);
                    } else if (!visited[i] && data[poll.i][i] != Double.MAX_VALUE && dis[i] > dis[poll.i] + data[poll.i][i]) {
                        dis[i] = dis[poll.i] + data[poll.i][i];
                        queue.offer(new Node(i, dis[i]));
                        time[i] = time[poll.i] + 1;
                    }
                }
            }

            if (dis[n + 1] == Double.MAX_VALUE) {
                System.out.println("can't be saved");
            } else {
                System.out.println(new DecimalFormat("0.00").format(dis[n + 1]) + " " + time[n + 1]);
            }
        }
    }

    private static class Point {

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;

        double dis(Point other) {
            return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
        }

        double toEdge() {
            double xToEdge;
            double yToEdge;
            if (x > 0) {
                xToEdge = 50 - x;
            } else {
                xToEdge = x + 50;
            }
            if (y > 0) {
                yToEdge = 50 - x;
            } else {
                yToEdge = x + 50;
            }
            return Math.min(xToEdge, yToEdge);
        }

        double toStartPoint() {
            double v = dis(new Point(0, 0)) - 7.5;
            return v > 0? v :0;
        }
    }

    private static class Node {

        public Node(int i, double dis) {
            this.i = i;
            this.dis = dis;

        }

        public int i;

        public double dis;
    }
}
