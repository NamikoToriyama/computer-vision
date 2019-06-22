package sjis;

/**
 * �R���s���[�^�r�W�����̃v���O���~���O�ۑ��main���\�b�h���܂ރN���X
 */
public class CvMain {

	/**
	 * 4�`6�͂̉ۑ�Ɋւ�镔���̃��\�b�h
	 */
	static void imageProcessing1() {

		// ���łɎ����Ă���摜�t�@�C���̖��O������
		String filename1 = "itot.jpg";

		// ���ꂩ��쐬����摜�t�@�C���̖��O������
		String filename2 = "copy.jpg";

		// �摜�f�[�^�{��
		MyImage image1, image2;
	
		// �摜�t�@�C����ǂݍ���
		image1 = JpegFileReader.read(filename1);

		// �摜�����F
		// �ȉ��̊֐��̂��������ꂩ��L���ɂ��āA�c����R�����g����
		{
			image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			//image2 = GammaCorrection.execute(image1);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Scale.execute(image1);
			//image2 = Rotation.execute(image1);
		}

		// BMP�摜�t�@�C���������o��
		JpegFileWriter.write(filename2, image2);

	}

	/** 
	 * 7�͂̉ۑ�Ɋւ�镔��
	 */
	static void imageProcessing2() {

		// ���łɎ����Ă���BMP�摜�t�@�C���̖��O������
		String filename1 = "itot.jpg";
		String filename2 = "ochatop.jpg";

		// ���ꂩ��쐬����BMP�摜�t�@�C���̖��O������
		String filename3 = "copy.jpg";

		// �摜�f�[�^�{��
		MyImage image1, image2, image3, image0;
	
	
		// �摜�t�@�C����ǂݍ���
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// �摜image1�ɑ΂��āAK-means�@����уN���}�L�[��K�p����
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		image0 = Chromakey.execute(image1, kmeans, 3);

		// �摜����������
		//image3 = VirtualStudio.execute(image1, image2, image0); 
		image3 = AlphaBlending.execute(image1, image2, image0); 	
		//image3 = Tiling.execute(image1, image2); 	

		// �摜�������ʂ��t�@�C���ɏ�������
		JpegFileWriter.write(filename3, image3);

	}

	/**
	 * main�֐�
	 */
	public static void main(String args[]) {

		// 4�`6�͂̉ۑ�ɒ��肷��Ƃ��́A��������L���ɂ���
		imageProcessing1();

		// 7�͂̉ۑ�ɒ��肷��Ƃ��́A��������L���ɂ���
		//imageProcessing2();

	}
}
