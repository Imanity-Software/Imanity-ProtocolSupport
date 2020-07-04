package protocolsupport.protocol.transformer.v_1_7.utils;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ShortOpenHashMap;
import org.bukkit.entity.Player;
import protocolsupport.protocol.transformer.utils.LegacyUtils;

public class WindowStorage {

    public static final String WINDOW_META = "ProtocolSupport-WindowMetaData";
    private Short2ShortOpenHashMap windows = new Short2ShortOpenHashMap();

    public void add(short windowId, short windowType) {
        this.windows.put(windowId, windowType);
    }

    public int get(short windowId) {
        return this.windows.get(windowId);
    }

    public void remove(short windowId) {
        this.windows.remove(windowId);
    }

    public static WindowStorage getStorage(Player player) {
        if (player.hasMetadata(WindowStorage.WINDOW_META)) {
            return (WindowStorage) player.getMetadata(WindowStorage.WINDOW_META).get(0).value();
        }
        return null;
    }

}
