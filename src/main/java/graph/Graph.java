package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图的实现    （深度优先遍历，没有实现广度优先）
 *
 * @author zkw
 * @date 2021-03-31
 **/
public class Graph {
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目  就是有多少条边
     */
    private int numOfEdges;

    //定义一个数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //节点的个数
        int n = 5;
        String VertexValue[] = {"A", "B", "C", "D", "E"};
        //创建图
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String value : VertexValue) {
            graph.insertVertex(value);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        //A-B
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        System.out.println("深度遍历");
        graph.dfs();

        //显示
        graph.showGraph();
    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        //边不知道有多少条 所以初始化为0；其实不写也是0
        numOfEdges = 0;

        isVisited = new boolean[n];
    }

    /**
     * 得到第一个领结节点的下标w   不存在则返回-1
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {

        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个领结节点的下标来获取下一个领结节点
     public int getNextNeighbor(int v1,int v2){
         for (int j = v2+1; j < vertexList.size(); j++) {
             if (edges[v1][j] > 0) {
                 return j;
             }
         }
         return -1;
     }

     //深度优先遍历算法
    //i 第一次就是0
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点，输出
        System.out.println(getValueByIndex(i)+"->");
        //将节点设置为已经访问
        isVisited[i]=true;
        //查找结点i的第一个领接节点w
        int w=getFirstNeighbor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            //如果w节点已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的节点，并进行dfs
    public void dfs(){
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    /**
     * 返回节点i下标对应的数据   0->"A" 1->"B"   2->"C"
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /***
     * 返回v1和v2的权值
     *
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    /**
     * 插入节点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即是第几个顶点 “A”-"B" "A"->0   "B"->1
     * @param v2     v2第二个顶点对应的下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {

        //这里这样处理是因为 假设A到B有边 则A节点的矩阵里面要标1  而B节点的矩阵里面的位置也要标1
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}
