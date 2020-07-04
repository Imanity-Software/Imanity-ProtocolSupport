package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;

public abstract class MiddlePlayerAbilities<T> extends ClientBoundMiddlePacket<T> {

	protected int flags;
	protected float flyspeed;
	protected float walkspeed;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		flags = serializer.readUnsignedByte();
		flyspeed = serializer.readFloat();
		walkspeed = serializer.readFloat();
	}

}
