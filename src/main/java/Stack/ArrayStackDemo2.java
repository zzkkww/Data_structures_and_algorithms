package Stack;

/**
 * @author Kevin
 * @date 2021-09-27
 **/
public class ArrayStackDemo2 {
}

class ArrayStackHa {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStackHa(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public Boolean isFull() {
        return top == maxSize - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return -1;
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; top >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}