package protocolsupport.api.events;

import org.bukkit.event.HandlerList;

import java.net.InetSocketAddress;

public class PlayerDisconnectEvent extends PlayerEvent {

	public PlayerDisconnectEvent(InetSocketAddress address, String username) {
		super(address, username);
	}

	private static final HandlerList list = new HandlerList();

	@Override
	public HandlerList getHandlers() {
		return list;
	}

	public static HandlerList getHandlerList() {
		return list;
	}

}
