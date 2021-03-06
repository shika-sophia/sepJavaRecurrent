/**
 * @title javaSilver / javaSE11Black / Chapter01
 * @content package, import, main, command-prompt
 * @see 志賀澄人『徹底攻略 Java SE11 Silver 問題集[1ZO-815]』(黒本),インプレス, 2019
 * @date 2020-09-12 / 1730-1800
 * @correctRate ① 6.5 / 8 = 81.2％
 * @correctRate ②  8  / 8 = 100％
 * @correctRate ③87.50 ％ ( 〇7問 / 全8問 )
 */
/*
 * 〇1. A 名前空間, Cアクセス制御, Dクラス分類
 * 〇2. B
 * 〇3. A java.lang
 *      C 同 package
 * 〇4. C コンパイルエラー
 * 〇5. A public
 *      B static
 *      E String[] or String[]...
 * 〇6. B java one
 * 〇7. B java Test
 *      C java Test.java
 *    〔解説 p23〕[Java11～] javacを省略のソースファイルモード
 *    			mvコマンド(UNIX), -d, --source 11, javap, jmod
 *
 * 〇8. >java Sample a \" a\" "a " b c
 * 		B args.length == 5;
 * 〔解説p26〕コマンドライン引数(＝起動パラメータ)
 * 	・スペースが区切り文字
 * 	・スペースを含む文字列は""で括る
 * 	・「"」自体はエスケープ「\"」されない限り無視される
 *
 * */
package javaSilver.SE11Black;

import javaSilver.AnswerMaker;

public class Chapter01 {

    public static void main(String[] args) {
        new AnswerMaker();
    }//main()
}//class

/*
//====== ３回目 / 2021-01-12 ======
〇 1: A, C, D
〇 2: B
〇 3: A, C
〇 4: C
〇 5: A, B, E
× 6: C => 〇: B
    ＞java Main java one two / args[0],args[1]〔初歩的なミス〕
〇 7: B, C
〇 8: B
  ◆コマンドライン引数
  ・スペースが区切り文字
  ・スペースを含む文字列は「""」でくくる
  ・「"」はエスケープ「\"」しない限り、データとして扱われない

  正答率 87.50 ％ ( 〇7問 / 全8問 )
*/