package protocolsupport.protocol.typeremapper.watchedentity.types;

import protocolsupport.protocol.typeremapper.watchedentity.remapper.SpecificType;

public abstract class WatchedEntity {

	private int id;

	public WatchedEntity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public abstract SpecificType getType();

	@Override
	public String toString() {
		return new StringBuilder(100)
		.append("Id: ").append(getId()).append(", ")
		.append("Type: ").append(getType())
		.toString();
	}

}
