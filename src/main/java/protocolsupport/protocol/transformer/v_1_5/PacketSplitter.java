package protocolsupport.protocol.transformer.v_1_5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import protocolsupport.protocol.core.IPacketSplitter;

import java.util.List;

public class PacketSplitter implements IPacketSplitter {

	@Override
	public void split(ChannelHandlerContext ctx, ByteBuf input, List<Object> list) throws Exception {
		list.add(input.readBytes(input.readableBytes()));
	}

}
