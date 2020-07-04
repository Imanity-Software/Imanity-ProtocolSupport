package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.play.v_1_4_1_5;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.play.MiddlePlayerAbilities;

import java.io.IOException;

public class PlayerAbilities extends MiddlePlayerAbilities {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		flags = serializer.readUnsignedByte();
		flySpeed = serializer.readUnsignedByte() / 255.0F;
		walkSpeed = serializer.readUnsignedByte() / 255.0F;
	}

}
