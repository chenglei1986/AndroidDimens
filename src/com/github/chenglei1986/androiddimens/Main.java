package com.github.chenglei1986.androiddimens;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String targetDir = "/dimen_root"; // 生成dimen文件的路径
        int baseScreenWidthPx = 750; // UI设计图的窄边长度（像素）
        DimenGenerator dimenGenerator = new DimenGenerator(targetDir, baseScreenWidthPx);
        // 需要适配的屏幕宽度（dp）
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
