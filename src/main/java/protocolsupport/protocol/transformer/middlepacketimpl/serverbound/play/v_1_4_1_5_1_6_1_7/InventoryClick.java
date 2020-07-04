package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.play.v_1_4_1_5_1_6_1_7;

import org.bukkit.event.inventory.InventoryType;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.play.MiddleInventoryClick;
import protocolsupport.protocol.transformer.v_1_7.utils.WindowStorage;

import java.io.IOException;

public class InventoryClick extends MiddleInventoryClick {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		windowId = serializer.readUnsignedByte();
		slot = serializer.readShort();
		WindowStorage storage = WindowStorage.getStorage(player);
		if (storage != null && storage.get((short) windowId) == 4) {
			if (slot > 0) {
				slot++;
			}
		}
		button = serializer.readUnsignedByte();
		actionNumber = serializer.readShort();
		mode = serializer.readUnsignedByte();
		itemstack = serializer.readItemStack();
	}

}
