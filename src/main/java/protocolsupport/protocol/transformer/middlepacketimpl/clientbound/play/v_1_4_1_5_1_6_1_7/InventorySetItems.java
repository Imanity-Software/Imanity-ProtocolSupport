package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6_1_7;

import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.event.inventory.InventoryType;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleInventorySetItems;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.v_1_7.utils.WindowStorage;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

import java.io.IOException;

public class InventorySetItems extends MiddleInventorySetItems<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		WindowStorage storage = WindowStorage.getStorage(player);
		if (storage != null && storage.get((short) windowId) == 4) {
			ItemStack[] old = itemstacks;
			itemstacks = new ItemStack[old.length - 1];
			itemstacks[0] = old[0];
			System.arraycopy(old, 2, itemstacks, 1, old.length - 3);
		}
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_WINDOW_SET_ITEMS_ID, version);
		serializer.writeByte(windowId);
		serializer.writeShort(itemstacks.length);
//		serializer.writeItemStack(itemstacks[0]);
		for (ItemStack itemstack : itemstacks) {
			serializer.writeItemStack(itemstack);
		}
		return RecyclableSingletonList.create(serializer);
	}

}
