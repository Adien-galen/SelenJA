package test.java.utils;

import java.util.*;

/**
 * Description:随机生成18位身份证号码
 * 18位身份证规则:
 * 根据〖中华人民共和国国家标准 GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成
 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。 第十八位数字(校验码)的计算方法为：
 * 1.将前面的身份证号码17位数分别乘以不同的系数,从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
 * 2.将这17位数字和系数相乘的结果相加
 * 3.用加出来和除以11，看余数是多少？
 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字,其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2
 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ,如果余数是10，身份证的最后一位号码就是2
 */
public class IdCardGeneration {
    public static final Map<String,Integer> idRegion = new HashMap<>();

    public static void main(String[] args) {
        IdCardGeneration g = new IdCardGeneration();
        /*for (int i = 0; i < 10; i++) {
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.print(g.generate());
            System.out.print("\t");
            System.out.println(g.generate());
        }*/
        System.out.println(g.generate());
    }

    static{
        IdCardGeneration.idRegion.put("四川省", 510000);
        IdCardGeneration.idRegion.put("成都市", 510100);
        IdCardGeneration.idRegion.put("市辖区", 510101);
        IdCardGeneration.idRegion.put("锦江区", 510104);
        IdCardGeneration.idRegion.put("青羊区", 510105);
        IdCardGeneration.idRegion.put("金牛区", 510106);
        IdCardGeneration.idRegion.put("武侯区", 510107);
        IdCardGeneration.idRegion.put("成华区", 510108);
        IdCardGeneration.idRegion.put("龙泉驿区", 510112);
        IdCardGeneration.idRegion.put("青白江区", 510113);
        IdCardGeneration.idRegion.put("新都区", 510114);
        IdCardGeneration.idRegion.put("重庆市", 500000);
        IdCardGeneration.idRegion.put("市辖区", 500100);
        IdCardGeneration.idRegion.put("万州区", 500101);
        IdCardGeneration.idRegion.put("涪陵区", 500102);
        IdCardGeneration.idRegion.put("渝中区", 500103);
        IdCardGeneration.idRegion.put("大渡口区", 500104);
        IdCardGeneration.idRegion.put("江北区", 500105);
        IdCardGeneration.idRegion.put("沙坪坝区", 500106);
        IdCardGeneration.idRegion.put("九龙坡区", 500107);
        IdCardGeneration.idRegion.put("南岸区", 500108);
        IdCardGeneration.idRegion.put("北碚区", 500109);
        IdCardGeneration.idRegion.put("万盛区", 500110);
        IdCardGeneration.idRegion.put("双桥区", 500111);
        IdCardGeneration.idRegion.put("渝北区", 500112);
        IdCardGeneration.idRegion.put("巴南区", 500113);
        IdCardGeneration.idRegion.put("黔江区", 500114);
        IdCardGeneration.idRegion.put("长寿区", 500115);
        IdCardGeneration.idRegion.put("江津区", 500116);
        IdCardGeneration.idRegion.put("合川区", 500117);
        IdCardGeneration.idRegion.put("永川区", 500118);
        IdCardGeneration.idRegion.put("南川区", 500119);
    }

    /**
     * 生成身份证号码
     * @return
     */
    public String generate() {
        StringBuilder generater = new StringBuilder();
        generater.append(this.getRandomArea());
        generater.append(this.getRandomBirthday());
        generater.append(this.getRandomNumber());
        generater.append(this.getTestCode(generater.toString().toCharArray()));
        return generater.toString();
    }

    /**
     * 随机获取地区
     *
     * @return
     */
    public int getRandomArea() {
        int index = (int) (Math.random() * IdCardGeneration.idRegion.size());
        Collection<Integer> values = IdCardGeneration.idRegion.values();
        Iterator<Integer> it = values.iterator();
        int i = 0;
        int code = 0;
        while (i < index && it.hasNext()) {
            i++;
            code = it.next();
        }
        return code;
    }

    /**
     * 随机获取出生日期
     *
     * @return
     */
    public String getRandomBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 20) + 1985);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        return builder.toString();
    }



    /**
     * 获取效验码
     * @param chars
     * @return
     */
    public char getTestCode(char[] chars) {
        if (chars.length < 17) {
            return ' ';
        }
        int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        return r[result % 11];
    }

    /**
     *获取3位随机数
     * @return
     */
    public String getRandomNumber() {
        int code = (int) (Math.random() * 1000);
        if (code < 10) {
            return "00" + code;
        } else if (code < 100) {
            return "0" + code;
        } else {
            return "" + code;
        }
    }
}
