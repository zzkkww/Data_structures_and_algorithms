package LeetCode;

/**
 * @author zkw
 * @date 2021-04-29
 **/
public class test {
    public static void main(String[] args) {
        new HelloB();
    }
}

class HelloA{
    public  HelloA(){
        System.out.println("HelloA");
    }

    {
        System.out.println("I‘m A class");
    }

    static {
        System.out.println("static A");
    }
}


class HelloB extends HelloA{
    public HelloB(){
        System.out.println("HelloB");
    }

    {
        System.out.println("I‘m B class");
    }

    static {
        System.out.println("static B");
    }
}