import java.awt.*;
import java.util.Scanner;
import java.util.InputMismatchException;

// コアの座標と色を格納するクラス
class CoreColor {
    public int x, y;
    public Color color;
}

public class StainedGlass {

    static MyImage execute(MyImage input) {
        // ステンドグラス画像の作成
        int x, y;
        int width, height, coreNum=0;

        // 画像サイズの取得
        width = input.width;
        height = input.height;

        // コア数をセットする
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input コア数> ");
            coreNum = scanner.nextInt(); // 横
            scanner.close();

        } catch (InputMismatchException e) {
            System.out.println("整数を入力してください。");
        }

        // コアを乱数で決める
        CoreColor core[] = new CoreColor[coreNum];
        for (int i = 0; i < coreNum; ++i) {
            // 乱数を発生し、適当に座標を求める
            core[i] = new CoreColor();
            core[i].x = (int) (Math.random() * (double) width);
            core[i].y = (int) (Math.random() * (double) height);
            core[i].color = input.getColor(core[i].x, core[i].y);
        }

        // 全ての画素の座標(x,y)から最も近いコアを求め
        // そのコアの色を(x,y)に置く
        for (y = 0; y < height; ++y) {
            for (x = 0; x < width; ++x) {
                int minLength = 10000000;
                Color newColor = input.getColor(x, y);
                // 一番近いコアを求める
                for (int i = 0; i < coreNum; ++i) {
                    // 距離の２乗を計算
                    int dx = core[i].x - x;
                    int dy = core[i].y - y;
                    int l = dx * dx + dy * dy;

                    if (l < minLength) {
                        minLength = l;
                        newColor = core[i].color;
                    }
                }
                input.setColor(x, y, newColor);
            }
        }
        return input;
    }

}
