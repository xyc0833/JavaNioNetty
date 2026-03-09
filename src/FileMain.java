import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileMain {
    public static void main(String[] args) throws IOException {
    /*
      通过RandomAccessFile进行创建，注意后面的mode有几种：
      r        以只读的方式使用
      rw   读操作和写操作都可以
      rws  每当进行写操作，同步的刷新到磁盘，刷新内容和元数据
      rwd  每当进行写操作，同步的刷新到磁盘，刷新内容
     */
        try(RandomAccessFile f = new RandomAccessFile("test.txt", "rw");  //这里设定为支持读写，这样创建的通道才能具有这些功能
            FileChannel channel = f.getChannel()){   //通过RandomAccessFile创建一个通道
            channel.write(ByteBuffer.wrap("伞兵二号马飞飞准备就绪！".getBytes()));

            System.out.println("写操作完成之后文件访问位置："+channel.position());  //注意读取也是从现在的位置开始
            channel.position(0);  //需要将位置变回到最前面，这样下面才能从文件的最开始进行读取

            ByteBuffer buffer = ByteBuffer.allocate(128);
            channel.read(buffer);
            buffer.flip();


            System.out.println(new String(buffer.array(), 0, buffer.remaining()));


        }
    }
}
