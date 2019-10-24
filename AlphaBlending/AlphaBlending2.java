
import java.awt.*;
import java.util.Random;

public class AlphaBlending2 {

    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;
        double a = 0.5;
        
        int width = (width1 > width2) ? width1 : width2;
        int height = (height1 > height2) ? height1 : height2;

        // ランダムでitotの位置を変える
        Random random = new Random();
        int randomValue = random.nextInt(Math.abs(width-width1));
        int randomValue_h = random.nextInt(Math.abs(height-height1));

        MyImage output = new MyImage(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (randomValue_h <= i && i < height1 + randomValue_h && randomValue <= j && j < width1 + randomValue) {
                    Color color0 = input0.getColor(j - randomValue, i-randomValue_h);
                    if (color0.getRed() > 0) {// 色が黒でない場合はinput1の画素値を代入

                        Color color1 = input1.getColor(j - randomValue, i-randomValue_h);
                        if (i >= height2 || j >= width2) { // input上に画素がない場合
                            output.setColor(j, i, color1);
                        } else {
                            Color color2 = input2.getColor(j, i);
                            double r = a * (double) color1.getRed() + (1 - a) * (double) color2.getRed();
                            double g = a * (double) color1.getGreen() + (1 - a) * (double) color2.getGreen();
                            double b = a * (double) color1.getBlue() + (1 - a) * (double) color2.getBlue();

                            Color color3 = new Color((int) r, (int) g, (int) b);
                            output.setColor(j, i, color3);
                        }

                        isProcessed = true;
                    }

                }

                if (i < height2 && j < width2) { // input2の内部にあり画素値が代入されていない場合代入する
                    if (isProcessed == false) {
                        Color color2 = input2.getColor(j, i);
                        output.setColor(j, i, color2);
                    }
                }
            }
        }

        return output;

    }

}
