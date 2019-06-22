package sjis;

import java.awt.*;


/**
 * �摜�����̗�F�N���}�L�[����
 */
public class Chromakey {

	/**
	 * �摜�����̗�F�N���}�L�[����
	 */
	static MyImage execute(MyImage input, KMeans kmeans, int id) {

		int width = input.width;
		int height = input.height;
		MyImage output = new MyImage(width, height);

		//�e��f���Ƃ�
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
				
				if(kmeans.idarray[ii] == id)
					output.setColor(j, i, Color.black);
				else 
					output.setColor(j, i, Color.white);
			}	
		}
	
		// �V�����摜�f�[�^��Ԃ�
		return output;

	}
}
