import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        //有时需要实现一系列的操作之后才能给到小明的名字
        //supplier 这个类有且仅有一个待实现的接口 叫做get方法
        s1.takeName(() -> {
            //比方说在返回“小明”这个之前需要做一些额外的判断 处理等等
            //可以放在这里写
            return "小明";//返回类型一定是string
        });

        /**
         * 等价于
         * s1.takeName(new Supplier<String>() {
         *             @Override
         *             public String get() {
         *                 return "";
         *             }
         *         });
         */


        s1.nameLength(name ->{
            return name.length();
        });

    }
}