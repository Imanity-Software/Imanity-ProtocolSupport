package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6_1_7;

import org.bukkit.event.inventory.InventoryType;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleInventoryData;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.v_1_7.utils.WindowStorage;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableEmptyList;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

import java.io.IOException;

public class InventoryData extends MiddleInventoryData<RecyclableCollection<PacketData>> {

	private static final int[] furTypeTr = {1, 2, 0};

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		WindowStorage storage = WindowStorage.getStorage(player);
		if (storage != null) {
			switch (storage.get((short) windowId)) {
				case 2:
					if (type < furTypeTr.length) {
						type = furTypeTr[type];
					}
					break;
				case 4:
					if (type > 2) {
						return RecyclableEmptyList.get();
					}
					break;
			}
		}
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_WINDOW_DATA_ID, version);
		serializer.writeByte(windowId);
		serializer.writeShort(type);
		serializer.writeShort(value);
		return RecyclableSingletonList.<PacketData>create(serializer);
	}

}
