package linkedlist;

/**
 * @description: 双向链表
 * @author: zkw
 * @date: 2020-11-09
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨1");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "及时雨2");
        HeroNode2 hero3 = new HeroNode2(3, "无用", "及时雨3");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "及时雨4");

        //穿件链表
        DoubleLinkedList singleLinkedList = new DoubleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
        System.out.println("双向链表的删除");
        singleLinkedList.delete(hero2);
        singleLinkedList.list();
    }
}

//穿件一个双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
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
        HeroNode2 temp = head.next;
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

    /**
     * 双向链表的添加
     */
    public void add(HeroNode2 heroNode) {
        /**
         当不考虑编号顺序时
         1、找到当前链表的最后节点
         2、将最后这个节点的next指向新的节点的头结点
         */

        //因为head节点不能动，所以我们需要一个辅助的节点
        HeroNode2 temp = head;
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
        //这里存放着前一个节点  这样就能构成双向链表
        heroNode.pre = temp;
    }

    /**
     * 双向链表的修改 和单链表一样
     * 根据no编号来修改，既no编号不能改，其他的data域可以改
     */
    public void update(HeroNode2 newHeroNode) {
        //第一步先判断它是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //找到需要的节点
        //先定义一个辅助的变量
        HeroNode2 temp = head;
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
    public void delete(HeroNode2 deleteHeroNode) {
        if (head.next == null) {
            System.out.println("链表是空的不能删除");
        }
        boolean flag = false;
        //这里我不从头结点开始找了  直接从头结点的下一个节点开始找
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                //已经到了队尾
                break;
            }
            if (temp.no == deleteHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        } else {
            System.out.println("找不到您要删除的节点");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点
     */
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}