package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_4_1_5_1_6;

import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.Items;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleMap;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.utils.MapTransformer;
import protocolsupport.protocol.transformer.utils.MapTransformer.ColumnEntry;
import protocolsupport.protocol.typeremapper.id.IdRemapper;
import protocolsupport.protocol.typeremapper.id.RemappingTable;
import protocolsupport.utils.recyclable.RecyclableArrayList;
import protocolsupport.utils.recyclable.RecyclableCollection;

public class Map extends MiddleMap<RecyclableCollection<PacketData>> {

	private static final int mapId = Item.getId(Items.FILLED_MAP);

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) {
		RecyclableCollection<PacketData> datas = RecyclableArrayList.create();
		PacketData scaledata = PacketData.create(ClientBoundPacket.PLAY_MAP_ID, version);
		scaledata.writeShort(358);
		scaledata.writeShort(itemData);
		scaledata.writeShort(2);
		scaledata.writeByte(2);
		scaledata.writeByte(scale);
		datas.add(scaledata);
		if (icons.length > 0) {
			PacketData iconsdata = PacketData.create(ClientBoundPacket.PLAY_MAP_ID, version);
			iconsdata.writeShort(mapId);
			iconsdata.writeShort(itemData);
			iconsdata.writeShort(icons.length * 3 + 1);
			iconsdata.writeByte(1);
			for (Icon icon : icons) {
				iconsdata.writeByte(icon.dirtype);
				iconsdata.writeByte(icon.x);
				iconsdata.writeByte(icon.z);
			}
			datas.add(iconsdata);
		}
		if (columns > 0) {
			MapTransformer maptransformer = new MapTransformer();
			maptransformer.loadFromNewMapData(columns, rows, xstart, zstart, data);
			RemappingTable colorRemapper = IdRemapper.MAPCOLOR.getTable(version);
			for (ColumnEntry entry : maptransformer.toPre18MapData()) {
				PacketData mapdata = PacketData.create(ClientBoundPacket.PLAY_MAP_ID, version);
				mapdata.writeShort(mapId);
				mapdata.writeShort(itemData);
				mapdata.writeShort(3 + entry.getColors().length);
				mapdata.writeByte(0);
				mapdata.writeByte(entry.getX());
				mapdata.writeByte(entry.getY());
				byte[] colors = entry.getColors();
				for (int i = 0; i < colors.length; i++) {
					colors[i] = (byte) colorRemapper.getRemap(colors[i]);
				}
				mapdata.writeBytes(colors);
				datas.add(mapdata);
			}
		}
		return datas;
	}

}
