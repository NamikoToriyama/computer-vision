
import java.awt.*;


public class Tiling {

	static MyImage execute(MyImage input1, MyImage input2) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = width1 + width2;
		int height = (height1 > height2) ? height1 : height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
		
				if(i < height1 && j < width1) {
						Color color1 = input1.getColor(j, i);
						output.setColor(j, i, color1);
				}
                else if( i < height2 && width1 <= j) {
						Color color2 = input2.getColor(j - width1, i);
						output.setColor(j, i, color2);
					
                }
                else { // どちらも画素がない場合
                    Color color = new Color(255,255,255); // 白を代入している
                    output.setColor(j, i, color);
                }
			}
		}

		return output;

	}

}
