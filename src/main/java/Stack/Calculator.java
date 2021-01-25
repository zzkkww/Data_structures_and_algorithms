package Stack;

/**
 * 栈实现计算器
 *
 * @author zkw
 * @date 2020-11-10
 **/
public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-2";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //将每次扫描得到char保存到ch
        String keepNum = "";

        //定义需要的相关变量
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描得到char保存到ch
        char ch = ' ';
        //开始扫描表达式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理

            //如果是运算符
            if (operStack.isOper(ch)) {
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作优先级小于或等于栈中的操作符，就
                    //需要从数栈中pop两个数，再从符号栈中pop出一个符号，进行运算，将得到结果
                    //入数栈里，然后将当前的操作符如符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //满足后则
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果加入数栈中
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    numStack.push(ch - 48);//详情看ASCLL表
                    //上面这样写有问题 如果是多位数呢
                    //1、当处理多位数时，不能发现是一个数就立即入栈，因为可能是多位数
                    //2、在处理数，需要向expression的表达式index后再看以为，如果是数就继续记性扫描，如果是符号CIA入栈
                    //3、因此我们需要定义一个变量字符串，用于拼接字符串

                    //处理多位数
                    keepNum +=ch;

                    //如果ch已经是expression的最后一位，就直接入栈
                    if (index==expression.length()-1){
                        numStack.push(Integer.parseInt(keepNum));
                    }else {
                        //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                        if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                            //如果后一位是运算符，则入栈
                            numStack.push(Integer.parseInt(keepNum));
                            //重要的！！  必须要清空
                            keepNum="";
                        }
                    }
                }
                //让index+1,并判断是否扫描到expression最后
                index++;
                if (index >= expression.length()) {
                    break;
                }
            }

            //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运行
            while (true) {
                //如果符号栈为空，则计算到最后的结果，数栈中只有一个数
                if (operStack.isEmpty()) {
                    break;
                }
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1, num2, oper);
                numStack.push(res);
            }
            //将数栈的最后数，pop出，就是结果
            int res2 = numStack.pop();
            System.out.println(res2);
        }

    }
}

//先创建一个栈，直接使用，需要扩展功能
//定义一个ArrayStack2 表示栈
class ArrayStack2 {
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
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈满
     */
    public Boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value) {
        //先判断栈是否满了
        if (isFull()) {
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈 将栈顶的数据返回
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈是空的，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈  从栈顶到下面
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[i]" + stack[i]);
        }
    }

    //返回运算符的优先级，我们定义

    /**
     * 数字越大，优先级越高
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            //假定目前只有+-*/
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        //res用于存放计算的结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                //注意顺序
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 增加一个方法，可以放回当前栈顶的值，但是不是真正的pop
     */
    public int peek() {
        return stack[top];
    }
}
