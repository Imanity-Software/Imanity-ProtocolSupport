package protocolsupport.protocol.transformer.middlepacketimpl.serverbound.play.v_1_4_1_5_1_6_1_7;

import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.serverbound.play.MiddleLook;

import java.io.IOException;

public class Look extends MiddleLook {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		yaw = serializer.readFloat();
		pitch = serializer.readFloat();
		onGround = serializer.readBoolean();
	}

}
