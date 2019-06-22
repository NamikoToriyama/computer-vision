package sjis;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;

/**
 * JPEG�t�@�C���̏�������
 */
public class JpegFileWriter {

	/**
	 * JPEG�t�@�C���̏�������
	 */
	public static void write(String filename, MyImage myimage) {

		// �o�͉\�ȃN���X�ɉ摜�����R�s�[����
		BufferedImage image =
				new BufferedImage(myimage.width, myimage.height, BufferedImage.TYPE_INT_RGB);
		for(int i = 0; i < myimage.height; i++) {
			for(int j = 0; j < myimage.width; j++) {
				Color color = myimage.getColor(j, i);
				int value = color.getRGB();
				image.setRGB(j, i, value);
			}
		}
		
		// �t�@�C���o�͂���
		try {
			ImageIO.write(image, "jpeg", new File(filename));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
