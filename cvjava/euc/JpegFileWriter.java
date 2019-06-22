package euc;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;

/**
 * JPEG�ե�����ν񤭹���
 */
public class JpegFileWriter {

	/**
	 * JPEG�ե�����ν񤭹���
	 */
	public static void write(String filename, MyImage myimage) {

		// ���ϲ�ǽ�ʥ��饹�˲�������򥳥ԡ�����
		BufferedImage image =
				new BufferedImage(myimage.width, myimage.height, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < myimage.height; i++) {
			for(int j = 0; j < myimage.width; j++) {
				Color color = myimage.getColor(j, i);
				int value = color.getRGB();
				image.setRGB(j, i, value);
			}
		}
		
		// �ե�������Ϥ���
		try {
			ImageIO.write(image, "jpeg", new File(filename));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
