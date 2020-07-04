package protocolsupport.utils.chat;

import com.google.gson.*;
import protocolsupport.api.chat.modifiers.ClickAction;

import java.lang.reflect.Type;

public class ClickActionSerializer implements JsonDeserializer<ClickAction>, JsonSerializer<ClickAction> {

	@Override
	public ClickAction deserialize(JsonElement element, Type type, JsonDeserializationContext ctx) throws JsonParseException {
		JsonObject jsonobject = element.getAsJsonObject();
		if (!jsonobject.has("clickEvent")) {
			return null;
		}
		JsonObject clickObject = jsonobject.getAsJsonObject("clickEvent");
		ClickAction.Type atype = ClickAction.Type.valueOf(clickObject.getAsJsonPrimitive("action").getAsString().toUpperCase());
		return new ClickAction(atype, clickObject.getAsJsonPrimitive("value").getAsString());
	}

	@Override
	public JsonElement serialize(ClickAction action, Type type, JsonSerializationContext ctx) {
		JsonObject object = new JsonObject();
		object.addProperty("action", action.getType().toString().toLowerCase());
		object.addProperty("value", action.getValue());
		return object;
	}

}
