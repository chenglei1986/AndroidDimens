package com.github.chenglei1986.androiddimens;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DimenGenerator dimenGenerator = new DimenGenerator("/dimen_root", 750);
        ArrayList<Integer> screenWidthDipList = new ArrayList<>();
        screenWidthDipList.add(320);
        screenWidthDipList.add(360);
        screenWidthDipList.add(430);
        screenWidthDipList.add(480);
        screenWidthDipList.add(540);
        screenWidthDipList.add(600);
        dimenGenerator.execute(screenWidthDipList);
    }
}
