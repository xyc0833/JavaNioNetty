import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public class ByteMain {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        CharBuffer buffer02 = CharBuffer.allocate(10);
        buffer02.put("lbwnb");  //除了可以直接丢char之外，字符串也可以一次性丢进入
        System.out.println(buffer02.array());
        System.out.println(Arrays.toString(buffer.array()));

        buffer02.flip();
        System.out.println(buffer02);


        //这里我们申请一个直接缓冲区
        ByteBuffer buffer03 = ByteBuffer.allocateDirect(10);
        //使用方式基本和之前是一样的
        buffer03.put((byte) 66);
        buffer03.flip();
        System.out.println(buffer03.get());
    }
}
