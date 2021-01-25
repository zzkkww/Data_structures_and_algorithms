package linkedlist;

import java.util.Stack;

/**
 * @program: 算法
 * @description: 单链表
 * @author: zkw
 * @create: 2020-11-03 15:55
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨1");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "及时雨2");
        HeroNode hero3 = new HeroNode(3, "无用", "及时雨3");
        HeroNode hero4 = new HeroNode(4, "林冲", "及时雨4");

        //穿件链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder2(hero1);
        singleLinkedList.addByOrder2(hero4);
        singleLinkedList.addByOrder2(hero3);
        singleLinkedList.addByOrder2(hero2);
        //按加入编号的顺序
        //显示
        singleLinkedList.list();
        System.out.println("/********************/");
        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "卡特玲娜", "哈哈哈");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        //测试删除节点
        System.out.println("/*****************************************************/");
        singleLinkedList.delete(newHeroNode);
        singleLinkedList.list();

        //测试获取节点个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //测试获取倒数的第几个节点
        System.out.println("测试获取倒数的第几个节点");
        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 2));

        System.out.println("============================================================");
        System.out.println("测试合并两个有序单链表");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode hero5 = new HeroNode(9, "卢俊义", "及时雨2");
        HeroNode hero9 = new HeroNode(10, "卢俊义", "及时雨2");
        HeroNode hero6 = new HeroNode(12, "无用", "及时雨3");
        HeroNode hero7 = new HeroNode(15, "林冲", "及时雨4");
        singleLinkedList2.addByOrder2(hero5);
        singleLinkedList2.addByOrder2(hero6);
        singleLinkedList2.addByOrder2(hero7);
        singleLinkedList2.addByOrder2(hero9);
        //测试合并两个有序单链表
        addTwoSingleLinkedList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        singleLinkedList2.list();
        System.out.println("=========================");

        System.out.println("反转单链表");
        //测试单链表的反转功能
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("测试逆序输出");
        //测试逆序输出
        reversePrint(singleLinkedList.getHead());

    }


    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     * 思路
     * 1、首先传入两个单链表的头结点
     * 2、判断他们的节点的大小
     */
    public static HeroNode addTwoSingleLinkedList(HeroNode head1, HeroNode head2) {
//        if (head1.next == null && head2.next == null) {
//            throw new RuntimeException("需要合并的两条链表都为空");
//        }
//        if (head1.next == null) {
//            return head2;
//        }
//        if (head2.next == null) {
//            return head1;
//        }
//        HeroNode newHead = new HeroNode(0, "", "");
//        while (head1 != null && head2 != null) {
//            if (head1.no >= head2.no) {
////                head2.next=head1.next;
//                newHead.next = head2;
//                head2 = head2.next;
//            } else {
////                head1.next=head2.next;
//                newHead.next = head1;
//                head1 = head1.next;
//            }
////            head1=head1.next;
////            head2=head2.next;
//            newHead = newHead.next;
//        }
//        if (head1.next == null) {
//            newHead.next = head2;
//        }
//        if (head2.next == null) {
//            newHead.next = head1;
//        }
//
//        return newHead;
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        HeroNode temp = null;
        if (head1.no > head2.no) {
            //把head较小的节点给新的头节点
            temp=head2;
            temp.next=addTwoSingleLinkedList(head1,head2.next);
//            head2=head2.next;
        }else {
            temp=head1;
            temp.next=addTwoSingleLinkedList(head1.next,head2);
//            head1=head1.next;
        }
//        temp.next=addTwoSingleLinkedList(head1,head2);
        return temp;
    }

    /**
     * 题目：获取到单链表的节点的个数（如果带头节点的链表，需要-1）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            //带头结点的空链表
            System.out.println("该链表为空");
        }
        HeroNode cur = head;
        int i = 0;
        while (true) {
            if (cur.next == null) {
                break;
            }
            i++;
            cur = cur.next;

        }
        return i;
    }

    /**
     * 查找单链表中的倒数第K个节点
     * 1、编写一个方法，接受head节点，同时接受一个index
     * 2、index表示是倒数第index个节点
     * 3、先把链表从头到尾遍历，得到链表的总的长度getLength
     * 4、得到size后，我们从链表的第一个开始遍历（size-index）即可找到我们的节点
     * 5、如果找到了则返回节点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //先判断链表是否为空
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历size-index位置，就是我们倒数的第K个节点
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 题目：从尾到头打印单链表
     * 方法1：先将单链表进行反转操作，然后再遍历即可，这样做的问题是会把原先的单链表的结构弄乱（不建议）
     * 方法2：可以利用栈这个数据结构，将各个节点压到栈中，然后利用栈的特点，就实现了逆序答应
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            throw new RuntimeException("您传进来的单链表为空");
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        //将栈中的节点进行打印。pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 思路：1、先定义一个节点reversHead=new HeroNode();
     * 2、从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最新端
     * 3、原来的链表的head.next=reverseHead.next
     * <p>
     * 单链表的反转  20201109
     */
    public static void reversetList(HeroNode head) {
        //如果当前的链表为空或者只有一个有效接节点则返回异常
        if (head.next == null || head.next.next == null) {
            throw new RuntimeException("该链表为空");
        }
        //先定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，并从头到尾遍历原来的链表
        //每次遍历都把当前的链表拿出来，给到新的节点
        while (cur != null) {
            //先暂时保存当前节点的下一个节点
            next = cur.next;
            //将cur的下一个节点指向新节点的最前端的
            cur.next = reverseHead.next;
            //这样才能连起来
            reverseHead.next = cur;
            //让cur挪一下，指向下一个节点
            cur = next;
        }
        //将原先的头结点指向新的reverseHead.next 实现链表的反转
        head.next = reverseHead.next;
    }
}

