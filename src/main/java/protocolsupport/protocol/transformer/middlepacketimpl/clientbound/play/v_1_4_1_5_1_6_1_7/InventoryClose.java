package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6_1_7;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleInventoryClose;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.v_1_7.utils.WindowStorage;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

import java.io.IOException;

public class InventoryClose extends MiddleInventoryClose<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, version);
		serializer.writeByte(windowId);

		WindowStorage storage = WindowStorage.getStorage(player);
		if (storage != null) {
			storage.remove((short) windowId);
		}

		return RecyclableSingletonList.create(serializer);
	}

}
