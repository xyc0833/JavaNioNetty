import java.util.function.Function;
import java.util.function.Supplier;

public class Student {
    private String name = "xyc0833";
    public void takeName(Supplier<String> name){
        this.name = name.get();
    }

    //需要我帮小明实现namelength方法
    //Function 本身是一个函数式接口
    public void nameLength(Function<String,Integer> function){
        Integer apply = function.apply(name);
        System.out.println("我的名字长度是：" + apply);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
