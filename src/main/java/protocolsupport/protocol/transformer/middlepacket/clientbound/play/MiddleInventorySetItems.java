package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import net.minecraft.server.v1_8_R3.ItemStack;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.ClientBoundMiddlePacket;

import java.io.IOException;
import java.util.ArrayList;

public abstract class MiddleInventorySetItems<T> extends ClientBoundMiddlePacket<T> {

	protected int windowId;
	protected ItemStack[] itemstacks;

	@Override
	public boolean needsPlayer() {
		return true;
	}

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		windowId = serializer.readUnsignedByte();
		int count = serializer.readShort();
		itemstacks = new ItemStack[count];
		for (int i = 0; i < count; i++) {
			itemstacks[i] = serializer.readItemStack();
		}
	}

}
