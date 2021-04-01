package Common.kmp;

/**
 * 暴力匹配
 *
 * @author zkw
 * @date 2021-04-01
 **/
public class ViolenceMatch {
    public static void main(String[] args) {
        //测试
        String str1 = "哈哈哈，你要来吗，，一一一llloo";
        String str2 = "，一一一";
        int index = violenceMath(str1, str2);
        System.out.println("index=="+index);
    }

    /**
     * 暴力匹配算法实现
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int violenceMath(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        ;
        int s2Len = s2.length;

        //i索引指向s1
        int i = 0;
        //j索引指向s2
        int j = 0;
        while (i < s1Len && j < s2Len) { //保证匹配时，不越界
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else {
                //没有匹配成功
                //如果失败既s1[i]!s2[j] 令i=i-(j-1),j=0;
                i=i-(j-1);
                j=0;
            }
        }
        if (j==s2Len){
            return i-j;
        }else {
            return -1;
        }
    }
}
