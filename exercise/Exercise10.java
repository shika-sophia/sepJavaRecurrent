/**
 * @title javaPractice / exercise / Exercise10Ans
 * @content 配列,(別解 二次元配列), ArrayIndexOutOfBoundsException, Scanner,
 *           while(true), ラベル, break, continue, クラスファイルの実行,
 *           《解説》フィールド,《解説》StringBuilder
 * @author shika
 * @date 2020-10-22 ～ 10-25
 */
/*
 * ◆Exercise10 [応用]
 * 同じフォルダ内にある [Exercise10.class]を
 * コマンドプロンプトのワークフォルダ(自分のjavaファイルを置いてるところ)にコピーし
 *
 * コマンドプロンプトを開いて
 * >java Exercise10 で実行する。
 * (classファイルはコンパイルした結果できたファイルなので、すでにコンパイル済)
 *
 * 実行動作を確認し、こういう動作をするプログラムを作成せよ。
 *
 *----------------------------
 * >java Exercise10
 *　　 [↑8]
 *[←4] 　　[6→]
 *　　 [↓2] 　　[0]終了
 *
 *　　□□□□
 *　　□□◆□
 *　　□□□□
 *　　
 *数字を入力すると移動します。
 *----------------------------
 *
 * 問１ 横４×縦３で同様の動作を実現せよ。
 *
 * 問２ 横WIDTH×縦HEIGHTとし、
 *      横と縦の変更をフィールドの定数を変更すればできるようにしたい。
 *      問１で定数の計算式にしていた部分を WIDTHとHEIGHTを用いた式に修正せよ。
 *
 * 問３ 同様の動きを二次元配列を使って実現せよ。
 *
 *-----------------------------
 * 〔ヒント〕
 * ◆ArrayIndexOutOfBoundsException:
 *    配列を使う際、初心者のうちは、よく目にして悩まされる例外(エラー)。
 *    配列は array[5]などと、あらかじめ要素の個数を宣言してから使うが、
 *    この例で言えば[]の中のindex(添え字 = 配列の要素番号)は 0～4までしかない。
 *    それなのに0～4以外のindexを入れて実行すると出される例外。
 *
 *    この Exercise10 は、この例外に対処するための練習問題です。
 *    後に学習する例外処理のための try-catch構文というものがあるが、
 *    IndexOutOfBoundsExceptionは、そもそもコンパイルで検出されず、例外として認識されない。
 *    実行時に例外が出されるのは、正しいプログラムを書くことで防ぐことができるからです。
 *
 *    なのでこの例外の処理に try-catchは使わず、[]の中に不正な値が入らないよう細心の注意をして
 *    プログラムを作ります。以下いくつかコツがあるので ご紹介します。
 *
 *    ◇lengthフィールドを使う
 *    for(int i = 0; i < array.length; i++){
 *        array[i] = n;
 *    }
 *    というfor文で配列を扱うと上記の例外は起こりえない。
 *    このfor文は 0～「indexの最後」の[i]しか入らないので、
 *    [i]に 「+,-,*,/」などの計算を加えない限り、例外が出ることはない。
 *    なるべく iの終了条件式(継続条件式)には定数ではなく「配列名.length」を使うようにすると良い。
 *    不等号には「=」を入れないよう注意。
 *
 *    ◇不正な値をあらかじめチェック
 *    [i]の中はできれば計算式を入れたくはないが、どうしても必要なときは
 *    事前に ifや switchで不正な値が入る可能性をなくしてから計算式を入れると良い。
 *
 * ◆永久ループ 「while(true){}」
 * このwhile文は永久ループする。whileの代わりに「for( ; ; ){}」と何も()中に条件を書き込まない for文でも可能。
 * 永久ループを作る場合は、if, switchで 必ず break;を入れること。
 *
 * switchで用いるbreak;は switch{}ブロックを抜けるだけなので、
 * ループさせるときは while(true)の直前に「loop:」などラベルを付ける。
 * ラベル名は自由に付けていいが「:」コロンで終わること。「;」文末のセミコロンではない。
 * そして、while(true){}の永久ループを抜ける breakにはラベルを付けて「break loop;」文末の「;」とする。
 *
 * 不正な値をチェックして、もう一度 Scanner入力がほしいときなどに利用する。
 * 必要に応じて Scannerクラスのインスタンスをwhileループの中に入れるか、外に出しておくかを考える。
 * 外に置いたほうがＰＣの処理負担が軽減される。永久ループはＰＣに負担の掛かる処理であることを考慮して使う。
 * (ひと昔前のＰＣなら永久ループさせただけでフリーズすることもあったのだ。)
 *
 */

public class Exercise10 {

    public static void main(String[] args) {
        
    }//main()

}//class

