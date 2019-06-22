package sjis;

import java.awt.*;

/**
 * �摜���g��k������
 */
public class Scale {
	static double SCALEX = 2.0, SCALEY = 3.0;
	
	
	/**
	 * �摜���g��k������
	�@*/
	static MyImage execute(MyImage input) {
		int width1, height1, width2, height2, i, j;
		

		// ���摜�ƐV�摜�̃T�C�Y���`����
		width1 = input.width;
		height1 = input.height;
		width2 = (int)(input.width * SCALEX);
		height2 = (int)(input.height * SCALEY);
		MyImage output = new MyImage(width2, height2);
	
		
		// �V�����摜�̊e��f���Ƃ�
		for(i = 0; i < height2; i++) {
			for(j = 0; j < width2; j++) {
				double x1, y1, r, g, b;
				
				// ���摜�̑Ή�����x,y���W�l���v�Z����
				x1 = calcX(j, i, width1, height1);
				y1 = calcY(j, i, width1, height1);

				// ���摜����RGB�l���Z�o����
				calcRGB(input, output, x1, y1, j, i);

			}
		}

		// �V�����摜�f�[�^��Ԃ�
		return output;

	}

	
	/**
	 * ���摜�̑Ή�����X���W�l���Z�o����
	 */
	static double calcX(int x2, int y2, int width1, int height1) {
		double x = 0.0;

		// �t�ϊ��Ȃ̂ŁA�摜�̔{���̋t�������߂�
		x = x2 / SCALEX;

		// ���摜�͈͓̔��Ɏ��܂��Ă��邩�ǂ����m�F����
		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	/**
	 * ���摜�̑Ή�����Y���W�l���Z�o����
	 */
	static double calcY(int x2, int y2, int width1, int height1) {
		double y = 0.0;

		// �t�ϊ��Ȃ̂ŁA�摜�̔{���̋t�������߂�
		y = y2 / SCALEY;

		// ���摜�͈͓̔��Ɏ��܂��Ă��邩�ǂ����m�F����
		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	/**
	 * ���摜�̈ʒu(x1,y1)�ɂ�����RGB�l���Z�o����
 	 * �i���̃v���O�����ł� Nearest Neighbor ���̗p����j
	 */
	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		// �Q�Ƃ��ׂ���f����肷��
		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		// RGB�l��Ԃ�
		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}


}
