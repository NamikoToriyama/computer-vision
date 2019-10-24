
import java.awt.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class VirtualStudio2 {

    //　真ん中に画像を載せる
    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;
        int randomValue=0,randomValue_h=0;
        
        int width = (width1 > width2) ? width1 : width2;
        int height = (height1 > height2) ? height1 : height2;
        
        // 中心並べたいので真ん中になるように指定する
        randomValue = (width1 - width2)/2;
        randomValue_h = Math.abs(height1 - height2)/2;
        MyImage output = new MyImage(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (randomValue_h <= i && i < height1 + randomValue_h && randomValue <= j && j < width1 + randomValue) {
                    Color color0 = input0.getColor(j - randomValue, i-randomValue_h);
                    if (color0.getRed() != 0) {// 色が黒の場合はinput1の画素値を代入

                        Color color1 = input1.getColor(j - randomValue, i-randomValue_h);
                        output.setColor(j, i, color1);
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
