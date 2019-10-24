
import java.awt.*;

public class Gradations {

    // アルファブレンディングの応用
    static MyImage execute(MyImage input1, MyImage input2) {

        // 横方向にブレンド
        return widthGrade(input1, input2);

        // 縦方向にブレンド
        // return heightGrade(input1, input2);

    }

    static MyImage widthGrade(MyImage input1, MyImage input2) {
        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;
        double a = 1.0;

        // width1の2/5だけ変化
        int gradeSize = width1 * 2 / 5;
        int width = width1 + width2 - gradeSize;
        int height = Math.min(height1, height2);

        MyImage output = new MyImage(width, height);

        // 途中まではinput1をいれていく
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width1 - gradeSize; j++) {
                Color color1 = input1.getColor(j, i);
                output.setColor(j, i, color1);
            }
        }

        System.out.println(1.0 / (double)gradeSize);

        // グラデーション部分
        for (int i = 0; i < height; i++) {
            for (int j = width1 - gradeSize; j < width1; j++) {

                if (i < height1 && j < width1) {

                    Color color1 = input1.getColor(j, i);
                    a -= 1.0 / (double)gradeSize;
                    if (a <= 0.0) a=0.0;

                    Color color2 = input2.getColor(j - width1 + gradeSize, i);
                    double r = a * (double) color1.getRed() + (1 - a) * (double) color2.getRed();
                    double g = a * (double) color1.getGreen() + (1 - a) * (double) color2.getGreen();
                    double b = a * (double) color1.getBlue() + (1 - a) * (double) color2.getBlue();
                    // System.out.println(r + " " +  a);
                
                    Color color3 = new Color((int) r, (int) g, (int) b);
                    output.setColor(j, i, color3);

                } else {
                    Color color3 = new Color(0,0,0);
                    output.setColor(j, i, color3);
                }
            }
            a = 1.0;
        }
        System.out.println("debug");

        // 残りはinput2をいれていく
        for (int i = 0; i < height; i++) {
            for (int j = width1; j < width; j++) {
                Color color1 = input2.getColor(j - width1 + gradeSize, i);
                output.setColor(j, i, color1);
            }
        }

    return output;

    }

    static MyImage heightGrade(MyImage input1, MyImage input2) {
        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;
        double a = 1.0;

        // width1の1/2だけ変化
        int gradeSize = height1 / 2;
        int width = height1 + height2 - gradeSize;
        int height = Math.min(width1, width2);

        MyImage output = new MyImage(width, height);

        // 途中まではinput1をいれていく
        for (int i = 0; i < height1 - gradeSize; i++) {
            for (int j = 0; j < width ; j++) {
                Color color1 = input1.getColor(j, i);
                output.setColor(j, i, color1);
            }
        }

        System.out.println(1.0 / (double)gradeSize);

        // グラデーション部分
        for (int j = 0; j < width; j++) {
            for (int i = gradeSize; i < height1; i++) {

                if (i < height1 && j < width1) {

                    Color color1 = input1.getColor(j, i);
                    a -= 1.0 / (double)gradeSize;
                    if (a <= 0.0) a=0.0;

                    Color color2 = input2.getColor(j, i - gradeSize);
                    double r = a * (double) color1.getRed() + (1 - a) * (double) color2.getRed();
                    double g = a * (double) color1.getGreen() + (1 - a) * (double) color2.getGreen();
                    double b = a * (double) color1.getBlue() + (1 - a) * (double) color2.getBlue();
                    // System.out.println(r + " " +  a);
                
                    Color color3 = new Color((int) r, (int) g, (int) b);
                    output.setColor(j, i, color3);

                } else {
                    Color color3 = new Color(0,0,0);
                    output.setColor(j, i, color3);
                }
            }
            a = 1.0;
        }
        System.out.println("debug");

        // 残りはinput2をいれていく
        for (int i = height1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color1 = input2.getColor(j, i - height1 + gradeSize);
                output.setColor(j, i, color1);
            }
        }

    return output;

    }

}
