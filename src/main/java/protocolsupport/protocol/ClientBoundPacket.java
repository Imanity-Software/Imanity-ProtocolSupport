package protocolsupport.protocol;

import com.google.common.collect.BiMap;
import net.minecraft.server.v1_8_R3.*;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity.PacketPlayOutEntityLook;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity.PacketPlayOutRelEntityMove;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook;
import org.spigotmc.SneakyThrow;
import protocolsupport.utils.Utils;

import java.util.Map;

public class ClientBoundPacket {

	public static void init() {
	}

	public static final int LOGIN_DISCONNECT_ID = getId(PacketLoginOutDisconnect.class);
	public static final int LOGIN_ENCRYPTION_BEGIN_ID = getId(PacketLoginOutEncryptionBegin.class);
	public static final int LOGIN_SUCCESS_ID = getId(PacketLoginOutSuccess.class);
	public static final int STATUS_SERVER_INFO_ID = getId(PacketStatusOutServerInfo.class);
	public static final int STATUS_PONG_ID = getId(PacketStatusOutPong.class);
	public static final int PLAY_KEEP_ALIVE_ID = getId(PacketPlayOutKeepAlive.class);
	public static final int PLAY_LOGIN_ID = getId(PacketPlayOutLogin.class);
	public static final int PLAY_CHAT_ID = getId(PacketPlayOutChat.class);
	public static final int PLAY_UPDATE_TIME_ID = getId(PacketPlayOutUpdateTime.class);
	public static final int PLAY_ENTITY_EQUIPMENT_ID = getId(PacketPlayOutEntityEquipment.class);
	public static final int PLAY_SPAWN_POSITION_ID = getId(PacketPlayOutSpawnPosition.class);
	public static final int PLAY_UPDATE_HEALTH_ID = getId(PacketPlayOutUpdateHealth.class);
	public static final int PLAY_RESPAWN_ID = getId(PacketPlayOutRespawn.class);
	public static final int PLAY_POSITION_ID = getId(PacketPlayOutPosition.class);
	public static final int PLAY_HELD_SLOT_ID = getId(PacketPlayOutHeldItemSlot.class);
	public static final int PLAY_BED_ID = getId(PacketPlayOutBed.class);
	public static final int PLAY_ANIMATION_ID = getId(PacketPlayOutAnimation.class);
	public static final int PLAY_SPAWN_NAMED_ID = getId(PacketPlayOutNamedEntitySpawn.class);
	public static final int PLAY_COLLECT_EFFECT_ID = getId(PacketPlayOutCollect.class);
	public static final int PLAY_SPAWN_OBJECT_ID = getId(PacketPlayOutSpawnEntity.class);
	public static final int PLAY_SPAWN_LIVING_ID = getId(PacketPlayOutSpawnEntityLiving.class);
	public static final int PLAY_SPAWN_PAINTING_ID = getId(PacketPlayOutSpawnEntityPainting.class);
	public static final int PLAY_SPAWN_EXP_ORB_ID = getId(PacketPlayOutSpawnEntityExperienceOrb.class);
	public static final int PLAY_ENTITY_VELOCITY_ID = getId(PacketPlayOutEntityVelocity.class);
	public static final int PLAY_ENTITY_DESTROY_ID = getId(PacketPlayOutEntityDestroy.class);
	public static final int PLAY_ENTITY_ID = getId(PacketPlayOutEntity.class);
	public static final int PLAY_ENTITY_REL_MOVE_ID = getId(PacketPlayOutRelEntityMove.class);
	public static final int PLAY_ENTITY_LOOK_ID = getId(PacketPlayOutEntityLook.class);
	public static final int PLAY_ENTITY_REL_MOVE_LOOK_ID = getId(PacketPlayOutRelEntityMoveLook.class);
	public static final int PLAY_ENTITY_TELEPORT_ID = getId(PacketPlayOutEntityTeleport.class);
	public static final int PLAY_ENTITY_HEAD_ROTATION_ID = getId(PacketPlayOutEntityHeadRotation.class);
	public static final int PLAY_ENTITY_STATUS_ID = getId(PacketPlayOutEntityStatus.class);
	public static final int PLAY_ENTITY_ATTACH_ID = getId(PacketPlayOutAttachEntity.class);
	public static final int PLAY_ENTITY_METADATA_ID = getId(PacketPlayOutEntityMetadata.class);
	public static final int PLAY_ENTITY_EFFECT_ADD_ID = getId(PacketPlayOutEntityEffect.class);
	public static final int PLAY_ENTITY_EFFECT_REMOVE_ID = getId(PacketPlayOutRemoveEntityEffect.class);
	public static final int PLAY_EXPERIENCE_ID = getId(PacketPlayOutExperience.class);
	public static final int PLAY_ENTITY_ATTRIBUTES_ID = getId(PacketPlayOutUpdateAttributes.class);
	public static final int PLAY_CHUNK_SINGLE_ID = getId(PacketPlayOutMapChunk.class);
	public static final int PLAY_BLOCK_CHANGE_MULTI_ID = getId(PacketPlayOutMultiBlockChange.class);
	public static final int PLAY_BLOCK_CHANGE_SINGLE_ID = getId(PacketPlayOutBlockChange.class);
	public static final int PLAY_BLOCK_ACTION_ID = getId(PacketPlayOutBlockAction.class);
	public static final int PLAY_BLOCK_BREAK_ANIMATION_ID = getId(PacketPlayOutBlockBreakAnimation.class);
	public static final int PLAY_CHUNK_MULTI_ID = getId(PacketPlayOutMapChunkBulk.class);
	public static final int PLAY_EXPLOSION_ID = getId(PacketPlayOutExplosion.class);
	public static final int PLAY_WORLD_EVENT_ID = getId(PacketPlayOutWorldEvent.class);
	public static final int PLAY_WORLD_SOUND_ID = getId(PacketPlayOutNamedSoundEffect.class);
	public static final int PLAY_WORLD_PARTICLES_ID = getId(PacketPlayOutWorldParticles.class);
	public static final int PLAY_GAME_STATE_CHANGE_ID = getId(PacketPlayOutGameStateChange.class);
	public static final int PLAY_SPAWN_WEATHER_ID = getId(PacketPlayOutSpawnEntityWeather.class);
	public static final int PLAY_WINDOW_OPEN_ID = getId(PacketPlayOutOpenWindow.class);
	public static final int PLAY_WINDOW_CLOSE_ID = getId(PacketPlayOutCloseWindow.class);
	public static final int PLAY_WINDOW_SET_SLOT_ID = getId(PacketPlayOutSetSlot.class);
	public static final int PLAY_WINDOW_SET_ITEMS_ID = getId(PacketPlayOutWindowItems.class);
	public static final int PLAY_WINDOW_DATA_ID = getId(PacketPlayOutWindowData.class);
	public static final int PLAY_WINDOW_TRANSACTION_ID = getId(PacketPlayOutTransaction.class);
	public static final int PLAY_UPDATE_SIGN_ID = getId(PacketPlayOutUpdateSign.class);
	public static final int PLAY_MAP_ID = getId(PacketPlayOutMap.class);
	public static final int PLAY_UPDATE_TILE_ID = getId(PacketPlayOutTileEntityData.class);
	public static final int PLAY_SIGN_EDITOR_ID = getId(PacketPlayOutOpenSignEditor.class);
	public static final int PLAY_STATISTICS = getId(PacketPlayOutStatistic.class);
	public static final int PLAY_PLAYER_INFO_ID = getId(PacketPlayOutPlayerInfo.class);
	public static final int PLAY_ABILITIES_ID = getId(PacketPlayOutAbilities.class);
	public static final int PLAY_TAB_COMPLETE_ID = getId(PacketPlayOutTabComplete.class);
	public static final int PLAY_SCOREBOARD_OBJECTIVE_ID = getId(PacketPlayOutScoreboardObjective.class);
	public static final int PLAY_SCOREBOARD_SCORE_ID = getId(PacketPlayOutScoreboardScore.class);
	public static final int PLAY_SCOREBOARD_DISPLAY_SLOT_ID = getId(PacketPlayOutScoreboardDisplayObjective.class);
	public static final int PLAY_SCOREBOARD_TEAM_ID = getId(PacketPlayOutScoreboardTeam.class);
	public static final int PLAY_CUSTOM_PAYLOAD_ID = getId(PacketPlayOutCustomPayload.class);
	public static final int PLAY_KICK_DISCONNECT_ID = getId(PacketPlayOutKickDisconnect.class);
	public static final int PLAY_RESOURCE_PACK_ID = getId(PacketPlayOutResourcePackSend.class);

	@SuppressWarnings("unchecked")
	private static final int getId(Class<?> packetClass) {
		Map<Class<? extends Packet<?>>, EnumProtocol> protocolMap = null;
		try {
			protocolMap = (Map<Class<? extends Packet<?>>, EnumProtocol>) Utils.setAccessible(EnumProtocol.class.getDeclaredField("h")).get(null);
		} catch (Throwable t) {
			SneakyThrow.sneaky(t);
		}
		EnumProtocol protocol = protocolMap.get(packetClass);
		Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>> idMap = null;
		try {
			idMap = (Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>>) Utils.setAccessible(EnumProtocol.class.getDeclaredField("j")).get(protocol);
		} catch (Throwable t) {
			SneakyThrow.sneaky(t);
		}
		return idMap.get(EnumProtocolDirection.CLIENTBOUND).inverse().get(packetClass);
	}

}
