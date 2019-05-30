
import java.awt.Color;

public class Binalization {

    public static MyImage execute(MyImage input) {

        MyImage output = new MyImage(input.width, input.height);
        Color color2;

        for (int i = 0; i < input.height; i++) {
            for (int j = 0; j < input.width; j++) {

                Color color1 = input.getColor(j, i);

                int rgb = color1.getRed() + color1.getGreen() + color1.getBlue();
                if (rgb > 350) {
                    color2 = new Color(255, 255, 255);
                } else {
                    color2 = new Color(0, 0, 0);
                }

                output.setColor(j, i, color2);
            }
        }

        return output;
    }

}
