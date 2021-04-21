package abstrac;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zkw
 * @date 2021-04-07
 **/
public class ASon extends A{

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + "线程运行开始!");

        System.out.println("这时 thread1 执行完毕之后才能执行主线程");

        ASon aSon = new ASon();
        aSon.hhaha();
//        aSon.finalize();
        int []arr={1,2,3};

        System.out.println("253656");
        new Thread(()->{
            try {
                Thread.yield();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("哈哈哈");
            new Thread(()->{
                System.out.println("线程的子线程");
            }).start();
        }).start();

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        System.out.println("wait完了");

    }


    public void hhaha(){
        this.printA();
    }

    @Override
    public void printB() {

    }
}
