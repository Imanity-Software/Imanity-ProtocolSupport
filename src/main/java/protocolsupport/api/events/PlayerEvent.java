package protocolsupport.api.events;

import org.bukkit.event.Event;

import java.net.InetSocketAddress;

public abstract class PlayerEvent extends Event {

	private final InetSocketAddress address;
	private final String username;

	public PlayerEvent(InetSocketAddress address, String username) {
		this.address = address;
		this.username = username;
	}

	public InetSocketAddress getAddress() {
		return address;
	}

	public String getName() {
		return username;
	}

}
