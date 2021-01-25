package tree.threadedbinarytree;

/**
 * 中序遍历的 线索二叉树
 *
 * @author zkw
 * @date 2020-11-25
 **/
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后面我们要递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();

        //测试：以10号节点测试
        HeroNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱结点是：" + leftNode);
        System.out.println("10号节点的后继结点是：" + node5.getRight());

        System.out.println("使用线索化的方式遍历线索化二叉树");
        //8 3 10 1 14 6
        threadedBinaryTree.threadList();
    }
}


//定义一ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    /**
     * 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
     * 在递归进行线索化时，总是保存前一个节点
     */
    private HeroNode pre = null;


    /**
     * 重载线索化二叉树方法
     */
    public void threadedNode() {
        this.threadedNode(root);
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNode(HeroNode node) {
        //如果node==null,不能线索化
        if (node == null) {
            return;
        }

        //1、先线索化左子树
        threadedNode(node.getLeft());
        //2、线索化当前结点
        //先处理当前节点的前驱结点
        //以8节点来理解
        //8结点的.left=null,8结点的.leftType=1
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前节点的左指针的类型 说明这个是指向的是前驱结点
            node.setLeftType(1);
        }

        //=====为什么左右处理的方式不一样============


        //处理后继结点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }

        //！！！每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //3、再线索化右子树
        threadedNode(node.getRight());
    }

    /**
     * 遍历线索化二叉树
     */
    public void threadList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;

        while (node != null) {
            //循环的找到leftType==1的结点，第一个找到的就是8结点
            //后面这个遍历而变化，因为leftType==1时，说明该节点是按照线索化
            //处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1) {
                //获取当前结点的后继结点
                node=node.getRight();
                System.out.println("=="+node);
            }
            //替换这个遍历的节点
            node=node.getRight();
        }
    }

}


//创建HeroNode
class HeroNode {
    private int no;
    private String name;
    /**
     * 左子节点，默认null
     */
    private HeroNode left;

    /**
     * 右子节点 默认null
     */
    private HeroNode right;

    //说明
    //1、规定，如果leftType==0 表示指向的是左子树，如果是1则指向前驱结点
    //2、规定，如果rightType==0 表示指向的是右子树，如果是1则指向后继结点

    private int leftType;

    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}