package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;

public abstract class MiddleTabComplete<T> extends ClientBoundMiddlePacket<T> {

	protected String[] matches;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		matches = new String[serializer.readVarInt()];
		for (int i = 0; i < matches.length; i++) {
			matches[i] = serializer.readString(Short.MAX_VALUE);
		}
	}

}
