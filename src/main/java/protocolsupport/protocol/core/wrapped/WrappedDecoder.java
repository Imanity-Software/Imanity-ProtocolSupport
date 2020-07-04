package protocolsupport.protocol.core.wrapped;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketListener;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import protocolsupport.api.events.PlayerDisconnectEvent;
import protocolsupport.protocol.core.IPacketDecoder;
import protocolsupport.protocol.storage.ProtocolStorage;
import protocolsupport.protocol.transformer.handlers.AbstractLoginListener;
import protocolsupport.utils.netty.ChannelUtils;
import spg.lgdev.config.iSpigotConfig;

import java.net.InetSocketAddress;
import java.util.List;

public class WrappedDecoder extends ByteToMessageDecoder {

	private IPacketDecoder realDecoder = new IPacketDecoder() {
		@Override
		public void decode(ChannelHandlerContext ctx, ByteBuf input, List<Object> list) throws Exception {
		}
	};

	public void setRealDecoder(IPacketDecoder realDecoder) {
		this.realDecoder = realDecoder;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf input, List<Object> list) throws Exception {
		realDecoder.decode(ctx, input, list);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		try {
			InetSocketAddress addr = (InetSocketAddress) ChannelUtils.getNetworkManagerSocketAddress(ctx.channel());
			String username = null;
			PacketListener listener = ChannelUtils.getNetworkManager(ctx.channel()).getPacketListener();
			if (listener instanceof AbstractLoginListener) {
				GameProfile profile = ((AbstractLoginListener) listener).getProfile();
				if (profile != null) {
					username = profile.getName();
				}
			} else if (listener instanceof PlayerConnection) {
				username = ((PlayerConnection) listener).player.getProfile().getName();
			}
			if (username != null) {
				PlayerDisconnectEvent event = new PlayerDisconnectEvent(addr, username);
				Bukkit.getPluginManager().callEvent(event);
			}
			ProtocolStorage.clearData(addr);
		} catch (Throwable t) {
			if (MinecraftServer.getServer().isDebugging()) {
				t.printStackTrace();
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
		if (iSpigotConfig.debug_mode) {
			throwable.printStackTrace();
		}
		super.exceptionCaught(channelHandlerContext, throwable);
	}

}
