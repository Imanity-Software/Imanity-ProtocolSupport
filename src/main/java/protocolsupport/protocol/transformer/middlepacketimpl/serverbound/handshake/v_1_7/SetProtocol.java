package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.handshake.v_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.handshake.MiddleSetProtocol;

import java.io.IOException;

public class SetProtocol extends MiddleSetProtocol {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		serializer.readVarInt();
		hostname = serializer.readString(Short.MAX_VALUE);
		port = serializer.readUnsignedShort();
		nextState = serializer.readVarInt();
	}

}
