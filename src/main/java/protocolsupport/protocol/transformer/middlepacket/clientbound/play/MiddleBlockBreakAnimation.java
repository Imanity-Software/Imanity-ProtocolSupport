package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleBlockBreakAnimation<T> extends MiddleBlock<T> {

	protected int entityId;
	protected int stage;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		entityId = serializer.readVarInt();
		super.readFromServerData(serializer);
		stage = serializer.readByte();
	}

}
