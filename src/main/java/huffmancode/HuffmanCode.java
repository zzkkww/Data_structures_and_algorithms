package huffmancode;

import java.util.*;

/**
 * @author zkw
 * @date 2021-01-26
 **/
public class HuffmanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        //40
        System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        System.out.println("赫夫曼树");
        Node huffmanTree = createHuffmanTree(nodes);
        huffmanTree.preOrder();
    }

    /**
     * 前序遍历的方法
     */
    private static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     * 接收一个字节数组
     * @param bytes
     * @return 返回就是List形式
     */
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历bytes，统计每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (Byte b : bytes) {
            //如果map里面 有这个值则拿到了后就++，如果还没有存在则放入b 和1
            Integer count = counts.get(b);
            if (count==null){
                //表示map还没有这个字符数据，第一次进入
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        //把每一个键值对转成一个node对象，并加入到nodes集合
        for (Map.Entry<Byte,Integer>entry :counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }


        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出第一磕最小的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树 它的根节点 没有data，只有权值   因为只有叶子节点才有权值和data域
            Node parent=new Node(null,leftNode.weight+ rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;

            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);
        }

        //最后的节点就是赫夫曼树的跟节点
        return nodes.get(0);
    }
}

/**
 * 创建Node 带数据和权值
 */
class Node implements Comparable<Node> {
    /**
     * 存放数据本身，比如'a'=>97 ''=>32
     */
    Byte data;
    /**
     * 权值，表示字符出现的次数
     */
    int weight;

    Node left;

    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }


    /**
     * 从小到大排列
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);

        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }




}
