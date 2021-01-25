package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 * @author zkw
 * @date 2020-11-11
 **/
public class PolandNotation {
    public static void main(String[] args) {

        //中缀表达式转成后缀表达式的功能
        //说明
        //1+((2+3)×4)-5=>转换 1 2 3 + 4 × + 5 -
        //2、先将他放到arrayList中，方便我们操作
        //将得到的中缀表达式对应的List=> 1 2 3 + 4 * + 5 -
        String expression = "1+((2+3)*4)-5";

        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        System.out.println("============逆波兰表达式===============");
        List<String> xxxparseSuffixExpression = parseSuffixExpression(infixExpressionList);
        System.out.println(xxxparseSuffixExpression);

        /**
         * ====================
         */


        // 先定义一个逆波兰表达式
        //(3+4)×5-6 ==>3 4 + 5 × 6 -
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 × 6 -";
        //思路
        //1、先将“3 4 + 5 × 6 -"==>放到ArrayList中
        /**
         * 为什么要先放ArrayList中，因为一个个扫描太慢了，所以直接放
         */
        //2、将ArrayList传递给一个方法，配合栈，完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        //测试结果
        int res = calculate(list);
        System.out.println("计算的最终结果=" + res);
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     * 1、从左至右扫描，将3和4压入栈
     * 2、遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈
     * 3、将5入栈
     * 4、接下来是×运算符，因此弹出5合7，计算出7×5=35，将35入栈
     * 5、将6入栈；
     * 6、最后是-运算符，计算出35-6的值，既29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {
                //匹配的是多位数
                stack.push(item);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("×".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

    //=====================  中缀转后缀表达式     ========================//

    /**
     * 将中缀表达式转换成对应的list
     */
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> ls = new ArrayList<String>();
        int i = 0;//这是一个指针，用于遍历中缀表达字符串
        String str;//存放多位数
        char c;//每遍历一个字符，就放入到c

        do {
            //如果c是一个非数字，就需要加入到ls中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                //如果是一个数，就需要考虑多位数的问题
                str = "";//先将str制成"";空
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼rr接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    public static List<String> parseSuffixExpression(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //因为s2这个栈，在整个过程中，没有pop操作，而且后面我们还需要逆序输出
        //Stack<String> s2 = new Stack<String>();//数字栈
        ArrayList<String> s2 = new ArrayList<String>();//数字

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (("(").equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                //如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }//注意这里就是为了去除括号 ，因为逆波兰表达式不需要括号
                //最后s1要弹出括号“(”
                s1.pop();
            } else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并压入到s2中，重复操作。直到优先级大于s1里的栈顶元素，则压入item进s1
                //问题，缺少一个比较优先级的方法（已经补充完整）
                while (s1.size() != 0 && (Operation.getValue(s1.peek())) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);
            }
        }
        //最后将s1中剩余的运算符一次弹出并加入s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;//注意因为是存放到List中，因此存放的就是逆波兰表达式
    }

}

//编写一个类Operation 可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;//减
    private static int MUL = 2;//乘法
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}

