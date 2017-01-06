package com.github.chenglei1986.androiddimens;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DimenGenerator {

    private final String outputPath;
    private final int baseScreenWidth;
    private final int baseScreenHeightPx;

    public DimenGenerator(String outputPath, int baseScreenWidthPx, int baseScreenHeightPx) {
        this.outputPath = outputPath + "/values-sw{width}dp";
        this.baseScreenWidth = baseScreenWidthPx;
        this.baseScreenHeightPx = baseScreenHeightPx;

        if (null == outputPath) {
            throw new IllegalArgumentException("outputPath for saving generated files must not be empty!");
        }

        if (baseScreenWidthPx <= 0 || baseScreenHeightPx <= 0) {
            throw new IllegalArgumentException("The value of base screen size must be positive!");
        }
    }

    public void execute(ArrayList<Integer> screenWidthDipList) {
        for (int screenWidthDip : screenWidthDipList) {
            String dimenRootPath = outputPath.replace("{width}", String.valueOf(screenWidthDip));
            String dimenPath = dimenRootPath + "/dimens.xml";

            StringBuffer sb = new StringBuffer();
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
            sb.append("<resources>\n");

            float dp = (float) screenWidthDip / baseScreenWidth;
            for (int i = 0; i < baseScreenHeightPx; i++) {
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
