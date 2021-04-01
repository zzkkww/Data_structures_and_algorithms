package Common.dynamic;

/**
 * 动态规划 背包问题
 *
 * @author zkw
 * @date 2021-04-01
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        //物品的重量
        int[] w = {1, 4, 3};
        //物品的价值  这里的val[i] 就是图公式的v[i]
        int[] val = {1500, 3000, 2000};
        //背包的容量
        int m = 4;
        //物品的个数
        int n = val.length;

        //为了记录放入商品的情况，我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //创建二维数组，表
        // v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值;
        int[][] v = new int[n + 1][m + 1];

        //初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认就是0
        //但是这里还是处理了一下
        for (int i = 0; i < v.length; i++) {
            //将第1列都初始化为0
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            //将第一行都设置为0
            v[0][i] = 0;
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            //不处理第0行 即 i从1开始
            for (int j = 1; j < v[0].length; j++) {//不处理第0列
                if (w[i - 1] > j) {
                    //因为我们程序i是从1开始的，因此原来公式中的w[i]修改成w[i-1]
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了几率商品存放到背包的情况，我们不能简单的使用上面的公式，需要使用if,else来处理
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况纪录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }


        //可以输出一下v，看看目前情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出最后我们是放入哪些商品
        //遍历path,这样输出会把所有的放入情况都得到，数据有冗余，其实我们值需要最后的放入情况
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j]==1){
//                    System.out.printf("第%d个商品放入到背包\n",i);
//                }
//            }
//        }
        //行的最大下标
        int i = path.length - 1;
        //列的最大下标
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n",i);
                j-=w[i-1];
            }
            i--;
        }

    }
}
