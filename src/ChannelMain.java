import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ChannelMain {
    public static void main(String[] args) throws IOException {
        //缓冲区创建好，一会就靠它来传输数据
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //将System.in作为输入源，一会Channel就可以从这里读取数据，然后通过缓冲区装载一次性传递数据
        ReadableByteChannel readChannel = Channels.newChannel(System.in);
        while (true) {
            //将通道中的数据写到缓冲区中，缓冲区最多一次装10个
            readChannel.read(buffer);
            //写入操作结束之后，需要进行翻转，以便接下来的读取操作
            buffer.flip();
            //最后转换成String打印出来康康
            System.out.println("读取到一批数据："+new String(buffer.array(), 0, buffer.remaining()));
            //回到最开始的状态
            buffer.clear();
        }
    }
}
