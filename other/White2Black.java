
import java.awt.Color;

public class White2Black {
    // 白背景を黒背景にする
    public static MyImage execute(MyImage input) {

        MyImage output = new MyImage(input.width, input.height);
        Color color2;

        for (int i = 0; i < input.height; i++) {
            for (int j = 0; j < input.width; j++) {

                Color color1 = input.getColor(j, i);

                int rgb = color1.getRed() + color1.getGreen() + color1.getBlue();
                if (rgb > 550) {
                    color2 = new Color(30, 30, 30);
                } else {
                    color2 = input.getColor(j, i);
                }

                output.setColor(j, i, color2);
            }
        }

        return output;
    }

}
