/**
 * @title javaPractice / exercise / Exercise10Ans
 * @content 配列,(別解 二次元配列), ArraysIndexOutOfBoundsException, Scanner,
 *           while(true), break, continue, StringBuilder,
 *           フィールド, クラスファイルの実行
 * @author shika
 * @date 2020-10-22
 */
/*
 * ◆Exercise10
 * 同じフォルダ内にある [Exercise10.class]を
 * コマンドプロンプトのワークフォルダ(自分のjavaファイルを置いてるところ)にコピーし
 *
 * >java Exercise10 で実行する。
 * (classファイルはコンパイルした結果できたファイルなので、すでにコンパイル済)
 *
 * 実行動作を確認し、こういう動作をするプログラムを作成せよ。
 *
 * 問１ 横４×縦３で同様の動作を実現せよ。
 *
 * 問２ 横WIDTH×縦HEIGHTとし、
 *      横と縦の変更をフィールドの定数を変更すればできるようにしたい。
 *      問１で定数の計算式にしていた部分を WIDTHとHEIGHTを用いた式に修正せよ。
 *
 * 問３ 同様の動きを二次元配列を使って実現せよ。
 */
package javaPractice.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
//###### 問１fix 4×3 version ######
//マス目の横×縦を変数にしたversion
public class Exercise10Ans {
    private static int point; //駒の現在位置
    private static int prePoint;//駒の前位置をコピー
    private static int move;
    private static String[] square; //横４×縦３のマス目

    public static void main(String[] args) {
        //==== 初期設定 ====
        square = new String[12];

        //squareに全て「□」を入れて初期化
        for(int i = 0; i < square.length; i++) {
            square[i] = "□";
        }//for i

        //初期値 6番に◆を入れて駒とする
        point = 6;
        prePoint = point;
        move = 0;
        movePoint();

        //マス目の表示
        printSquare();

        //==== 移動の入力ループ ====
        loop:
        while(true) {
            Scanner scn = new Scanner(System.in);
            int input = -1;

            try {
                System.out.println("数字を入力すると移動します。");
                input = scn.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("整数で入力してください");
                continue loop;
            }

            //---- switch 入力分岐 ----
            //break loop, continue loopをするため、ここのメソッド分け不可

            switch (input) {
            case 0: //[0] 終了
                scn.close();
                break loop; //while loopを break

            case 2: //[2] ↓下へ移動
                checkDownable();
                break;
            case 4: //[4] ←左へ移動
                checkLeftable();
                break;
            case 6: //[6] →右へ移動
                checkRightable();
                break;
            case 8: //[8] ↑上へ移動
                checkUpable();
                break;

            default: //上記以外の不正入力
                System.out.println("[2][4][6][8][0] の数字で入力してください。");
                continue loop;
            }//switch

            //移動処理メソッド
            movePoint();

            //マス目を表示
            printSquare();
        }//while loop

        System.out.println("お疲れさまでした。");
    }//main()


    private static void checkDownable() {
        for (int i = 0; i < 4; i++) {
            //point が最下段にあるとき
            if (point == (8 + i)){
                move = -8;
                break;
            } else {
                move = 4;
            }
        }//for

    }//checkDownable()

    private static void checkLeftable() {
        for (int i = 0; i < 3; i++) {
            //pointが最左列にいる場合
            if(point == 4 * i) {
                move = 3;
                break;
            } else {
                move = -1;
            }
        }//for

    }//checkLeftable()

    private static void checkRightable() {
        for (int i = 0; i < 3; i++) {
            //pointが最右列にいる場合
            if(point == 3 + 4 * i) {
                move =  -3;
                break;
            } else {
                move = +1;
            }
        }//for

    }//checkeRightable()

    private static void checkUpable() {
        for (int i = 0; i < 4; i++) {
            //point が最上段にあるとき
            if (point == i ){
                move = 8;
                break;
            } else {
                move = -4;
            }
        }//for

    }//checkUpable()


    private static void movePoint() {
        prePoint = point;
        point += move;
        square[prePoint] = "□";
        square[point] = "◆";
    }//movePoint()

    //マス目の表示
    private static void printSquare() {
        StringBuilder bld = new StringBuilder();
        bld.append("　　 [↑8]\n");
        bld.append("[←4] 　　[6→]\n");
        bld.append("　　 [↓2] 　　[0]終了\n\n");

        bld.append("　　");
        for(int i = 0; i < square.length; i++) {

            bld.append(square[i]);

            if((i + 1) % 4 == 0) {
                bld.append("\n");
                bld.append("　　");
            }
        }//for i

        System.out.println(bld.toString());
    }//printSquare()

}//class
*/

//###### variable WIDTH & HEIGHT version ######
//マス目の横×縦を変数にしたversion
public class Exercise10Ans {
    private static int point; //駒の現在位置
    private static int prePoint;//駒の前位置をコピー
    private static int move;
    private static final int WIDTH = 4; //マス目の横幅
    private static final int HEIGHT = 3;//マス目の縦高
    private static String[] square; //横WIDTH×縦HEIGHTのマス目

