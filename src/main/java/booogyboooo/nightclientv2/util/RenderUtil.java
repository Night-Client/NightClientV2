package booogyboooo.nightclientv2.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityType;

public class RenderUtil {
	private static Color col = new Color(255, 255, 255);
	private static List<EntityType<?>> entityTypes = new ArrayList<EntityType<?>>();
	
	public static Color getColor() {
		return col;
	}
	
	public static void setColor(Color color) {
		col = color;
	}
	
	public static List<EntityType<?>> getEntitys() {
		return entityTypes;
	}
	
	public static void addEntity(EntityType<?> entity) {
		entityTypes.add(entity);
	}
	
	public static void removeEntity(EntityType<?> entity) {
		entityTypes.remove(entity);
	}
}