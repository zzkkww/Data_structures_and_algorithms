package Common;

/**分而治之算法  汉诺塔案例
 * @author zkw
 * @date 2021-04-01
 **/
public class Hanoittower {
    public static void main(String[] args) {

        hanoiTower(2,'A','B','C');
    }

    /**
     *
     * @param num 盘子的数量
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第一个盘从 "+a+"->"+c);
        }else {
            //如果我们有num>=2情况下，我们总是可以看做是两个盘 1.最下边的盘 2、上面的所有盘
            //1、先把最上面的盘A->B ，移动过程会使用到c   如果是A->B 则 中间是c
            hanoiTower(num-1,a,c,b);
            //2.把最下边的盘A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3、把B塔的所有盘都移动到C 如果是B->C 则两边是BC中间是A
            hanoiTower(num-1,b,a,c);
        }
    }
}


