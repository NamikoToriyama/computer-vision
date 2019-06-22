package sjis;

import java.awt.*;

/**
 * �摜�����̗�F�o�[�`�����X�^�W�I���̉摜����
 */
public class VirtualStudio {

	/**
	 * �摜�����̗�F�o�[�`�����X�^�W�I���̉摜����
	 */
	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;
	
		// �o�͉摜�̊m��
		MyImage output = new MyImage(width, height);

		// �e��f���Ƃ�
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				// image0�̉�f�l���Q��
				if(i < height1 && j < width1) {

					// image0�̉�f�l�����łȂ����
					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) {
				
						// �V�����摜��image1�̉�f�l����
						Color color1 = input1.getColor(j, i);
						output.setColor(j, i, color1);
				
						// true�ł���΁Ainput1�̉�f�l�����ς݂ł���
						isProcessed = true;
					}
					
				}

				// image2�̉�f�l���Q��
				if(i < height2 && j < width2) {
					if(isProcessed == false) {
						
						// �V�����摜��input2�̉�f�l����
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		// �V�����摜�f�[�^��Ԃ�
		return output;

	}

}