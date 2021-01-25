package study.队列.queue;

/**
 * @program: 算法
 * @description:
 * @author: zkw
 * @create: 2020-11-03 14:42
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(30);
        for (int i = 9; i <20 ; i++) {
            arrayQueue.addQueue(i);
        }
        arrayQueue.showQueue();

    }
}

class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部
        front = -1;
        //指向队列的尾部（既是最后一个数字）
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已经满了");
            return;
        }
        //让rear后移
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能去除数据");
        }
        //front后移
        front++;
        return arr[front];
    }

    public void showQueue() {
        //遍历
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr" + i + arr[i]);
        }
    }

    /**
     * 显示队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
