
import java.awt.Color;

public class Trim {

    public static MyImage execute(MyImage input) {

        // トリミングしたい場所の座標を設定する
        int sW = 0;
        int sH = 0;
        int w = 2050;
        int h = input.height ;

        // 状況に応じて変える
        int width = w - sW;
        int height = h - sH;

        MyImage output = new MyImage(width, height);

        for (int i = sH; i < height; i++) {
            for (int j = sW; j < width; j++) {
                Color color1 = input.getColor(j, i);
                output.setColor(j, i, color1);
            }
        }

        return output;
    }

}
