package Stack.test;

/**
 * @author Kevin
 * @date 2023-04-17
 **/
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.list();
        arrayStack.pop();
        arrayStack.list();
    }

}

class ArrayStack {

    /**
     * 栈顶
     */
    private int top = -1;

    /**
     * 栈的大小
     */
    private int maxSiz;

    /**
     * 存放栈元素
     */
    private int[] array;


    public ArrayStack(int maxSiz) {
        this.maxSiz = maxSiz;
        this.array = new int[maxSiz];
    }


    public Boolean isFull() {
        return maxSiz - 1 == top;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (!isFull()) {
            this.top++;
            array[top] = value;
            return;
        }
        throw new RuntimeException("栈已满");
    }

    public void pop(){
        if (!isEmpty()){
            System.out.println("弹栈"+array[top]);
            this.top--;
            return;
        }
        throw new RuntimeException("栈为空");

    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println("stack[i]"+array[i]);
        }
    }
}