    public static void main(String[] args) {
        //==== 初期設定 ====
        square = new String[WIDTH * HEIGHT];

        //squareに全て「□」を入れて初期化
        for(int i = 0; i < square.length; i++) {
            square[i] = "□";
        }//for i

        //初期値 6番に◆を入れて駒とする
        point = 6;
        prePoint = point;
        move = 0;
        movePoint();

        //マス目の表示
        printSquare();

        //==== 移動の入力ループ ====
        loop:
        while(true) {
            Scanner scn = new Scanner(System.in);
            int input = -1;

            try {
                System.out.println("数字を入力すると移動します。");
                input = scn.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("整数で入力してください");
                continue loop;
            }

            //---- switch 入力分岐 ----
            //break loop, continue loopをするため、ここのメソッド分け不可

            switch (input) {
            case 0: //[0] 終了
                scn.close();
                break loop; //while loopを break

            case 2: //[2] ↓下へ移動
                checkDownable();
                break;
            case 4: //[4] ←左へ移動
                checkLeftable();
                break;
            case 6: //[6] →右へ移動
                checkRightable();
                break;
            case 8: //[8] ↑上へ移動
                checkUpable();
                break;

            default: //上記以外の不正入力
                System.out.println("[2][4][6][8][0] の数字で入力してください。");
                continue loop;
            }//switch

            //移動処理メソッド
            movePoint();

            //マス目を表示
            printSquare();
        }//while loop

        System.out.println("お疲れさまでした。");
    }//main()


    private static void checkDownable() {
        for (int i = 0; i < WIDTH; i++) {
            //point が最下段にあるとき
            if (point == (WIDTH * (HEIGHT - 1) + i)){
                move = -(WIDTH * (HEIGHT - 1));
                break;
            } else {
                move = WIDTH;
            }
        }//for

    }//checkDownable()

    private static void checkLeftable() {
        for (int i = 0; i < HEIGHT; i++) {
            //pointが最左列にいる場合
            if(point == WIDTH * i) {
                move = (WIDTH - 1);
                break;
            } else {
                move = -1;
            }
        }//for

    }//checkLeftable()

    private static void checkRightable() {
        for (int i = 0; i < HEIGHT; i++) {
            //pointが最右列にいる場合
            if(point == (WIDTH - 1) + WIDTH * i) {
                move =  -(WIDTH - 1);
                break;
            } else {
                move = +1;
            }
        }//for

    }//checkeRightable()

    private static void checkUpable() {
        for (int i = 0; i < WIDTH; i++) {
            //point が最上段にあるとき
            if (point == i ){
                move = WIDTH * (HEIGHT - 1);
                break;
            } else {
                move = -(WIDTH);
            }
        }//for

    }//checkUpable()


    private static void movePoint() {
        prePoint = point;
        point += move;
        square[prePoint] = "□";
        square[point] = "◆";
    }//movePoint()

    //マス目の表示
    private static void printSquare() {
        StringBuilder bld = new StringBuilder();
        bld.append("　　 [↑8]\n");
        bld.append("[←4] 　　[6→]\n");
        bld.append("　　 [↓2] 　　[0]終了\n\n");

        bld.append("　　");
        for(int i = 0; i < square.length; i++) {

            bld.append(square[i]);

            if((i + 1) % WIDTH == 0) {
                bld.append("\n");
                bld.append("　　");
            }
        }//for i

        System.out.println(bld.toString());
    }//printSquare()

}//class

/*
C:\Users\6A16\Desktop>javac Exercise10.java -encoding UTF-8

C:\Users\6A16\Desktop>java Exercise10
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□◆□
　　□□□□
　　
数字を入力すると移動します。
2
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□□◆□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□◆□□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　◆□□□
　　
数字を入力すると移動します。
2
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　◆□□□
　　□□□□
　　□□□□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□◆
　　□□□□
　　□□□□
　　
数字を入力すると移動します。
8
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□□□◆
　　
数字を入力すると移動します。
6
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　◆□□□
　　
数字を入力すると移動します。
6
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□◆□□
　　
数字を入力すると移動します。
6
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□□◆□
　　
数字を入力すると移動します。
8
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□◆□
　　□□□□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□◆□□
　　□□□□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　◆□□□
　　□□□□
　　
数字を入力すると移動します。
8
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　◆□□□
　　□□□□
　　□□□□
　　
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□◆
　　□□□□
　　□□□□
　　
数字を入力すると移動します。
8
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□□□
　　□□□◆
　　
数字を入力すると移動します。
0
お疲れさまでした。

C:\Users\6A16\Desktop>java Exercise10
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□□◆□
　　□□□□
　　
数字を入力すると移動します。
1
[2][4][6][8][0] の数字で入力してください。
数字を入力すると移動します。
サン
整数で入力してください
数字を入力すると移動します。
4
　　 [↑8]
[←4] 　　[6→]
　　 [↓2] 　　[0]終了

　　□□□□
　　□◆□□
　　□□□□
　　
数字を入力すると移動します。
０
お疲れさまでした。
*/
