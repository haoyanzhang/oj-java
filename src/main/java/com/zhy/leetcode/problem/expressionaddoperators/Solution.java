package com.zhy.leetcode.problem.expressionaddoperators;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanghaoyan
 */
class Solution {

    public List<String> addOperators(String num, int target) {

        if (num.equals("")) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        Express express = new Express(Long.valueOf(num.substring(0, 1)));
        addOperators(num.toCharArray(), 1, express, target, result);
        return result;

    }

    private void addOperators(char[] chars, int from, Express curExpress, int target, List<String> result) {
        if (from == chars.length) {
            if (curExpress.doFinal() == target) {
                result.add(curExpress.getExpress());
            }
            return;
        }
        Long value = (long)(chars[from] - '0');
        addOperators(chars, from + 1, curExpress.copyOf().accept(Op.ADD, value), target, result);
        addOperators(chars, from + 1, curExpress.copyOf().accept(Op.SUB, value), target, result);
        addOperators(chars, from + 1, curExpress.copyOf().accept(Op.MUL, value), target, result);
        if (curExpress.canCon()) {
            addOperators(chars, from + 1, curExpress.copyOf().accept(Op.CON, value), target, result);
        }

    }

    private static class Express {

        private String express;

        private Express() {

        }

        public Express(Long value) {
            this.express = value + "";
            this.values[0] = value;
        }

        public Express copyOf() {
            Express express = new Express();
            express.express = this.express;
            express.pos = this.pos;
            express.ops = Arrays.copyOf(this.ops, 3);
            express.values = Arrays.copyOf(this.values, 3);
            return express;
        }

        public Express accept(Op op, Long value) {
            this.express = express + op.toString() + value;
            while (pos >= 1 && ops[pos].priority() >= op.priority() ) {
                values[pos - 1] = ops[pos].cal(values[pos - 1], values[pos]);
                pos--;

            }
            if (op.equals(Op.CON)) {
                values[pos] = Op.CON.cal(values[pos], value);
            } else {
                pos++;
                ops[pos] = op;
                values[pos] = value;
            }
            return this;
        }

        public boolean canCon() {
            return values[pos] != 0;
        }

        public Long doFinal() {
            while (pos >= 1) {
                values[pos - 1] = ops[pos].cal(values[pos - 1], values[pos]);
                pos--;
            }
            return values[0];
        }

        private int pos = 0;

        private Op[] ops = new Op[3];

        private Long[] values = new Long[3];

        public String getExpress() {
            return express;
        }

        public void setExpress(String express) {
            this.express = express;
        }
    }

    private enum Op {


        ADD {
            @Override
            public int priority() {
                return 0;
            }

            @Override
            public Long cal(Long l1, Long l2) {
                return l1 + l2;
            }

            @Override
            public String toString() {
                return "+";
            }
        },

        SUB {
            @Override
            public int priority() {
                return 0;
            }

            @Override
            public Long cal(Long l1, Long l2) {
                return l1 - l2;
            }

            @Override
            public String toString() {
                return "-";
            }
        },

        MUL {
            @Override
            public int priority() {
                return 1;
            }

            @Override
            public Long cal(Long l1, Long l2) {
                return l1 * l2;
            }

            @Override
            public String toString() {
                return "*";
            }
        },

        CON {
            @Override
            public int priority() {
                return 2;
            }

            @Override
            public Long cal(Long l1, Long l2) {
                return l1 * 10 + l2;
            }

            @Override
            public String toString() {
                return "";
            }
        };

        public abstract int priority();

        public abstract Long cal(Long l1, Long l2);

    }
}
