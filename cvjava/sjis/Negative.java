package sjis;

import java.awt.Color;

/**
 * �摜�����̗�F�Z�W�𔽓]����
 */
public class Negative {

	/**
	 * �Z�W���]�����s����
	 */
	public static MyImage execute(MyImage input) {

		// �o�͉摜���m�ۂ���
		MyImage output = new MyImage(input.width, input.height);
	
		// �e��f�ɂ���
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				// ���͉摜�̉�f�l���Q�b�g����
				Color color1 = input.getColor(j, i);

				// ���]������f�l�̌v�Z
				int r = 255 - color1.getRed();
				int g = 255 - color1.getGreen();
				int b = 255 - color1.getBlue();
				Color color2 = new Color(r, g, b);

				// �o�͉摜�̉�f�l���Z�b�g����
				output.setColor(j, i, color2);
			}
		}
		
		// �o�͉摜��Ԃ�
		return output;
	}

}

