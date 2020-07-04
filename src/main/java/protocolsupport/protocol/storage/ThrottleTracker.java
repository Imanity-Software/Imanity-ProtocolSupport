package protocolsupport.protocol.storage;

import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraft.server.v1_8_R3.MinecraftServer;

import java.net.InetAddress;

public class ThrottleTracker {

	private static final Object2LongOpenHashMap<InetAddress> tracker = new Object2LongOpenHashMap<>();
	private static final long time = MinecraftServer.getServer().server.getConnectionThrottle();

	public static boolean isEnabled() {
		return time > 0;
	}

	public static void track(InetAddress address, long time) {
		synchronized (tracker) {
			tracker.put(address, time);
			if (tracker.size() > 100) {
				long currentTime = System.currentTimeMillis();
				tracker.entrySet().removeIf(entry -> (currentTime - entry.getValue()) < time);
			}
		}
	}

	public static boolean isThrottled(InetAddress address) {
		synchronized (tracker) {
			return tracker.containsKey(address) && ((System.currentTimeMillis() - tracker.get(address)) < time);
		}
	}

}
