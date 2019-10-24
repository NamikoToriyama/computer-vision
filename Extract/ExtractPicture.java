
import java.awt.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ExtractPicture {

    //　input2の画像から指定された部分をinput1の形で切り出すプログラム
    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;
        int randomValue=0,randomValue_h=0;
        
        System.out.println("input1> "+width1+" "+height1);
        System.out.println("input2> "+width2+" "+height2);

        // 抽出箇所をセットする
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input x y > ");
            randomValue = scanner.nextInt(); // 横
            randomValue_h = scanner.nextInt(); // 高さ
            scanner.close();

          } catch (InputMismatchException e) { 
            System.out.println("整数を入力してください。");
          }

        MyImage output = new MyImage(width1, height1);

        for (int i = 0; i < height1; i++) {
            for (int j = 0; j < width1; j++) {
                boolean isProcessed = false;
                if (randomValue_h <= i && i < height1 + randomValue_h && randomValue <= j && j < width1 + randomValue) {
                    Color color0 = input0.getColor(j, i);
                    if (color0.getRed() != 0) {// 色が黒でない場合はinput1の画素値を代入
                        Color color1 = input2.getColor(j - randomValue, i-randomValue_h);
                        output.setColor(j, i, color1);

                        isProcessed = true;
                    }

                }

                if (i < height2 && j < width2) { // 画素が入っていない部分は白を代入する
                    if (isProcessed == false) {
                        Color color2 = new Color(255,255,255);;
                        output.setColor(j, i, color2);
                    }
                }
            }
        }

        return output;

    }

}
