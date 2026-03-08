import java.nio.IntBuffer;
import java.util.Arrays;

public class OtherMain {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        IntBuffer duplicate = buffer.duplicate();

        System.out.println(buffer == duplicate);
        System.out.println(buffer.array() == duplicate.array());

        //底层的数组由于在构造的时候没有进行任何的拷贝而是直接传递，
        //因此实际上两个缓冲区的底层数组是同一个对象。
        //所以，一个发生修改，那么另一个就跟着变了：


        IntBuffer buffer01 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        for (int i = 0; i < 4; i++) buffer01.get();
        IntBuffer slice = buffer01.slice();

        System.out.println("划分之后的情况："+Arrays.toString(slice.array()));
        System.out.println("划分之后的偏移地址："+slice.arrayOffset());
        System.out.println("当前position位置："+slice.position());
        System.out.println("当前limit位置："+slice.limit());

        while (slice.hasRemaining()) {   //将所有的数据全部挨着打印出来
            System.out.print(slice.get()+", ");
        }



        IntBuffer buffer1 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        IntBuffer buffer2 = IntBuffer.wrap(new int[]{6, 5, 4, 3, 2, 1, 7, 8, 9, 0});
        System.out.println(buffer1.equals(buffer2));   //直接比较

        buffer1.position(6);
        buffer2.position(6);
        System.out.println(buffer1.equals(buffer2));   //比较从下标6开始的剩余内容

        IntBuffer readonly = buffer1.asReadOnlyBuffer();
    }
}
