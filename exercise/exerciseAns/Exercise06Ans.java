/**
 * @title javaPractice / exercise / Exercise06Ans
 * @content for, nested for, if, printf
 * @author shika
 * @date 2020-10-20
 */
/*
◆Exercise06
for文を用いて、九九を表示せよ。
表示の際、数字間にスペースを空け、
ひと桁の数字は更に空白を補い、下記のように正方形になるよう表示すること。

◇実行結果
 1  2  3  4  5  6  7  8  9
 2  4  6  8 10 12 14 16 18
 3  6  9 12 15 18 21 24 27
 4  8 12 16 20 24 28 32 36
 5 10 15 20 25 30 35 40 45
 6 12 18 24 30 36 42 48 54
 7 14 21 28 35 42 49 56 63
 8 16 24 32 40 48 56 64 72
 9 18 27 36 45 54 63 72 81
 */

package javaPractice.exercise;
/*
public class Exercise06Ans {

    public static void main(String[] args) {

        for(int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                //計算結果が10未満のものは半角スペースを補う。数字の前に空白を入れる。
                if (i*j < 10) {
                    System.out.print(" ");
                }

                System.out.print(i * j + " "); //数字間のスペースはここに
            }//for j
            System.out.println(); //for j を抜けたところで改行

        }//for i

    }//main()

}//class
*/
/*
 1  2  3  4  5  6  7  8  9
 2  4  6  8 10 12 14 16 18
 3  6  9 12 15 18 21 24 27
 4  8 12 16 20 24 28 32 36
 5 10 15 20 25 30 35 40 45
 6 12 18 24 30 36 42 48 54
 7 14 21 28 35 42 49 56 63
 8 16 24 32 40 48 56 64 72
 9 18 27 36 45 54 63 72 81
*/

//#######〔別解〕printf() version ######
public class Exercise06Ans {

    public static void main(String[] args) {

        for(int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {

                System.out.printf("%2d ", (i * j)); //数字間の半角スペースは「%2d」の後ろに置いてある。

            }//for j
            System.out.println(); //for j を抜けたところで改行
        }//for i

    }//main()

}//class

/*
＊実行結果(右詰め)
  System.out.printf("%2d ", (i * j));
 1  2  3  4  5  6  7  8  9
 2  4  6  8 10 12 14 16 18
 3  6  9 12 15 18 21 24 27
 4  8 12 16 20 24 28 32 36
 5 10 15 20 25 30 35 40 45
 6 12 18 24 30 36 42 48 54
 7 14 21 28 35 42 49 56 63
 8 16 24 32 40 48 56 64 72
 9 18 27 36 45 54 63 72 81

◆printf(): Exercise04〔ヒント〕参照
「%d」: int型の変数を代入して表示
「%2d」: 2桁で表示(右詰め)
「%-2d」:2桁で表示(左詰め)

＊左詰めの表示
  System.out.printf("%-2d ", (i * j));
1  2  3  4  5  6  7  8  9
2  4  6  8  10 12 14 16 18
3  6  9  12 15 18 21 24 27
4  8  12 16 20 24 28 32 36
5  10 15 20 25 30 35 40 45
6  12 18 24 30 36 42 48 54
7  14 21 28 35 42 49 56 63
8  16 24 32 40 48 56 64 72
9  18 27 36 45 54 63 72 81
*/