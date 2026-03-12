//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //Study study = a -> a + 10;
        //等价于：
        //Study study = (int a) -> a + 10;
        //等价于：
        /**
         * Study study = (int a) -> {
         *      return a + 10;
         *   };
         */
        //如果参数只有一个，那么可以省去小括号：
        //多行的话 加上花括号
        //一行的话 还可以继续省略花括号
        //Study study1 = () -> System.out.println("abcabc");
        //study.study(11);
        //study1.study();

        Study study = () -> System.out.println("hello world");
        test(study);

        //然后更简单的写法
        //直接把study接口的实现放进去了
        test( () -> System.out.println("123123"));
    }

    //比方说 test方法 需要一个study对象
    private static void test(Study study){

    }
}