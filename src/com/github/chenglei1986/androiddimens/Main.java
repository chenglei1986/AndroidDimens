package com.github.chenglei1986.androiddimens;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String targetDir = "/dimen_root"; // 生成dimen文件的路径
        int baseScreenWidthPx = 750; // UI设计图的屏幕宽度（像素）
        int baseScrrenHeightPx = 1334; // UI设计图的屏幕高度（像素）
        DimenGenerator dimenGenerator = new DimenGenerator(targetDir, baseScreenWidthPx, baseScrrenHeightPx);
        // 需要适配的屏幕宽度（dp）
        ArrayList<Integer> screenWidthDipList = new ArrayList<>();
        screenWidthDipList.add(160);
        screenWidthDipList.add(240);
        screenWidthDipList.add(320);
        screenWidthDipList.add(360);
        screenWidthDipList.add(430);
        screenWidthDipList.add(480);
        screenWidthDipList.add(540);
        screenWidthDipList.add(600);
        dimenGenerator.execute(screenWidthDipList);
    }
}
