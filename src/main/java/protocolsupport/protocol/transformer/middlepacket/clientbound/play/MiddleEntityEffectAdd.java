package protocolsupport.protocol.transformer.middlepacket.clientbound.play;

import protocolsupport.protocol.PacketDataSerializer;

import java.io.IOException;

public abstract class MiddleEntityEffectAdd<T> extends MiddleEntity<T> {

	protected int effectId;
	protected int amplifier;
	protected int duration;
	protected boolean hideParticles;

	@Override
	public void readFromServerData(PacketDataSerializer serializer) throws IOException {
		super.readFromServerData(serializer);
		effectId = serializer.readByte();
		amplifier = serializer.readByte();
		duration = serializer.readVarInt();
		hideParticles = serializer.readBoolean();
	}

}
