package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleBlockChangeSingle<T> extends MiddleBlock<T> {

	protected int id;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		super.readFromServerData(serializer);
		id = serializer.readVarInt();
	}

}
