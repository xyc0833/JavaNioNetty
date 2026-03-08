import java.nio.IntBuffer;
import java.util.Arrays;

public class GetMain {
    public static void main(String[] args) {
        //wrap方法 将现有的数组直接转换为缓冲区
        IntBuffer buffer = IntBuffer.wrap(new int[]{1,2,3,4,5});
        int [] orignal = {10,20,30,40};

        System.out.println(buffer.get(0));
        System.out.println(buffer.get());
        //这里的get操作是把 buffer里的内容 写入到 orignal数组里面去
        System.out.println(buffer.get(orignal));//[2,3,4,5]
        System.out.println(Arrays.toString(orignal));
        System.out.println("===================");
        System.out.println(Arrays.toString(buffer.array()));
        IntBuffer buffer01 = IntBuffer.allocate(10);
        // 含义：从缓冲区当前position(0)读取2个数据，写入orignal数组的offset=1位置
        buffer01.get(orignal, 1, 2);

        System.out.println(Arrays.toString(orignal));


    }
}
