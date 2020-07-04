package protocolsupport.protocol.transformer.middlepacket.clientbound.login;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;

public abstract class MiddleEncryptionRequest<T> extends ClientBoundMiddlePacket<T> {

	protected String serverId;
	protected byte[] publicKey;
	protected byte[] verifyToken;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		serverId = serializer.readString(Short.MAX_VALUE);
		publicKey = serializer.readArray();
		verifyToken = serializer.readArray();
	}

}
