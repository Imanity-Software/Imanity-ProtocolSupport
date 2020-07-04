package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.play.v_1_4_1_5_1_6_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.play.MiddleHeldSlot;

import java.io.IOException;

public class HeldSlot extends MiddleHeldSlot {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		slot = serializer.readShort();
	}

}
