package study.队列.queue;

/**
 * @program: 算法
 * @description:
 * @author: zkw
 * @create: 2020-11-03 14:42
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(30);
        for (int i = 9; i < 20; i++) {
            arrayQueue.addQueue(i);
        }
        arrayQueue.showQueue();

    }
}

class CircleArrayQueue {
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

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部
        front = 0;
        //指向队列的尾部（既是最后一个数字）
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能去除数据");
        }
        //这里需要分析出front是指向第一个元素
        //1、先把front对应的值保留到一个临时变量
        //2、将front后移 front++;可能会越界 考虑取模
        //3、将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的数据
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr" + i % maxSize + arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     */
    public int size() {
        //rear=2
        //front=1
        //maxSize=3;
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
