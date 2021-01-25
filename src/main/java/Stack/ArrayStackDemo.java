package Stack;

/**
 * 用数组实现栈
 * @author zkw
 * @date 2020-11-10
 **/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        for (int i = 0; i < 4; i++) {
            arrayStack.push(i*10);
        }
        arrayStack.list();
        arrayStack.push(666);
        System.out.println("弹栈");
        System.out.println(arrayStack.pop());
    }
}

//定义一个ArrayStack 表示栈
class ArrayStack{
    /**
     * 栈的大小
     */
    private int maxSize;
    /**
     * 数组，数组模拟栈，数据就放在该数组中
     */
    private int[] stack;

    /**
     * 表示栈顶初始化为-1
     */
    private int top=-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }

    /**
     * 判断栈满
     */
    public Boolean isFull(){
        return top==maxSize-1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 入栈
     */
    public void push(int value){
        //先判断栈是否满了
        if (isFull()){
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top]=value;
    }

    /**
     * 出栈 将栈顶的数据返回
     */
    public int pop(){
        if (isEmpty()){
            System.out.println("栈是空的，无法出栈");
        }
        int value=stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈  从栈顶到下面
     */
    public void list(){
        if (isEmpty()){
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println("stack[i]"+stack[i]);
        }

    }

}

