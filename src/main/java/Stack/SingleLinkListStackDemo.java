package Stack;

/** 单链表实现栈 有问题 等哪天想改了在改20201110
 * @author zkw
 * @date 2020-11-10
 **/
public class SingleLinkListStackDemo {
    public static void main(String[] args) {
        SingeLinkListStack singeLinkListStack = new SingeLinkListStack(11,"");
        SingeLinkListStack singeLinkListStack2 = new SingeLinkListStack(22,"");
        SingeLinkListStack singeLinkListStack3 = new SingeLinkListStack(33,"");
        SingeLinkListStack singeLinkListStack5 = new SingeLinkListStack(55,"");
        singeLinkListStack.maxSize=4;

        LinkListStack linkListStack = new LinkListStack();
        linkListStack.push(singeLinkListStack);
        linkListStack.push(singeLinkListStack2);
        linkListStack.push(singeLinkListStack3);
        linkListStack.push(singeLinkListStack5);

        linkListStack.list();
    }
}

class LinkListStack{
    public SingeLinkListStack top=new SingeLinkListStack(0,"");

    /**
     * 判断栈是否为空
     */
    public Boolean isEmpty(){
        if (top.next==null){
            System.out.println("该栈为空");
            return false;
        }
        return Boolean.TRUE;
    }

    /**
     * 判断栈是否满了
     */
    public Boolean isFull(){
        while (true){
            if (top.next==null){
                break;
            }
            top=top.next;
        }
        if (top.no==top.maxSize-1){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    /**
     * 入栈
     */
    public void push(SingeLinkListStack value ){
        if (isFull()){
            System.out.println("栈已经满了，不能添加");
            return;
        }
        while (true){
            if (top.next==null){
                break;
            }
            top=top.next;
        }
        top.next=value;
    }

    /**
     * 出栈
     */
    public SingeLinkListStack pop(SingeLinkListStack value){
        if (isEmpty()){
            System.out.println("栈为空不能出栈");
            return null;
        }
        //这个是为了保存前一个节点
        SingeLinkListStack cur=top;
        while (true){
            if (top.next==null){
                break;
            }
            cur=top;
            top=top.next;
        }
        SingeLinkListStack temp;
        //先把要出栈的保存在一个中间变量中输出
        temp=top;

        //把弹出的数据置为null
        top=cur;
        top.next=null;
        return temp;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if (isEmpty()){
            System.out.println("您要遍历的栈是个空栈");
            return;
        }
        while (true){
            if (top.next==null){
                break;
            }
            System.out.println("top1"+top);
            top=top.next;
        }
    }
}


class SingeLinkListStack{

    public int maxSize;
    /**
     * 编号
     */
    public int no;

    public String data;

    public SingeLinkListStack next;

    public SingeLinkListStack(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingeLinkListStack{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
