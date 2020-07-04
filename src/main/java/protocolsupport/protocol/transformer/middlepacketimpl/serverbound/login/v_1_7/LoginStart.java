package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.login.v_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.login.MiddleLoginStart;

import java.io.IOException;

public class LoginStart extends MiddleLoginStart {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		name = serializer.readString(16);
	}

}
