package tree;

/**
 * 以数组的方式存储二叉树
 *
 * @author zkw
 * @date 2020-11-25
 **/
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //1 2 4 5 3 6 7
        arrBinaryTree.preOder();
    }


}

//编写一个ArrayBinaryTree 实现存储二叉树
class ArrBinaryTree {
    /**
     * 存储数据节点的数组
     */
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOder(){
        this.preOrder(0);
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空或者arr.length==0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            //这个条件是防止它越界
            preOrder(index * 2 + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            //这个条件是防止它越界
            preOrder(index * 2 + 2);
        }

    }


}
