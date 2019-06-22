package euc;

import java.awt.*;

/**
 * ���������̾�����
 */
public class Scale {
	static double SCALEX = 2.0, SCALEY = 3.0;
	
	
	/**
	 * ���������̾�����
	��*/
	static MyImage execute(MyImage input) {
		int width1, height1, width2, height2, i, j;
		

		// �������ȿ������Υ��������������
		width1 = input.width;
		height1 = input.height;
		width2 = (int)(input.width * SCALEX);
		height2 = (int)(input.height * SCALEY);
		MyImage output = new MyImage(width2, height2);
	
		
		// �����������γƲ��Ǥ��Ȥ�
		for(i = 0; i < height2; i++) {
			for(j = 0; j < width2; j++) {
				double x1, y1, r, g, b;
				
				// ���������б�����x,y��ɸ�ͤ�׻�����
				x1 = calcX(j, i, width1, height1);
				y1 = calcY(j, i, width1, height1);

				// ����������RGB�ͤ򻻽Ф���
				calcRGB(input, output, x1, y1, j, i);

			}
		}

		// �����������ǡ������֤�
		return output;

	}

	
	/**
	 * ���������б�����X��ɸ�ͤ򻻽Ф���
	 */
	static double calcX(int x2, int y2, int width1, int height1) {
		double x = 0.0;

		// ���Ѵ��ʤΤǡ���������Ψ�εտ������
		x = x2 / SCALEX;

		// ���������ϰ���˼��ޤäƤ��뤫�ɤ�����ǧ����
		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	/**
	 * ���������б�����Y��ɸ�ͤ򻻽Ф���
	 */
	static double calcY(int x2, int y2, int width1, int height1) {
		double y = 0.0;

		// ���Ѵ��ʤΤǡ���������Ψ�εտ������
		y = y2 / SCALEY;

		// ���������ϰ���˼��ޤäƤ��뤫�ɤ�����ǧ����
		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	/**
	 * �������ΰ���(x1,y1)�ˤ�����RGB�ͤ򻻽Ф���
 	 * �ʤ��Υץ������Ǥ� Nearest Neighbor ����Ѥ����
	 */
	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		// ���Ȥ��٤����Ǥ����ꤹ��
		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		// RGB�ͤ��֤�
		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}


}
