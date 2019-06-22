package sjis;

import java.awt.Color;

public class MyImage {

	// �������Əc�����̉�f��
	int width, height;
	
	// ��f�l
	int pixelarray[];
	
	
	/**
	 * Constructor
	 */
	public MyImage(int w, int h) {
		width = w;   height = h;
		pixelarray = new int[w * h];
	}
	
	/**
	 * Constructor
	 */
	public MyImage(int w, int h, int array[]) {
		width = w;   height = h;
		pixelarray = array;
	}
	
	/**
	 * ����̉�f�l���Z�b�g����
	 */
	public void setColor(int j, int i, Color color) {
		int id = i * width + j;
		int value = color.getRGB();
		pixelarray[id] = value;
	}
	
	/**
	 * ����̂��[�u���Q�b�g����
	 */
	public Color getColor(int j, int i) {
		int id = i * width + j;
		Color color = new Color(pixelarray[id]);
		return color;
	}
	
}
