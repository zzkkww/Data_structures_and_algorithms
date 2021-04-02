package Common.kmp;

import java.util.Arrays;

/**
 * kmp算法实现 字符串匹配
 *
 * @author zkw
 * @date 2021-04-01
 **/
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext4("ABCDABD");
        System.out.println("next" + Arrays.toString(next));

        int i = kmpSearch3(str1, str2, next);
        System.out.println(i);
    }

    /**
     * kmp搜索算法
     *
     * @param str1 原字符串
     * @param str2 需要找的子串
     * @param next 部分匹配表，是子串对应的部分匹配表
     * @return 如果-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.chatAt(i)!=str2.charAt(j),去调整j的大小
            //kmp算法核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                //是kmp算法的公式
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                //意味着找到了   这里是相减才能得到匹配上所有字符串的第一个索引值
                return i - j + 1;
            }
        }

        return -1;
    }


    //获取到一个字符串（子串）的部分匹配值表
    public static int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        //只有一个字符串的情况下--如果字符串长度为1 部分匹配值就是0
        next[0] = 0;
        //多个字符串的情况下，还要进行如下的处理
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //dest.charAt(i)!=dest.charAt(j)时 我们需要从next[j-1]获取新的j
            //直到我们发现有dest.charAt(i)==des.charAt(j)成立才退出
            //这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            //如果这个条件满足dest.charAt(i)==dest.charAt(j)时，部分匹配值就+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int[] kmpNext2(String dest) {
        //首先创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];

        //只有一个字符串的情况下
        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }


        return next;
    }

    /**
     * @param str1
     * @param str2
     * @param next
     * @return
     */
    public static int kmpSearch2(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {
            if (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    public static int[] kmpNext3(String dest) {
        int[] next = new int[dest.length()];

        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int[] kmpNext4(String dest) {
        int[] next = new int[dest.length()];

        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            //这个while循环和if循环的位置不能换
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

    public static int kmpSearch3(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }

        return -1;

    }
}

