
import java.awt.Color;

public class GammaCorrection {

    public static MyImage execute(MyImage input) {

        MyImage output = new MyImage(input.width, input.height);

        for (int i = 0; i < input.height; i++) {
            for (int j = 0; j < input.width; j++) {

                Color color1 = input.getColor(j, i);
                double r = 255.0 * Math.pow(color1.getRed() / 255.0, 1 / 1.5);
                double g = 255.0 * Math.pow(color1.getGreen() / 255.0, 1 / 2.0);
                double b = 255.0 * Math.pow(color1.getBlue() / 255.0, 1 / 0.5);
                Color color2 = new Color((int) r, (int) g, (int) b);
                output.setColor(j, i, color2);

            }
        }

        return output;
    }

}
