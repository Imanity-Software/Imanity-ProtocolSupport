package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleBlockTileUpdate<T> extends MiddleBlock<T> {

	protected int type;
	protected NBTTagCompound tag;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		super.readFromServerData(serializer);
		type = serializer.readUnsignedByte();
		tag = serializer.readTag();
	}

}
