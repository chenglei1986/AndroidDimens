package com.github.chenglei1986.androiddimens;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String outputPath = "/dimen_root"; // 生成dimen文件的路径
        int baseScreenWidthPx = 1080; // UI设计图的屏幕宽度（像素）
        int baseScreenHeightPx = 1920; // UI设计图的屏幕高度（像素）
        ArrayList<Integer> targetScreenWidthDipList = new ArrayList<>(); // 需要适配的屏幕宽度（dp）

        if (0 == args.length) {
            targetScreenWidthDipList.add(160);
            targetScreenWidthDipList.add(240);
            targetScreenWidthDipList.add(320);
            targetScreenWidthDipList.add(360);
            targetScreenWidthDipList.add(430);
            targetScreenWidthDipList.add(480);
            targetScreenWidthDipList.add(540);
            targetScreenWidthDipList.add(600);
        } else {
            try {
                for (int i = 0; i < args.length; i++) {
                    String arg = args[i];
                    if ("-b".equals(arg)) {
                        String argBasescreen = args[i + 1];
                        String[] baseScreens = argBasescreen.split(",");
                        baseScreenHeightPx = Integer.parseInt(baseScreens[0]);
                        baseScreenWidthPx = Integer.parseInt(baseScreens[1]);
                        continue;
                    } else if ("-o".equals(arg)) {
                        outputPath = args[i + 1];
                        continue;
                    } else if ("-s".equals(arg)) {
                        String argTargetScreenWidth = args[i + 1];
                        String[] targetScreens = argTargetScreenWidth.split(",");
                        for (String targetScreen : targetScreens) {
                            targetScreenWidthDipList.add(Integer.parseInt(targetScreen));
                        }
                        continue;
                    } else if ("-help".equalsIgnoreCase(arg) || "-?".equals(arg)) {
                        System.out.println("\n");
                        printHelpInfomations();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (null == outputPath) {
            System.out.println("\noutputPath must be set.\n");
            printHelpInfomations();
        } else if (baseScreenHeightPx <= 0) {
            System.out.println("\nbaseScreenHeightPx must be positive.\n");
            printHelpInfomations();
        } else if (baseScreenWidthPx <= 0) {
            System.out.println("\nbaseScreenWidthPx must be positive.\n");
            printHelpInfomations();
        } else if (targetScreenWidthDipList.isEmpty()) {
            System.out.println("\nat least 1 target screen width must be set.\n");
            printHelpInfomations();
        } else {
            DimenGenerator dimenGenerator = new DimenGenerator(outputPath, baseScreenWidthPx, baseScreenHeightPx);
            dimenGenerator.execute(targetScreenWidthDipList);
            System.out.println("The dimen files are successfully generated.");
        }
    }

    private static final void printHelpInfomations() {
        System.out.println(
                "example: java -jar AndroidDimens.jar -b 1920,1080 -o E:\\dimen_values -s 320,360,480\n\n"
                + "-b            base screen size split with ',' (e.g. -b height,width)\n"
                + "-o            output path of the generated files\n"
                + "-s            target screen width in dip split with ',' (e.g. -s 320,480,...)\n"
                + "-? -help      print help infomations"
        );
    }
}
