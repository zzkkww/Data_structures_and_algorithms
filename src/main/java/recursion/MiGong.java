package recursion;

/**利用递归解决迷宫问题
 * @author zkw
 * @date 2020-11-15
 **/
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int [][]map=new int[8][7];
        //使用1表示墙
        //先把上下全部置为1
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //把左右全部 置为1
        for (int i = 0; i <8 ; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板，1表示
        map[3][1]=1;
        map[3][2]=1;

        System.out.println("当前地图的情况");
        //输出地图
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }

        System.out.println("=========================");
        //使用递归回溯给小球找路
        setWay(map,1,1);
        //输出新地图，小球，走过并表示过得递归地图
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路    如果小球到map[6][5]位置，则说明通路找到
     约定：当map[i][j]为0表示该点没有走过，当为1表示墙，2：表示通路可以走
     3：表示该店已经走过，但是走不通

     注意：在走迷宫时候，需要先确定一个策略（方法） 下->右->上->左，如果走不通就回溯
     * @param map
     * @param i  从那个位置开始找
     * @param j
     * @return 如果找到通路，就返回true,否则返回false
     */
    public static boolean setWay(int [][]map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j]==0){
                //如果当前这个点还没有走过
                //就按照策略走
                map[i][j]=2;//假定该店是可以走通的
                if (setWay(map,i+1,j)){
                    //向下走
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    //又尝试向上走，能走的通就返回true
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    //上面的四种情况都走不通了，则把该店置为3
                    map[i][j]=3;
                    return false;
                }
            }else {
                //如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }
}
