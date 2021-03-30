package avl;


/**
 * 平衡二叉树 AVL树
 *
 * @author zkw
 * @date 2021-03-30
 **/
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();

        System.out.println("树的高度=" + avlTree.getRoot().height());
        System.out.println("左子树高度=" + avlTree.getRoot().left.height());
        System.out.println("右子树高度=" + avlTree.getRoot().right.height());

        avlTree.infixOrder();
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
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
     * 左旋转方法
     */
    private void leftRotate() {
        //创建新的节点，以当前跟节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成原先节点的右子树的的右子树、
        right = right.right;
        //把当前节点的左子树设置为新节点
        left = newNode;
    }

    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * 返回当前节点的高度，以该节点为根节点的树的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
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

        //当添加完一个节点后，如果（右子树的高度-左子树的高度）>1，即要左旋
        if (rightHeight() - leftHeight() > 1) {

            //左旋转
            leftRotate();
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

