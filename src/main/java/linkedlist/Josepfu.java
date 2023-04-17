package linkedlist;

/**
 * @description: 约瑟夫问题
 * @author: zkw
 * @date: 2020-11-09
 **/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(20);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    //首先创建一个first节点，当前没有编号
    public Boy first = new Boy(-1);

    //添加小孩节点，构造成一个环形的链表 只需要告诉我创建一个小孩节点即可
    public void addBoy(int nums) {
        //nums做一个简单的数据校验
        if (nums < 2) {
            System.out.println("nums的值不正确");
            return;
        }
        //辅助指针 帮助我们构建环形链表
        Boy curBoy = null;
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                //构成一个环状
                first.setNext(first);
                //让这个curBoy指向这个第一个小孩，方便我们后续的操作
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                //诺到下一个节点
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何的小孩");
            return;
        }
        //因为first不能动，因此我们还需要辅助变量
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明已经到了末尾
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    /**
     * 约瑟夫环出圈问题   eg：1，2,5
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 每次数的个数 例如2  则 1 -》2 2对应的小孩出圈
     * @param nums     表示有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        addBoy(nums);
        //创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //需要创建一个辅助指针helper,事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.next == first) {
                //说明helper指向了环形链表的最开始的那个节点
                break;
            }
            //否则则往后移
            helper = helper.next;
        }

        //小孩报数前，先让first和helper移动k-1次    先让指针指向起始的小孩
        for (int j = 0; j < startNo - 1; j++) {
            first=first.next;
            helper=helper.next;
        }
        //这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper==first){
                //说明此时只剩下一个节点了
                break;
            }
            //让first和helper指针同时移动countNum-1
            for (int i = 0; i < countNum-1; i++) {
                first=first.next;
                helper=helper.next;
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.println("小孩%d出圈\n"+first.no);
            //这是将first指向的小孩节点出圈
            first=first.next;
            helper.next=first;
        }
        System.out.println("最后留在圈中的小孩编号"+first.no);


    }
}


//创建一个Boy类，表示一个节点
class Boy {
    /**
     * 编号
     */
    public int no;
    /**
     * 指向下一个节点，默认null
     */
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
