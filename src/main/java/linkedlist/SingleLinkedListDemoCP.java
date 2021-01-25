package linkedlist;

/**
 * @description: 单链表自我实现
 * @author: zkw
 * @date: 2020-11-09
 **/
public class SingleLinkedListDemoCP {
}


class SingleLinkedList1{
    //先初始化一个头结点
    public HeroNode1 head=new HeroNode1(0,"","");

    public HeroNode1 getHead() {
        return head;
    }

    /**
     * 增加
     */
    public  void addOrder(HeroNode1 heroNode1){
        //记住头节点不能动，所以我们需要辅助节点
        HeroNode1 temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no>heroNode1.no){
                break;
            }else if (temp.next.no == heroNode1.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("带插入英雄编号已经存在"+heroNode1.no);
        }else {
            heroNode1.next=temp.next;
            temp.next=heroNode1;
        }
    }


}


class HeroNode1 {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点
     */
    public HeroNode1 next;

    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}