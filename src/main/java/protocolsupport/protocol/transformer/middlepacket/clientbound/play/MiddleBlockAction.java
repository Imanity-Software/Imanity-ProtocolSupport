package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleBlockAction<T> extends MiddleBlock<T> {

	protected int info1;
	protected int info2;
	protected int type;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		super.readFromServerData(serializer);
		info1 = serializer.readUnsignedByte();
		info2 = serializer.readUnsignedByte();
		type = serializer.readVarInt();
	}

}
