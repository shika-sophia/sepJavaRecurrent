/**
 * @title javaPractice / exercise / Exercise12
 * @content 配列, Random, if, printf
 * @author shika
 * @date 2020-10-25
 */
/*
 * ◆Exercise12
 * 下記の実行結果になるような「じゃんけんゲーム」を作成せよ。
 * ただし、"グー","チョキ","パー"は、最初に１回だけ配列に記入し
 * 表示する際は配列から取り出すこと。
 *
 * また勝敗判定は switch((com - user + 3) % 3)で可能だが、
 * 練習のため 上記の式は使わず、if文で勝敗あいこの条件を考えましょう。
 *
◇実行結果
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
1
【YOU: チョキ】 vs 【COM : グー】

【あなたの負け】
--------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
2
【YOU: パー】 vs 【COM : グー】

【あなたの勝ち】
--------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
0
【YOU: グー】 vs 【COM : グー】

【あいこ】
--------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
5
0～2で入力してください。
--------------------------------
 */

import java.util.Random;
import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        String[] finger = new String[] {"グー","チョキ","パー"};

    }//main()

}//class

/*
《解説》
・printf()の解説は Exercise04〔ヒント〕参照。
  String結合「+」演算子でも同様の表示は可能です。長くなるけど

・for文による配列の表示は、よくある決まった型なので、
  配列とfor文をいつもセットで使うことに慣れておきましょう。

・配列を使う際に、ArrayIndexOutOfBoundsExceptionに気を付けましょう。
  この例外については Exercise10〔ヒント〕参照。

・配列のindexを扱う前に、不正な値が入らないようチェックしましょう。
  そうすれば、上記の例外は防げます。

・問題文に書いた勝敗判定式は庄司先生の「じゃんけんゲーム」に掲載。
  コードにすると、こんな感じ。とてもシンプルに勝敗あいこを判定できます。

    String result = "";

    switch ((com - user + 3) % 3 ) {
        case 0:
            result = "【DRAW: あいこ 】";
            break;

        case 1:
            result = "【YOU WIN: 勝ち 】";
            break;

        case 2:
            result = "【YOU LOSE: 負け 】";
            break;
    }//switch


//==== 実行結果 ====
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
1
【YOU: チョキ】 vs 【COM : グー】

【あなたの負け】
---------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
2
【YOU: パー】 vs 【COM : グー】

【あなたの勝ち】
---------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
0
【YOU: グー】 vs 【COM : グー】

【あいこ】
---------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
数字
整数で入力してください。
---------------------------------
数字を入力してください。
[0] グー, [1] チョキ, [2] パー,
5
0～2で入力してください。
---------------------------------
*/