package sjis;

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**
 * JPEG�t�@�C���̓ǂݍ���
 */
public class JpegFileReader {

	/**
	 * JPEG�t�@�C���̓ǂݍ���
	 */
	public static MyImage read(String filename) {
		BufferedImage image = null;
		
		// �t�@�C�����J��
		try {
			image = ImageIO.read(new File(filename));
		} catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		
		// �ǂݍ��񂾉摜�̉�f�l�𓾂�
		int width = image.getWidth();
		int height = image.getHeight();
		int[] rgb = new int[width * height];
		PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, height, rgb, 0, width);
		try{
			grabber.grabPixels();
		} catch(InterruptedException e){
			e.printStackTrace();
			return null;
		}
		
		// MyImage�N���X���m�ۂ��ĕԂ�
		MyImage my = new MyImage(width, height, rgb);
		return my;
		
	}
	
}
