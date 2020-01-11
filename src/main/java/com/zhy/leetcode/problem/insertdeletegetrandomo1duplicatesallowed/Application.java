package com.zhy.leetcode.problem.insertdeletegetrandomo1duplicatesallowed;

public class Application {

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        randomizedCollection.insert(1);
        randomizedCollection.remove(0);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        System.out.println(randomizedCollection.getRandom());
    }
}
