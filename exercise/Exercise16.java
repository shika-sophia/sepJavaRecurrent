/**
 * @title javaPractice / exercise / Exercise16Ans
 * @content field, constracter, instance
 * @author shika
 * @date 2020-11-06
 */
/*
 * ◆Exercise16
 * Zakクラスというものを以下のように自己定義した。
 * main()で 名称: ザク, 火力1200, 装甲2800の Zakインスタンスを生成し、
 * Zakクラスのフィールドにアクセスし値を取得、下記のように表示せよ。
 *
 * ただし、表示の際に固定値を書き込むのは なしです。
 *
 * ※この問題以降で１ファイルに２クラス以上書いていますが、
 * main()のある class にのみ publicを付け、他クラスは(無記入)のクラスにすると
 * １ファイル内に複数クラスを書くことができます。〔非推奨〕-> 普通は別々のファイルにします。
 *
 * ◇実行結果
 * 名称: ザク
 * 火力: 1200
 * 装甲: 2800
 */

public class Exercise16{

    public static void main(String[] args) {
        

    }//main()

}//class Exercise16


class Zak{
    String name;//名称
    int power;  //火力(攻撃力)
    int armor;  //装甲(防御力)

    public Zak() {}

    public Zak(String name,int power, int armor) {
        this.name = name;
        this.power = power;
        this.armor = armor;
    }

    public void attack() {

    }//attack()

    public void defense() {

    }//defense()

}//class Zak

/*
◇実行結果

名称: ザク
火力: 1200
装甲: 2800
 */