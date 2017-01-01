package com.github.chenglei1986.androiddimens;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DimenGenerator {

    private final String valuesDirectory;
    private final int baseScreenWidth;

    public DimenGenerator(String targetDir, int baseScreenWidthPx) {
        this.valuesDirectory = targetDir + "/values-sw{width}dp";
        this.baseScreenWidth = baseScreenWidthPx;
    }

    public void execute(ArrayList<Integer> screenWidthDipList) {
        for (int screenWidthDip : screenWidthDipList) {
            String dimenRootPath = valuesDirectory.replace("{width}", String.valueOf(screenWidthDip));
            String dimenPath = dimenRootPath + "/dimens.xml";

            StringBuffer sb = new StringBuffer();
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
            sb.append("<resources>\n");

            float dp = (float) screenWidthDip / baseScreenWidth;
            for (int i = 0; i < 4000; i++) {
                sb.append("    <dimen name=\"w_");
                sb.append(String.valueOf(i + 1));
                sb.append("px\">");
                sb.append(dp * (i + 1));
                sb.append("dp</dimen>\n");
            }
            sb.append("</resources>");

            File dimenRoot = new File(dimenRootPath);
            if (!dimenRoot.exists()) {
                dimenRoot.mkdirs();
            }
            File dimen = new File(dimenPath);
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(dimen));
                pw.print(sb.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
