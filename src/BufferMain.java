import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class BufferMain {
    public static void main(String[] args) {
        //创建一个缓冲区不能直接new，而是需要使用静态方法去生成，有两种方式：
        //1. 申请一个容量为10的int缓冲区
        IntBuffer buffer = IntBuffer.allocate(10);
        //2 可以将现有的数组直接转换为缓冲区（包括数组中的数据）
        int [ ] arr = new int[]{1,2,3,4,5,6};
        IntBuffer buffer01 = IntBuffer.wrap(arr);
        System.out.println(buffer01);
        //Buffer;

        //获取第二个元素
        System.out.println(buffer01.get(1));
        System.out.println(buffer01.put(3,123113));
        System.out.println(buffer01.get(3));

        IntBuffer buffer03 = IntBuffer.allocate(10);
        buffer03
                .put(1)
                .put(2)
                .put(3);   //我们依次存放三个数据试试看
        System.out.println(buffer03.array());
        System.out.println(Arrays.toString(buffer03.array()));

        IntBuffer buffer04 = IntBuffer.allocate(10);
        buffer04.put(arr,3,2);
        System.out.println(Arrays.toString(buffer04.array()));

        buffer04.put(6,123);
    }
}
