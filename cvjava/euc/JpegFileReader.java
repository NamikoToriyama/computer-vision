package euc;

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**
 * JPEG�ե�������ɤ߹���
 */
public class JpegFileReader {

	/**
	 * JPEG�ե�������ɤ߹���
	 */
	public static MyImage read(String filename) {
		BufferedImage image = null;
		
		// �ե�����򳫤�
		try {
			image = ImageIO.read(new File(filename));
		} catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		
		// �ɤ߹���������β����ͤ�����
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
		
		// MyImage���饹����ݤ����֤�
		MyImage my = new MyImage(width, height, rgb);
		return my;
		
	}
	
}
