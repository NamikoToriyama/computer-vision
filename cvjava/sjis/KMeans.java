package sjis;

import java.awt.*;

/**
 * K-means�@�ɂ��N���X�^�����O
 */
public class KMeans {
	int SIZE_RGB = 256 * 256 * 256;
	int idarray[] = null;
	int width, height, num;

	/**
	 * �摜�����̗�Fk-means�@�ɂ���f�N���X�^�����O
	 */
	MyImage clustering(MyImage input, int n) {
		width = input.width;
		height = input.height;
		num = n;
		
		int counter;
	    double distance;
		Color centers[] = new Color[num];
		Color pcenters[] = new Color[num];


		// �V�����摜�f�[�^�̂��߂Ƀ��������m�ۂ���
		MyImage output = new MyImage(width, height);
		idarray = new int[width * height];

		// num�̒��S�_�̏����l���Z�o����
		initCenters(centers, num);

		// ��������܂ŃN���X�^�����O�𔽕�����
		for(counter = 1; ; counter++) {
			assignPixels(input, output, centers);
			distance = calcNewCenter(input, output, centers, pcenters);
			System.out.println("### clustering: counter=" + counter + " distance=" + distance);
			if(distance <= num * 1.0 || counter > 100) break;
			for(int i = 0; i < num; i++)
				centers[i] = pcenters[i];
		}

		// �V�����摜�f�[�^��Ԃ�
		return output;


	}


	/**
	 * num�̒��S�_�̏����l���Z�o����
	 */
	void initCenters(Color[] centers, int num) {

		int i, r, g, b, value;

		for(i = 0; i < num; i++) {
			value = SIZE_RGB * i / (num + 1);
			r = value / (256 * 256);
			value -= r * 256 * 256;
			g = value / 256;
			value -= g * 256;
			b = value;
			centers[i] = new Color(r, g, b);
		}

	}


	/**
	 * �e��f���ł��߂��F�̃N���X�^�ɓ��Ă͂߂�
	 */
	void assignPixels(MyImage input, MyImage output, Color centers[]) {
		int r1, g1, b1, r2, g2, b2;
		double dist, mind;

		// �e��f���Ƃ�
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
		
				// ���͉摜����RGB�l���Ƃ��Ă���
				Color color1 = input.getColor(j, i);
				r1 = color1.getRed();
				g1 = color1.getGreen();
				b1 = color1.getBlue();
				
				// �e���S�_���Ƃ�
				int id = -1;
				mind = 1.0e+30;
				for(int k = 0; k < num; k++) {

					// ���S�_��RGB�l���Ƃ��Ă���
					r2 = centers[k].getRed();
					g2 = centers[k].getGreen();
					b2 = centers[k].getBlue();
					
					// ���̒��S�_���ł��߂�������A���̒��S�_���L�^����
					dist = (double)(r2 - r1) * (double)(r2 - r1)
							+ (double)(g2 - g1) * (double)(g2 - g1)
							+ (double)(b2 - b1) * (double)(b2 - b1);
					if(dist < mind) {
						mind = dist;   id = k;
					}
				}
			
				// �ł��߂�ID���L�^���A�F���L�^����
				idarray[ii] = id;
				output.setColor(j,  i, centers[id]);

			}
		}
	}


	/**
	 * �V����RGB���S�l�Q���Z�o����
	 */
	double calcNewCenter(MyImage input, MyImage output, Color[] centers, Color[] pcenters) {
		int[] rgbsum = new int[3 * num];
		int[] rgbcount = new int[num];
		int r1, g1, b1, r2, g2, b2;
		double dist;

		// ������
		for(int i = 0; i < num; i++) {
			rgbsum[3 * i] = rgbsum[3 * i + 1] = rgbsum[3 * i + 2] = rgbcount[i] = 0;
		}

		// �e��f���Ƃ�
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
		
				// �o�͉摜��ID���Ƃ�
				int id = idarray[ii];
		
				// ���͉摜��RGB�l�����Z����
				Color color1 = input.getColor(j, i);
				rgbcount[id] += 1;
				rgbsum[id * 3 + 0] += color1.getRed();
				rgbsum[id * 3 + 1] += color1.getGreen();
				rgbsum[id * 3 + 2] += color1.getBlue();
			}
		}
	

		// �e���S�_���Ƃ�
		dist = 0.0;
		for(int i = 0, ii = 0; i < num; i++, ii += 3) {

			//
			// RGB�l�̒��S�_���Z�o����
			//
			if(rgbcount[i] > 0) {
				rgbsum[ii + 0] /= rgbcount[i];
				rgbsum[ii + 1] /= rgbcount[i];
				rgbsum[ii + 2] /= rgbcount[i];
			}
			r1 = rgbsum[ii + 0];
			g1 = rgbsum[ii + 1];
			b1 = rgbsum[ii + 2];
			pcenters[i] = new Color(r1, g1, b1);

			// �{���̒��S�_�Ƃ̋������Z�o����
			r2 = centers[i].getRed();
			g2 = centers[i].getGreen();
			b2 = centers[i].getBlue();

			dist += (double)(r2 - r1) * (double)(r2 - r1)
			     +  (double)(g2 - g1) * (double)(g2 - g1)
			     +  (double)(b2 - b1) * (double)(b2 - b1);
		}

		// �����̑��v��Ԃ�
		return dist;
	}
}





