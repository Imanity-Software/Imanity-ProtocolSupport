package protocolsupport.protocol.storage;

import com.mojang.authlib.properties.Property;
import gnu.trove.map.hash.TIntObjectHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import protocolsupport.protocol.transformer.utils.LegacyUtils;
import protocolsupport.protocol.typeremapper.watchedentity.types.WatchedEntity;
import protocolsupport.protocol.typeremapper.watchedentity.types.WatchedPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LocalStorage {

	private final Int2ObjectOpenHashMap<WatchedEntity> watchedEntities = new Int2ObjectOpenHashMap<>();
	private WatchedPlayer player;
	private final HashMap<UUID, PlayerListEntry> playerlist = new HashMap<>();

	public void addWatchedEntity(WatchedEntity entity) {
		watchedEntities.put(entity.getId(), entity);
	}

	public void addWatchedSelfPlayer(WatchedPlayer player) {
		this.player = player;
		addWatchedEntity(player);
	}

	private void readdSelfPlayer() {
		if (player != null) {
			addWatchedEntity(player);
		}
	}

	public WatchedEntity getWatchedEntity(int entityId) {
		return watchedEntities.get(entityId);
	}

	public void removeWatchedEntities(int[] entityIds) {
		for (int entityId : entityIds) {
			watchedEntities.remove(entityId);
		}
		readdSelfPlayer();
	}

	public void clearWatchedEntities() {
		watchedEntities.clear();
		readdSelfPlayer();
	}

	public void addPlayerListEntry(UUID uuid, PlayerListEntry entry) {
		playerlist.put(uuid, entry);
	}

	public PlayerListEntry getPlayerListEntry(UUID uuid) {
		return playerlist.get(uuid);
	}

	public void removePlayerListEntry(UUID uuid) {
		playerlist.remove(uuid);
	}

	public static class PlayerListEntry implements Cloneable {
		private final String name;
		private String displayNameJson;
		private final PropertiesStorage propstorage = new PropertiesStorage();

		public PlayerListEntry(String name) {
			this.name = name;
		}

		public void setDisplayNameJson(String displayNameJson) {
			this.displayNameJson = displayNameJson;
		}

		public PropertiesStorage getProperties() {
			return propstorage;
		}

		public String getUserName() {
			return name;
		}

		public String getName() {
			return displayNameJson == null ? name : LegacyUtils.toText(ChatSerializer.a(displayNameJson));
		}

		@Override
		public PlayerListEntry clone() {
			PlayerListEntry clone = new PlayerListEntry(name);
			clone.displayNameJson = displayNameJson;
			for (Property property : propstorage.getAll(false)) {
				clone.propstorage.add(property);
			}
			return clone;
		}
	}

	public static class PropertiesStorage {
		private final HashMap<String, Property> signed = new HashMap<String, Property>();
		private final HashMap<String, Property> unsigned = new HashMap<String, Property>();

		public void add(Property property) {
			if (property.hasSignature()) {
				signed.put(property.getName(), property);
			} else {
				unsigned.put(property.getName(), property);
			}
		}

		public List<Property> getAll(boolean signedOnly) {
			if (signedOnly) {
				return new ArrayList<Property>(signed.values());
			} else {
				ArrayList<Property> properties = new ArrayList<>();
				properties.addAll(signed.values());
				properties.addAll(unsigned.values());
				return properties;
			}
		}
	}

}
