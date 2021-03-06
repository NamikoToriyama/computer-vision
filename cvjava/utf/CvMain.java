package utf;

/**
 * コンピュータビジョンのプログラミング課題のmainメソッドを含むクラス
 */
public class CvMain {

	/**
	 * 4〜6章の課題に関わる部分のメソッド
	 */
	static void imageProcessing1() {

		// すでに持っている画像ファイルの名前を書く
		String filename1 = "itot.jpg";

		// これから作成する画像ファイルの名前を書く
		String filename2 = "copy.jpg";

		// 画像データ本体
		MyImage image1, image2;
	
		// 画像ファイルを読み込む
		image1 = JpegFileReader.read(filename1);

		// 画像処理：
		// 以下の関数のうちいずれかを有効にして、残りをコメントする
		{
			image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			//image2 = GammaCorrection.execute(image1);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Scale.execute(image1);
			//image2 = Rotation.execute(image1);
		}

		// BMP画像ファイルを書き出す
		JpegFileWriter.write(filename2, image2);

	}

	/** 
	 * 7章の課題に関わる部分
	 */
	static void imageProcessing2() {

		// すでに持っているBMP画像ファイルの名前を書く
		String filename1 = "itot.jpg";
		String filename2 = "ochatop.jpg";

		// これから作成するBMP画像ファイルの名前を書く
		String filename3 = "copy.jpg";

		// 画像データ本体
		MyImage image1, image2, image3, image0;
	
	
		// 画像ファイルを読み込む
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// 画像image1に対して、K-means法およびクロマキーを適用する
		KMeans kmeans = new KMeans();
		kmeans.clustering(image1, 6);
		image0 = Chromakey.execute(image1, kmeans, 3);

		// 画像を合成する
		image3 = VirtualStudio.execute(image1, image2, image0); 
		//image3 = AlphaBlending.execute(image1, image2, image0); 	
		//image3 = Tiling.execute(image1, image2); 	

		// 画像処理結果をファイルに書き込む
		JpegFileWriter.write(filename3, image3);

	}

	/**
	 * main関数
	 */
	public static void main(String args[]) {

		// 4〜6章の課題に着手するときは、こっちを有効にする
		imageProcessing1();

		// 7章の課題に着手するときは、こっちを有効にする
		//imageProcessing2();

	}
}
