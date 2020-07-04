package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.login.v_1_4_1_5_1_6_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.login.MiddleEncryptionResponse;

import java.io.IOException;

public class EncryptionResponse extends MiddleEncryptionResponse {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		sharedSecret = serializer.readArray();
		verifyToken = serializer.readArray();
	}

}
