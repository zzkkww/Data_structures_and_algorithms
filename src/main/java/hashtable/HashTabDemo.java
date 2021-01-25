package hashtable;

import java.util.Objects;
import java.util.Scanner;

/**
 * 哈希表的实现  这里哈希表之所以高效率就是因为同时管理多条链表
 *
 * @author zkw
 * @date 2020-11-24
 **/
public class HashTabDemo {
    public static void main(String[] args) {
        //创建一个哈希表
        HashTab hashTab = new HashTab(7);

        /**
         * 写一个简单的菜单
         */
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建HashTab 管理多条链表的哈希表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * 表示有多少条链表
     */
    private int size;

    /**
     * 构造器
     */
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //留了一个坑, 报了空指针如果没有下面的处理     解决方法：这时不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     */
    public void add(Emp emp) {
        //根据员工的id ，得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    /**
     * 根据输入id查找雇员
     */
    public void findEmpById(int id) {
        //使用散列函数，去哪条链表找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (Objects.nonNull(emp)) {
            System.out.println(emp.toString());
        } else {
            System.out.println("没有找到该雇员信息");
        }
    }

    /**
     * 遍历所有的链表
     * 就相当于遍历hash表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            //这里的list方法是单链表里面的list
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 编写一个散列函数，使用一个简单的算法，取模法
     */
    public int hashFun(int id) {
        return id % size;
    }

}


/**
 * 表示一个雇员的信息
 */
class Emp {
    public int id;
    public String name;
    /**
     * 一个带有头结点的单链表   next默认为空
     */
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


//创建EmpLinkedList,表示链表
class EmpLinkedList {
    //头指针，指向第一个Emp,因此我们这个链表的head 是直接指向第一个Emp 而不是像我们之前的那个单链表
    /**
     * 默认Null
     */
    private Emp head;

    /**
     * 添加雇员到链表中
     * 1、假定，当添加雇员时，id是自增长，即id的分配总是从小到大
     * 因此我们将该雇员直接加入到本链表的最后即可，先不考虑顺序的问题这里
     */
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (head.next == null) {
                //说明链表到最后了
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    /**
     * 根据id查找雇员
     * 如果查找到就返回emp，如果没有找到，就返回null
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                //找到了
                break;
            }
            if (curEmp.next == null) {
                //说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println(no + "链表为空");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.println("=>id:::" + curEmp.id + "curEmp.name:::" + curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }
}