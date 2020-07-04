package protocolsupport.protocol.transformer.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import protocolsupport.utils.netty.ChannelUtils;

import java.util.List;
import java.util.zip.Inflater;

public class PacketDecompressor extends net.minecraft.server.v1_8_R3.PacketDecompressor {

	private final Inflater inflater = new Inflater();

	public PacketDecompressor(int threshold) {
		super(threshold);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		inflater.end();
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf from, List<Object> list) throws Exception {
		if (!from.isReadable()) {
			return;
		}
		int uncompressedlength = ChannelUtils.readVarInt(from);
		if (uncompressedlength == 0) {
			list.add(from.readBytes(from.readableBytes()));
		} else {
			this.inflater.setInput(ChannelUtils.toArray(from));
			byte[] uncompressed = new byte[uncompressedlength];
			this.inflater.inflate(uncompressed);
			list.add(Unpooled.wrappedBuffer(uncompressed));
			this.inflater.reset();
		}
	}

}
