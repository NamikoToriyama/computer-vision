package euc;

import java.awt.Color;

/**
 * �����������㡧ǻø��ȿž����
 */
public class Negative {

	/**
	 * ǻøȿž��¹Ԥ���
	 */
	public static MyImage execute(MyImage input) {

		// ���ϲ�������ݤ���
		MyImage output = new MyImage(input.width, input.height);
	
		// �Ʋ��ǤˤĤ���
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				// ���ϲ����β����ͤ򥲥åȤ���
				Color color1 = input.getColor(j, i);

				// ȿž���������ͤη׻�
				int r = 255 - color1.getRed();
				int g = 255 - color1.getGreen();
				int b = 255 - color1.getBlue();
				Color color2 = new Color(r, g, b);

				// ���ϲ����β����ͤ򥻥åȤ���
				output.setColor(j, i, color2);
			}
		}
		
		// ���ϲ������֤�
		return output;
	}

}

