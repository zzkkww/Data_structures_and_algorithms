package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zkw
 * @date 2021-01-26
 **/
public class HuffmanTree {
    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTreeRootNode = createHuffmanTree(arr);
        preOrder(huffmanTreeRootNode);
    }

    /**
     * 调用前序遍历的方法
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("该数是空树");
        }
    }

    /**
     * 创建赫夫曼树方法
     *
     * @param arr
     * @return 创建好赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //1、遍历arr数组
        //2、将arr的每个元素构成一个Node
        //3、将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //排序从小到大 如果下面的Node类没有实现Comparable接口是不支持这个方法的排序的
            Collections.sort(nodes);
            //取出根节点权值最小的两颗二叉树
            //（1）取出权值最小的节点（二叉树）  一个节点也可以交做二叉树
            Node leftNode = nodes.get(0);
            //(2)取出权值第二小的节点（二叉树）
            Node rightNode = nodes.get(1);

            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从arraylist中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);

            Collections.sort(nodes);
            System.out.println(nodes);
        }
        //返回哈夫曼树
        return nodes.get(0);
    }
}

//创建节点类
//为了让Node 对象持续排序Collections集合排序
//让Node 实现Comparable
class Node implements Comparable<Node> {
    /**
     * 节点的权值
     */
    int value;

    /**
     * 指向左子节点
     */
    Node left;

    /**
     * 指向右子节点
     */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }


    //前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
