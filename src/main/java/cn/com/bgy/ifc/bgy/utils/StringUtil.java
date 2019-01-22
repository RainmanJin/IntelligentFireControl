package cn.com.bgy.ifc.bgy.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Random;

/**
 * @Author huxin
 * @Date 2018/12/12 10:26
 * @Description 字符串工具类
 **/

public class StringUtil {

    /**
     * @Author huxin
     * @Description 判定String是否为null
     * @Date 2018/12/12 10:29
     */
    public static boolean isEmpty(String s) {
        if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s) || "undefined".equalsIgnoreCase(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Author huxin
     * @Description 判定String是否为null
     * @Date 2018/12/12 10:34
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean contains(String source, String target) {
        if (source.indexOf(target) != -1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @description:获取汉语拼音首字母
     * @param: [chinese]
     * @return: java.lang.String
     * @auther: chenlie
     * @date: 2019/1/8 15:41
     */
    public static String getFirstSpell(String chinese) {

        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim().substring(0,1);
    }
    /**
     * @description:产生固定长度随机字符串
     * @param: [length]
     * @return: java.lang.String
     * @auther: chenlie
     * @date: 2019/1/22 18:11
     */
   public static String randomString(int length){

       String str="QWERTYUIOPASDFGHJKLZXCVBNM1234567890abcdefghijklmnopqrstuvwxyz";
       //由Random生成随机数
       Random random=new Random();
       StringBuffer sb=new StringBuffer();
       //长度为几就循环几次
       for(int i=0; i<length; ++i){
           //产生0-61的数字
           int number=random.nextInt(62);
           //将产生的数字通过length次承载到sb中
           sb.append(str.charAt(number));
       }
       //将承载的字符转换成字符串
       return sb.toString();
    }


}
