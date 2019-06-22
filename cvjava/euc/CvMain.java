package euc;

/**
 * ����ԥ塼���ӥ����Υץ�����ߥ󥰲����main�᥽�åɤ�ޤ९�饹
 */
public class CvMain {

	/**
	 * 4��6�Ϥβ���˴ؤ����ʬ�Υ᥽�å�
	 */
	static void imageProcessing1() {

		// ���Ǥ˻��äƤ�������ե������̾�����
		String filename1 = "itot.jpg";

		// ���줫�������������ե������̾�����
		String filename2 = "copy.jpg";

		// �����ǡ�������
		MyImage image1, image2;
	
		// �����ե�������ɤ߹���
		image1 = JpegFileReader.read(filename1);

		// ����������
		// �ʲ��δؿ��Τ��������줫��ͭ���ˤ��ơ��Ĥ�򥳥��Ȥ���
		{
			image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			//image2 = GammaCorrection.execute(image1);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Scale.execute(image1);
			//image2 = Rotation.execute(image1);
		}

		// BMP�����ե������񤭽Ф�
		JpegFileWriter.write(filename2, image2);

	}

	/** 
	 * 7�Ϥβ���˴ؤ����ʬ
	 */
	static void imageProcessing2() {

		// ���Ǥ˻��äƤ���BMP�����ե������̾�����
		String filename1 = "itot.jpg";
		String filename2 = "ochatop.jpg";

		// ���줫���������BMP�����ե������̾�����
		String filename3 = "copy.jpg";

		// �����ǡ�������
		MyImage image1, image2, image3, image0;
	
	
		// �����ե�������ɤ߹���
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// ����image1���Ф��ơ�K-meansˡ����ӥ����ޥ�����Ŭ�Ѥ���
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		image0 = Chromakey.execute(image1, kmeans, 3);

		// �������������
		image3 = VirtualStudio.execute(image1, image2, image0); 
		// image3 = AlphaBlending.execute(image1, image2, image0); 	
		//image3 = Tiling.execute(image1, image2); 	

		// ����������̤�ե�����˽񤭹���
		JpegFileWriter.write(filename3, image3);

	}

	/**
	 * main�ؿ�
	 */
	public static void main(String args[]) {

		// 4��6�Ϥβ������ꤹ��Ȥ��ϡ����ä���ͭ���ˤ���
		imageProcessing1();

		// 7�Ϥβ������ꤹ��Ȥ��ϡ����ä���ͭ���ˤ���
		//imageProcessing2();

	}
}
