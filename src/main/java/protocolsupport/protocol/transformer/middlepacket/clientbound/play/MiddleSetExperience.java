package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;

public abstract class MiddleSetExperience<T> extends ClientBoundMiddlePacket<T> {

	protected float exp;
	protected int level;
	protected int totalExp;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		exp = serializer.readFloat();
		level = serializer.readVarInt();
		totalExp = serializer.readVarInt();
	}

}
