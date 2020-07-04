package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.play.v_1_4_1_5_1_6_1_7;

import org.bukkit.metadata.FixedMetadataValue;
import protocolsupport.ProtocolSupport;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.play.MiddleInventoryClose;
import protocolsupport.protocol.transformer.v_1_7.utils.WindowStorage;

import java.io.IOException;

public class InventoryClose extends MiddleInventoryClose {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		windowId = serializer.readUnsignedByte();

		WindowStorage storage = WindowStorage.getStorage(player);
		if (storage != null) {
			storage.remove((short) windowId);
		}
	}

}
