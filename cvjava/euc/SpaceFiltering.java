package euc;

import java.awt.*;


/**
 * ���֥ե��륿���
 */
public class SpaceFiltering {

	// ���֥ե��륿��󥰤�Ŭ�Ѥ�������
	static double filter[] = {
		0.33333,0,0,0,0.33333,0,0,0,0.33333
	};


	/**
	 * ���֥ե��륿��󥰤��Ѥ���������������
	 */
	static MyImage execute(MyImage input) {
		int width = input.width;
		int height = input.height;
		int n;
		MyImage output = new MyImage(width, height);
		
		// �Ʋ��Ǥ��Ȥ�
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				double valueR = 0.0, valueG = 0.0, valueB = 0.0;

				// ����β����ͤ�û�
				if(i > 0 && j > 0) {
					Color color = input.getColor(j-1, i-1);
					valueR += (double)color.getRed()   * filter[0];
					valueG += (double)color.getGreen() * filter[0];
					valueB += (double)color.getBlue()  * filter[0];
				}

				// ��β����ͤ�û�
				if(i > 0) {
					Color color = input.getColor(j, i-1);
					valueR += (double)color.getRed()   * filter[1];
					valueG += (double)color.getGreen() * filter[1];
					valueB += (double)color.getBlue()  * filter[1];
				}

				// ����β����ͤ�û�
				if(i > 0 && j < (width - 1)) {
					Color color = input.getColor(j+1, i-1);
					valueR += (double)color.getRed()   * filter[2];
					valueG += (double)color.getGreen() * filter[2];
					valueB += (double)color.getBlue()  * filter[2];
				}
			
				// ���β����ͤ�û�
				if(j > 0) {
					Color color = input.getColor(j-1, i);
					valueR += (double)color.getRed()   * filter[3];
					valueG += (double)color.getGreen() * filter[3];
					valueB += (double)color.getBlue()  * filter[3];
				}
				
				// Ʊ����Τβ����ͤ�û�
				{
				Color color = input.getColor(j, i);
				valueR += (double)color.getRed()   * filter[4];
				valueG += (double)color.getGreen() * filter[4];
				valueB += (double)color.getBlue()  * filter[4];
				}
		
				// ���β����ͤ�û�
				if(j < (width - 1)) {
					Color color = input.getColor(j+1, i);
					valueR += (double)color.getRed()   * filter[5];
					valueG += (double)color.getGreen() * filter[5];
					valueB += (double)color.getBlue()  * filter[5];
				}

				// �����β��ǤȤ����
				if(i < (height - 1) && j > 0) {
					Color color = input.getColor(j-1, i+1);
					valueR += (double)color.getRed()   * filter[6];
					valueG += (double)color.getGreen() * filter[6];
					valueB += (double)color.getBlue()  * filter[6];
				}

				// ���β��ǤȤ����
				if(i < (height - 1)) {
					Color color = input.getColor(j, i+1);
					valueR += (double)color.getRed()   * filter[7];
					valueG += (double)color.getGreen() * filter[7];
					valueB += (double)color.getBlue()  * filter[7];
				}

				// �����β��ǤȤ����
				if(i < (height - 1) && j < (width - 1)) {
					Color color = input.getColor(j+1, i+1);
					valueR += (double)color.getRed()   * filter[8];
					valueG += (double)color.getGreen() * filter[8];
					valueB += (double)color.getBlue()  * filter[8];
				}

				// valueR, valueG, valueB ���ͤ�0��255���ϰϤˤ���
				if(valueR < 0.0) valueR = 0.0;
				if(valueR > 255.0) valueR =255.0;
				if(valueG < 0.0) valueG = 0.0;
				if(valueG > 255.0) valueG =255.0;
				if(valueB < 0.0) valueB = 0.0;
				if(valueB > 255.0) valueB =255.0;

				// ���ϲ������ͤ����ꤹ��
				Color color2 = new Color((int)valueR, (int)valueG, (int)valueB);
				output.setColor(j, i, color2);
			}
		}
		
		// �����������ǡ������֤�
		return output;
	}


}