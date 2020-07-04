package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;

public abstract class MiddleScoreboardScore<T> extends ClientBoundMiddlePacket<T> {

	protected String name;
	protected int mode;
	protected String objectiveName;
	protected int value;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		name = serializer.readString(40);
		mode = serializer.readUnsignedByte();
		objectiveName = serializer.readString(16);
		if (mode != 1) {
			value = serializer.readVarInt();
		}
	}

}
