/**
 * @title javaPractice / exercise / Exercise19Ans
 * @content
 * @author shika
 * @date 2020-11-12
 */
/*
 * ◆Exercise19Ans
 * 前問17,18において ZakPrivateクラス, ZakSpecialクラスを原型として
 * 「ザク」を大量生産するときが来た。
 * まずは 500体を生産してほしい。今後、生産数を増減させるときのために
 * final定数１つを変更すれば済むように作ってほしい。
 *
 * 量産型ザクの名前は「ザク1」「ザク2」…などで良い。
 * [量産型ザク]火力900～1500, 装甲2500～3000
 * [シャア専用ザク]火力4500～5500, 装甲6000～7200
 *
 * 量産型ザクは生産中に３％の確率で不良品が出る。
 * シャア専用ザクは予算的に量産型100体につき５体を固定生産する。
 *
 * 量産型の不良品はスペックに関係なく納品せずとも良い。
 * (納品数は500体未満になっても良い)
 * シャア専用ザクは生産したもののうちスペック合計の最大のものを１体だけ
 * パイロットスキル128000シャアの乗機として紅く塗って納品する。
 *
 * 納品は配列orListに入れ、変数１つをmain()と別メソッドに引数で渡して表示してほしい。
 *
 * 〔ヒント〕
 * 500体の生産で、500本のインスタンス文を書いて500個の変数に代入してはいけない。
 * (だいち１クラスにそんなに変数は定義できない。確か256個まで)
 * for文と配列orListで自動生成することを考える。なお紅くは塗らんでいいです。
 */
package javaPractice.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise19Ans {
    private static int powerRdm = 0;
    private static int armorRdm = 0;
    private static final int PRODUCT_NUM = 500;//生産数
    private static final BigDecimal RATE = new BigDecimal("0.03");//不良品率

    //配列の必要個数は生産数 + (生産数× 5 / 100)
    private static final int BOUND = PRODUCT_NUM + PRODUCT_NUM / 20;

    public static void main(String[] args) {


        ZakPrivate[] productArr = new ZakPrivate[BOUND];

        //====== Product ======
        //Sharr Product Line
        int count = 0;
        String type = "sharr";

        for(int i = 0; i < (PRODUCT_NUM / 20); i++) {
            //---- 火力,装甲を決定
            decideSpec(type);

            //---- インスタンス ----
            String name = "SharrZak_NO." + i ;
            productArr[i] = new ZakSpecial(name, powerRdm, armorRdm, 128000);
            count++;
        }//for PRODUCT_NUM / 20

        //Mass Product Line
        type = "mass";
        for(int i = count; i < PRODUCT_NUM; i++) {
            //---- 火力,装甲を決定
            decideSpec(type);

            //---- インスタンス ----
            String name = "Zak_NO." + i ;
            productArr[i] = new ZakPrivate(name, powerRdm, armorRdm);
        }//for PRODUCT_NUM

        //====== delivery / 納品 ======
        List<ZakPrivate> deliveryList = new ArrayList<>(BOUND);

        //---- sharr selection ----
        deliveryList = sharrMax(productArr, deliveryList, count);

        //---- except mass error / 不良品の除外----
        deliveryList = massError(productArr, deliveryList, count);

        //====== print product ======
        printProduct(productArr);

    }//main()


    private static void decideSpec(String type) {

        int[] specData = new int[] {
                900, +600, 2500, +500, 4500, +1000, 6000, +1200
        };

        Random rdm = new Random();

        if(type.equals("mass")) {
            powerRdm = rdm.nextInt(specData[1]) + specData[0] + 1;
            armorRdm = rdm.nextInt(specData[2]) + specData[3] + 1;

        } else if (type.equals("sharr")) {
            powerRdm = rdm.nextInt(specData[5]) + specData[4] + 1;
            armorRdm = rdm.nextInt(specData[7]) + specData[6] + 1;
        }
    }//decideSpec


    //====== sharr selection / 最高スペックの選定 ======
    private static List<ZakPrivate> sharrMax(
            ZakPrivate[] productArr, List<ZakPrivate> deliveryList, int count) {

        //spec合計を保存する List
        List<Integer> specList = new ArrayList<>();

        //各productのspecを取得し合計、Listに保存
        for (int i = 0; i < count; i++) {
            int specSum = 0;
            specSum += ((ZakSpecial)productArr[i]).getPower();
            specSum += ((ZakSpecial)productArr[i]).getArmor();

            specList.add(specSum);
        }

        //sort()する前に List をコピー
        List<Integer> copy = new ArrayList<>(specList);

        //sort()をして最大specを取得し、元のリストのindexを取得
        Collections.sort(specList);
        int specMax = specList.get(specList.size() - 1);
        int indexMax = copy.indexOf(specMax);

        //最大specの sharr製品を納品Listに登録
        deliveryList.add(productArr[indexMax]);

        return deliveryList;
    }//sharrMax()


    //====== except mass error ======
    private static List<ZakPrivate> massError(
            ZakPrivate[] productArr, List<ZakPrivate> deliveryList, int count) {
        //不良品indexのList
        List<Integer> errorList = new ArrayList<>();

        //RATE％の確率で不良品
        for(int i = count; i < BOUND; i++) {
            double errValue = Math.random();
            String errStr = String.valueOf(errValue);
            BigDecimal errBD = new BigDecimal(errStr);

            //compareTo() -> 0: 一致, 1: 前置オブジェクトより引数が大きい
            if(errBD.compareTo(RATE) >= 0) {
                errorList.add(i);
            }
        }//for i

        return null;
    }//massError()


    //====== print product ======
    private static void printProduct(ZakPrivate[] productArr) {


    }//printProduct()

}//class

/*
//###### class ZakSpecial ######
//同パッケージなのでアクセス可
class ZakSpecial extends ZakPrivate{
    private int pilot; //熟練(乗員のスキル)

    public ZakSpecial() {}

    public ZakSpecial(String name,int power, int armor) {
        super(name, power, armor);
        setPower(power);
        setArmor(armor);
        setPilot(2000);
    }

    public ZakSpecial(String name,int power, int armor, int pilot) {
        super(name, power, armor);
        setPower(power);
        setArmor(armor);
        setPilot(pilot);
    }

    @Override
    public void attack() {

    }//attack()

    @Override
    public void defense() {

    }//defense()

    public void moveMoment() {

    }//moveMoment()


    //==== getter, setter ====
    @Override
    public void setPower(int power) {
        if(power > 2000) {
            super.setPower(power);
        } else if (power <= 2000) {
            super.setPower(2000);
        }
    }//setPower()

    @Override
    public void setArmor(int armor) {
        if(armor > 5000) {
            super.setArmor(armor);
        } else if (armor <= 5000) {
            super.setArmor(5000);
        }
    }//setArmor()

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

}//class ZakSpecial


//###### class ZakPrivate ######
//同パッケージなのでアクセス可
class ZakPrivate{
  private String name;//名称
  private int power;  //火力(攻撃力)
  private int armor;  //装甲(防御力)

  public ZakPrivate() {}

  public ZakPrivate(String name,int power, int armor) {
      setName(name);
      setPower(power);
      setArmor(armor);
  }

  public void attack() {

  }//attack()

  public void defense() {

  }//defense()

  //==== getter, setter ====
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getPower() {
      return power;
  }

  public void setPower(int power) {
      this.power = power;
  }

  public int getArmor() {
      return armor;
  }

  public void setArmor(int armor) {
      this.armor = armor;
  }

}//class Zak
*/