import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        //这是普通的处理
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        //移除为B的元素
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next().equals("B")) iterator.remove();
//        }

        //这是通过Stream的处理
        list = list //链式调用
                .stream() //获取流
                .filter(e -> !e.equals("B")) //只允许所有不是B的元素通过流水线
                .collect(Collectors.toList()); //将流水线中的元素重新收集起来，变回List

        System.out.println(list);

        List<Integer> list01 = Arrays.asList(1,2,3,4,5,6);
        list01
                .stream()
                .map(x ->x) //map可以对实现接受一种类型的数据，转为同类型或另一类型的数据
                .map(x -> x + 1)
                .forEach(System.out::println);

        list01
                .stream()
                .map(x -> x.toString())
                .collect(Collectors.toSet());

        System.out.println(list01);


    }
}
