package protocolsupport.protocol;

import com.google.common.collect.BiMap;
import net.minecraft.server.v1_8_R3.*;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying.PacketPlayInLook;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying.PacketPlayInPosition;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying.PacketPlayInPositionLook;
import org.spigotmc.SneakyThrow;
import protocolsupport.utils.Utils;

import java.util.Map;

public enum ServerBoundPacket {

	HANDSHAKE_START(PacketHandshakingInSetProtocol.class),
	STATUS_REQUEST(PacketStatusInStart.class),
	STATUS_PING(PacketStatusInPing.class),
	LOGIN_START(PacketLoginInStart.class),
	LOGIN_ENCRYPTION_BEGIN(PacketLoginInEncryptionBegin.class),
	PLAY_KEEP_ALIVE(PacketPlayInKeepAlive.class),
	PLAY_CHAT(PacketPlayInChat.class),
	PLAY_USE_ENTITY(PacketPlayInUseEntity.class),
	PLAY_PLAYER(PacketPlayInFlying.class),
	PLAY_POSITION(PacketPlayInPosition.class),
	PLAY_LOOK(PacketPlayInLook.class),
	PLAY_POSITION_LOOK(PacketPlayInPositionLook.class),
	PLAY_BLOCK_DIG(PacketPlayInBlockDig.class),
	PLAY_BLOCK_PLACE(PacketPlayInBlockPlace.class),
	PLAY_HELD_SLOT(PacketPlayInHeldItemSlot.class),
	PLAY_ANIMATION(PacketPlayInArmAnimation.class),
	PLAY_ENTITY_ACTION(PacketPlayInEntityAction.class),
	PLAY_STEER_VEHICLE(PacketPlayInSteerVehicle.class),
	PLAY_WINDOW_CLOSE(PacketPlayInCloseWindow.class),
	PLAY_WINDOW_CLICK(PacketPlayInWindowClick.class),
	PLAY_WINDOW_TRANSACTION(PacketPlayInTransaction.class),
	PLAY_CREATIVE_SET_SLOT(PacketPlayInSetCreativeSlot.class),
	PLAY_ENCHANT_SELECT(PacketPlayInEnchantItem.class),
	PLAY_UPDATE_SIGN(PacketPlayInUpdateSign.class),
	PLAY_ABILITIES(PacketPlayInAbilities.class),
	PLAY_TAB_COMPLETE(PacketPlayInTabComplete.class),
	PLAY_SETTINGS(PacketPlayInSettings.class),
	PLAY_CLIENT_COMMAND(PacketPlayInClientCommand.class),
	PLAY_CUSTOM_PAYLOAD(PacketPlayInCustomPayload.class);

	public static void init() {
	}

	private final int id;
	private final EnumProtocol protocol;
	@SuppressWarnings("unchecked")
	ServerBoundPacket(Class<? extends Packet<?>> packetClass) {
		Map<Class<? extends Packet<?>>, EnumProtocol> protocolMap = null;
		try {
			protocolMap = (Map<Class<? extends Packet<?>>, EnumProtocol>) Utils.setAccessible(EnumProtocol.class.getDeclaredField("h")).get(null);
		} catch (Throwable t) {
			SneakyThrow.sneaky(t);
		}
		this.protocol = protocolMap.get(packetClass);
		Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>> idMap = null;
		try {
			idMap = (Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>>) Utils.setAccessible(EnumProtocol.class.getDeclaredField("j")).get(protocol);
		} catch (Throwable t) {
			SneakyThrow.sneaky(t);
		}
		this.id = idMap.get(EnumProtocolDirection.SERVERBOUND).inverse().get(packetClass);
	}

	public Packet<?> get() throws IllegalAccessException, InstantiationException {
		return protocol.a(EnumProtocolDirection.SERVERBOUND, id);
	}

	public int getId() {
		return id;
	}

}
