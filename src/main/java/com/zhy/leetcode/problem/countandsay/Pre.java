package com.zhy.leetcode.problem.countandsay;

public class Pre {

    public static void main(String[] args) {
        String[] result = new String[31];
        result[0] = "1";
        for (int i = 1; i < result.length; i++) {
            String last = result[i - 1];
            StringBuilder stringBuilder = new StringBuilder();
            Character lastChar = null;
            Integer num = 0;
            for (int j = 0; j < last.length(); j++) {
                if (lastChar == null) {
                    lastChar = last.charAt(j);
                    num ++;
                } else if (lastChar.equals(last.charAt(j))) {
                    num ++;
                } else {
                    stringBuilder.append(num)
                            .append(lastChar);
                    lastChar = last.charAt(j);
                    num = 1;
                }
            }
            stringBuilder.append(num)
                    .append(lastChar);
            result[i] = stringBuilder.toString();
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println("\"" + result[i] + "\",");
        }
    }
}
