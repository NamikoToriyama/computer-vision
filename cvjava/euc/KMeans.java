package euc;

import java.awt.*;

/**
 * K-meansˡ�ˤ�륯�饹�����
 */
public class KMeans {
	int SIZE_RGB = 256 * 256 * 256;
	int idarray[] = null;
	int width, height, num;

	/**
	 * �����������㡧k-meansˡ�ˤ����ǥ��饹�����
	 */
	MyImage clustering(MyImage input, int n) {
		width = input.width;
		height = input.height;
		num = n;
		
		int counter;
	    double distance;
		Color centers[] = new Color[num];
		Color pcenters[] = new Color[num];


		// �����������ǡ����Τ���˥������ݤ���
		MyImage output = new MyImage(width, height);
		idarray = new int[width * height];

		// num�Ĥ��濴���ν���ͤ򻻽Ф���
		initCenters(centers, num);

		// ��«����ޤǥ��饹����󥰤�ȿ������
		for(counter = 1; ; counter++) {
			assignPixels(input, output, centers);
			distance = calcNewCenter(input, output, centers, pcenters);
			System.out.println("### clustering: counter=" + counter + " distance=" + distance);
			if(distance <= num * 1.0 || counter > 100) break;
			for(int i = 0; i < num; i++)
				centers[i] = pcenters[i];
		}

		// �����������ǡ������֤�
		return output;


	}


	/**
	 * num�Ĥ��濴���ν���ͤ򻻽Ф���
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
	 * �Ʋ��Ǥ�Ǥ�ᤤ���Υ��饹�������ƤϤ��
	 */
	void assignPixels(MyImage input, MyImage output, Color centers[]) {
		int r1, g1, b1, r2, g2, b2;
		double dist, mind;

		// �Ʋ��Ǥ��Ȥ�
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
		
				// ���ϲ�������RGB�ͤ�ȤäƤ���
				Color color1 = input.getColor(j, i);
				r1 = color1.getRed();
				g1 = color1.getGreen();
				b1 = color1.getBlue();
				
				// ���濴�����Ȥ�
				int id = -1;
				mind = 1.0e+30;
				for(int k = 0; k < num; k++) {

					// �濴����RGB�ͤ�ȤäƤ���
					r2 = centers[k].getRed();
					g2 = centers[k].getGreen();
					b2 = centers[k].getBlue();
					
					// �����濴�����Ǥ�ᤫ�ä��顢�����濴����Ͽ����
					dist = (double)(r2 - r1) * (double)(r2 - r1)
							+ (double)(g2 - g1) * (double)(g2 - g1)
							+ (double)(b2 - b1) * (double)(b2 - b1);
					if(dist < mind) {
						mind = dist;   id = k;
					}
				}
			
				// �Ǥ�ᤤID��Ͽ��������Ͽ����
				idarray[ii] = id;
				output.setColor(j,  i, centers[id]);

			}
		}
	}


	/**
	 * ������RGB�濴�ͷ��򻻽Ф���
	 */
	double calcNewCenter(MyImage input, MyImage output, Color[] centers, Color[] pcenters) {
		int[] rgbsum = new int[3 * num];
		int[] rgbcount = new int[num];
		int r1, g1, b1, r2, g2, b2;
		double dist;

		// �����
		for(int i = 0; i < num; i++) {
			rgbsum[3 * i] = rgbsum[3 * i + 1] = rgbsum[3 * i + 2] = rgbcount[i] = 0;
		}

		// �Ʋ��Ǥ��Ȥ�
		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
		
				// ���ϲ�����ID��Ȥ�
				int id = idarray[ii];
		
				// ���ϲ�����RGB�ͤ�û�����
				Color color1 = input.getColor(j, i);
				rgbcount[id] += 1;
				rgbsum[id * 3 + 0] += color1.getRed();
				rgbsum[id * 3 + 1] += color1.getGreen();
				rgbsum[id * 3 + 2] += color1.getBlue();
			}
		}
	

		// ���濴�����Ȥ�
		dist = 0.0;
		for(int i = 0, ii = 0; i < num; i++, ii += 3) {

			//
			// RGB�ͤ��濴���򻻽Ф���
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

			// ������濴���Ȥε�Υ�򻻽Ф���
			r2 = centers[i].getRed();
			g2 = centers[i].getGreen();
			b2 = centers[i].getBlue();

			dist += (double)(r2 - r1) * (double)(r2 - r1)
			     +  (double)(g2 - g1) * (double)(g2 - g1)
			     +  (double)(b2 - b1) * (double)(b2 - b1);
		}

		// ��Υ�����פ��֤�
		return dist;
	}
}





