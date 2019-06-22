package euc;

import java.awt.*;

/**
 * �����������㡧�С�����륹���������β�������
 */
public class VirtualStudio {

	/**
	 * �����������㡧�С�����륹���������β�������
	 */
	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
	
		// ���ϲ����γ���
		MyImage output = new MyImage(width, height);

		// �Ʋ��Ǥ��Ȥ�
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				// image0�β����ͤ򻲾�
				if(i < height1 && j < width1) {

					// image0�β����ͤ����Ǥʤ����
					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) {
				
						// ������������image1�β����ͤ�����
						Color color1 = input1.getColor(j, i);
						output.setColor(j, i, color1);
				
						// true�Ǥ���С�input1�β����ͤ������ѤߤǤ���
						isProcessed = true;
					}
					
				}

				// image2�β����ͤ򻲾�
				if(i < height2 && j < width2) {
					if(isProcessed == false) {
						
						// ������������input2�β����ͤ�����
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		// �����������ǡ������֤�
		return output;

	}

}