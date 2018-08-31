package day12.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf buf;

    /**
     * 有2个生命周期的监听方法：handlerAdded()和 handlerRemoved()
     * 你可以完成任意初始化任务只要他不会被阻塞很长的时间。
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        // 当添加的时候，buf会被初始化
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        // 当删除这个handler的时候，会释放这个buf
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /**
         * 在TCP/IP中，Netty 会把读到的数据放到 ByteBuf 的数据结构中。
         */
        ByteBuf m = (ByteBuf) msg;
        // 首先，所有接收的数据都应该被累积在 buf 变量里。
        buf.writeBytes(m);
        m.release();
        // 然后，处理器必须检查 buf 变量是否有足够的数据，在这个例子中是4个字节，然后处理实际的业务逻辑。
        // 否则，Netty 会重复调用channelRead() 当有更多数据到达直到4个字节的数据被积累。
        if (buf.readableBytes() >= 4) {
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}