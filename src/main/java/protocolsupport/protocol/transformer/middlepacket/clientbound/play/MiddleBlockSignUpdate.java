package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleBlockSignUpdate<T> extends MiddleBlock<T> {

	protected String[] linesJson = new String[4];

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		super.readFromServerData(serializer);
		for (int i = 0; i < linesJson.length; i++) {
			linesJson[i] = serializer.readString(Short.MAX_VALUE);
		}
	}

}
