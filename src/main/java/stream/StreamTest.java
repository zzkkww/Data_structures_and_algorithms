package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** stream测试
 * @author zkw
 * @date 2020-11-23
 **/
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("jack",20));
        list.add(new Person("mike",25));
        list.add(new Person("tom",30));

        List<Person> collect = list.stream()
                .filter(person -> person.getAge() == 20)
                .collect(Collectors.toList());

        System.out.println(collect.toString());


        List<Person> collect1 = list.stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .collect(Collectors.toList());
        System.out.println(collect1.toString());

        System.out.println(list.stream().map(Person::getName).sorted().limit(10).collect(Collectors.toList()).toString());
    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
