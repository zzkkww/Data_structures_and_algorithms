package tree;

/**
 * 二叉树
 *
 * @author zkw
 * @date 2020-11-24
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "松江");
        HeroNode node2 = new HeroNode(2, "吴勇");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历");
//        //1 2 3 4
//        root.preOrder();
//
//        System.out.println("中序遍历");
//        //2 1 3 4
//        root.infixOrder();
//
//        System.out.println("后序遍历");
//        //2 4 3 1
//        root.postOrder();

//        HeroNode resNode = binaryTree.preOrdersearch(10);
//        if (resNode != null) {
//            System.out.println(resNode);
//        } else {
//            System.out.println("没有找到");
//        }
        binaryTree.preOrder();
        System.out.println("删除");
        binaryTree.delNode(5);
        binaryTree.preOrder();


    }
}

//定义一个二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历  类似于我们的哈希表，里面的数组对应着链表
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    /**
     * 前序遍历查找
     */
    public HeroNode preOrdersearch(int no) {
        if (root != null) {
            return root.preOrdersearch(no);
        } else {
            return null;
        }
    }

    /**
     * 中遍历查找
     */
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 后遍历查找
     */
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 删除节点
     */
    public void delNode(int no){
        if (root!=null){
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除");
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

    /**
     * 编写前序遍历的方法
     */
    public void preOrder() {
        //先输出父节点
        System.out.println(this);

        //递归向左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历的方法
     */
    public void infixOrder() {
        //递归向左子树中序遍历先
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);

        //递归向右 子树中序遍历先
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历的方法
     */
    public void postOrder() {
        //递归向左子树中序遍历先
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右 子树中序遍历先
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     */
    public HeroNode preOrdersearch(int no) {
        if (this.no == no) {
            return this;
        }
        //初始化一个节点先
        HeroNode resNode = null;

        //判断当前节点的左子节点是否为空，如果不为空，则递归向左查找
        //如果做递归前序查找，找到节点，则返回
        if (this.left != null) {
            resNode = this.left.preOrdersearch(no);
        }
        if (resNode != null) {
            //说明我们左子树上找到了 返回
            return resNode;
        }
        //1、左递归前序查找，找到节点，则返回，否则继续判断
        //2、当前节点的右子节点是否为空，如果不空，则继续向右查找
        if (this.right != null) {
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后续遍历查找
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        //如果左右都没找到，就比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }


    /**
     * 1、递归删除节点，如果删除的节点是叶子节点，则删除该节点
     * <p>
     * 2、如果删除的节点是非叶子节点，则删除该子树
     */
    public void delNode(int no) {
        if (this.no == no) {
            System.out.println("删除成功" + this);
            this.right=null;
            this.left=null;
            return;
        }
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }

    }
}