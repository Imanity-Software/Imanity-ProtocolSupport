package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.status.v_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.status.MiddleServerInfoRequest;

import java.io.IOException;

public class ServerInfoRequest extends MiddleServerInfoRequest {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
	}

}
