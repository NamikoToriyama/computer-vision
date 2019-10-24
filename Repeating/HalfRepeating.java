
import java.awt.*;

public class HalfRepeating {

	static MyImage execute(MyImage input1, MyImage input2) {

		int width1 = input1.width;
		int height1 = input1.height;

		MyImage output = new MyImage(width1*2+100, height1);


		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < height1; i++) {
				for (int j = 0; j < width1/2; j++) {
					if (i < height1 && j < width1) {
						Color color1 = input1.getColor(j, i);
						output.setColor((width1 / 2) * k + j, i, color1);
					} else { // どちらも画素がない場合
						Color color = new Color(0, 0, 0); // 白を代入している
						output.setColor((width1 / 2) * k + j, i, color);
					}
				}
			}
		}

		for (int i = 0; i < height1; i++) {
			for (int j = 0; j < 100; j++) {
				if (i < input2.height && j < input2.width) {
					Color color1 = input2.getColor(j, i);
					output.setColor(width1 + j, i, color1);
				} else { // どちらも画素がない場合
					Color color = new Color(0, 0, 0); // 白を代入している
					output.setColor(width1 + j, i, color);
				}
			}
		}

		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < height1; i++) {
				for (int j = width1/2; j < width1; j++) {
					if (i < height1 && j < width1) {
						Color color1 = input1.getColor(j, i);
						output.setColor(width1 + 100 + (width1 / 2) * k + j - width1/2, i, color1);
					} else { // どちらも画素がない場合
						Color color = new Color(0, 0, 0); // 白を代入している
						output.setColor(width1 + 100 + (width1 / 2) * k + j - width1/2, i, color);
					}
				}
			}
		}

		return output;

	}

}