/**
 * 定义SingleLinkedList 管理我们的单链表
 */
class SingleLinkedList {
    /**
     * 先初始化一个头节点，头节点不要动
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        /**
         当不考虑编号顺序时
         1、找到当前链表的最后节点
         2、将最后这个节点的next指向新的节点的头结点
         */

        //因为head节点不能动，所以我们需要一个辅助的节点
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //因为next为空了则为最后一个节点
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，则将temp往后移动
            temp = temp.next;//注意 这里是如果没有找到它是最后的就往后移，而next域存放了我们的下一个值，所以吧temp=temp.next20201104
        }
        //当我们退出这个链表循环的时候，说明这是链表的最后
        //将最后的这个节点的next连上这个传进来的heroNode节点即可
        temp.next = heroNode;
    }

    /**
     * 第二种方法在添加影响时，根据编号插入 如果该编号已经存在链表中，则提示插入失败
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助我们找到添加的位置
        //因为是单链表，所以我们要找的temp是位于添加位置的前一个节点，否则我们添加不了
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //位置找到了，就在temp的后面插入即可
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明编号存在了，不给插入
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next; //这个next域存放了它连接的一个节点（这个节点里面有data域和next域）
        }
        //判断flag的值
        if (flag) {
            System.out.println("待插入的英雄编号已经存在" + heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;//这里是为了把上面跳出循环的temp本身存放的next域存到现在要插入的这个heroNode的next域，这样
            //它才会连接上它temp本来连接的那个节点
            temp.next = heroNode;//这个节点的next域就是我们需要heroNode存放的地方，详细的可以看我自己画的图
        }
    }

    /**
     * 第二种方法在添加影响时，根据编号插入 如果该编号已经存在链表中，则提示插入失败
     */
    public void addByOrder2(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助我们找到添加的位置
        //因为是单链表，所以我们要找的temp是位于添加位置的前一个节点，否则我们添加不了
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;//不加这个就会死循环
        }
        if (flag) {
            System.out.println("该英雄的编号已经存在，请输入别的编号");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

        //插入到链表中，temp的后面
        //这里是为了把上面跳出循环的temp本身存放的next域存到现在要插入的这个heroNode的next域，这样
        //它才会连接上它temp本来连接的那个节点
        //这个节点的next域就是我们需要heroNode存放的地方，详细的可以看我自己画的图

    }

    /**
     * 根据no编号来修改，既no编号不能改，其他的data域可以改
     */
    public void update(HeroNode newHeroNode) {
        //第一步先判断它是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //找到需要的节点
        //先定义一个辅助的变量
        HeroNode temp = head;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //如果temp为空则到了链表的最后
                break;
            }
            if (temp.next.no == newHeroNode.no) {
                flag = true;
                //找到了我们要修改的节点,如果这里no等于了新的节点，跳出循环，并提示让其修改即可
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = newHeroNode.name;
            temp.next.nickname = newHeroNode.nickname;
        } else {
            System.out.println("找不到该节点的信息，无法更新该节点");
        }
    }

    /**
     * 删除节点
     */
    public void delete(HeroNode deleteHeroNode) {
        //判链表是否为空
        if (head.next == null) {
            System.out.println("链表是空的");
        }
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            //说明已经到了链表的最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == deleteHeroNode.no) {
                //说明找到了要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            /**
             * 详细的可以看我的图
             */
            temp.next = temp.next.next; //这里需要注意
        } else {
            System.out.println("您要删除的节点不存在，请检查后再试");
        }
    }

    /**
     * 显示链表【遍历】 为什么需要一个辅助的来遍历 因为temp不能动，head节点也不能动
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }
        //因为头结点，不能动，因此需要一个辅助变量
        HeroNode temp = head.next;
        while (true) {
            //判断是否链表为最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp.toString());
            //将next后移 不后移的话会死循环停在这个节点
            temp = temp.next;
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}

