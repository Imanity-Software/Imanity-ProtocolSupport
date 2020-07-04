package protocolsupport.protocol.transformer.middlepacket;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.storage.LocalStorage;

import java.io.IOException;

public abstract class ClientBoundMiddlePacket<T> extends MiddlePacket {

	protected LocalStorage storage;

	public void setLocalStorage(LocalStorage storage) {
		this.storage = storage;
	}

	public void handle() {
	}

	public abstract void readFromServerData(PacketDataSerializer serializer) throws IOException;

	public abstract T toData(ProtocolVersion version) throws IOException;

}
