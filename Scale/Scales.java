
import java.awt.*;


public class Scales {

	// 2枚の画像の長い辺に画像の大きさを合わせる
	// inputの大きさを変更する
	static MyImage execute(MyImage input, MyImage input2) {
		int i, j;
		double scaleX, scaleY, magni;
		scaleX = 0.5;
		
		double width1 = input.width;
		double height1 = input.height;
		double width2 = input2.width;
		double height2 = input2.height;
		
		scaleX = width2 / width1;
		scaleY = height2 / height1;
		magni = Math.min(scaleX,scaleY);
		int to_width = (int)(input.width * magni);
		int to_height = (int)(input.height * magni);
		MyImage output = new MyImage(to_width, to_height);
	
		
		for(i = 0; i < to_height; i++) {
			for(j = 0; j < to_width; j++) {
				double x1, y1, r, g, b;
				
				x1 = calcX(j, i, width1, height1, magni);
				y1 = calcY(j, i, width1, height1, magni);

				calcRGB(input, output, x1, y1, j, i);

			}
		}

		return output;

	}

	
	static double calcX(int x2, int y2, double width1, double height1, double scaleX) {
		double x = 0.0;

		x = x2 / scaleX;

		if(x < 0.0 || x > width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, double width1, double height1, double scaleY) {
		double y = 0.0;

		y = y2 / scaleY;

		if(y < 0.0 || y > height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}

}
