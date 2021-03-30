package binarysorttree;

/**
 * 二叉排序树
 *
 * @author zkw
 * @date 2021-03-30
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr={7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    /**
     * 添加节点的方法
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            //如果root为空，则直接让root指向node
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历输出
     */
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("当前二叉排序树为空");
        }
    }
}

class Node {
    /**
     * 值
     */
    int value;
    /**
     * 左子节点
     */
    Node left;

    /**
     * 右子节点
     */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 添加节点的方法
     * 递归的形式添加节点 注意需要满足二叉排序树
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树的根节点的值的关系 this等价于当前这颗树的根节点
        if (node.value < this.value) {
            //如果当前节点左子节点为null 直接挂上即可
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左边添加
                this.left.add(node);
            }
        } else {
            //如果这个添加的节点的值大于当前节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历数
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
