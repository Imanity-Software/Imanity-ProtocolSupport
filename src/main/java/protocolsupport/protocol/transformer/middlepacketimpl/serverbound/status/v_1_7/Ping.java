package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.status.v_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.status.MiddlePing;

import java.io.IOException;

public class Ping extends MiddlePing {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		pingId = serializer.readLong();
	}

}
