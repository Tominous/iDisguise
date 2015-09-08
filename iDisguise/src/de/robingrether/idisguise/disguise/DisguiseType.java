package de.robingrether.idisguise.disguise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * This enum contains all types, you can disguise as.<br>
 * <br>
 * WARNING: At any time, types may be added/removed from this Enum.
 * 
 * @since 2.1.3
 * @author Robingrether
 */
public enum DisguiseType {
	
	BAT(Type.MOB, "EntityBat"),
	BLAZE(Type.MOB, "EntityBlaze"),
	CAVE_SPIDER(Type.MOB, "EntityCaveSpider"),
	CHICKEN(Type.MOB, "EntityChicken"),
	COW(Type.MOB, "EntityCow"),
	CREEPER(Type.MOB, "EntityCreeper"),
	ENDER_DRAGON(Type.MOB, "EntityEnderDragon"),
	ENDERMAN(Type.MOB, "EntityEnderman"),
	ENDERMITE(Type.MOB, "EntityEndermite"),
	GHAST(Type.MOB, "EntityGhast"),
	GIANT(Type.MOB, "EntityGiantZombie"),
	GUARDIAN(Type.MOB, "EntityGuardian"),
	HORSE(Type.MOB, "EntityHorse"),
	IRON_GOLEM(Type.MOB, "EntityGolem"),
	MAGMA_CUBE(Type.MOB, "EntityMagmaCube"),
	MUSHROOM_COW(Type.MOB, "EntityMushroomCow"),
	OCELOT(Type.MOB, "EntityOcelot"),
	PIG(Type.MOB, "EntityPig"),
	PIG_ZOMBIE(Type.MOB, "EntityPigZombie"),
	RABBIT(Type.MOB, "EntityRabbit"),
	SHEEP(Type.MOB, "EntitySheep"),
	SILVERFISH(Type.MOB, "EntitySilverfish"),
	SKELETON(Type.MOB, "EntitySkeleton"),
	SLIME(Type.MOB, "EntitySlime"),
	SNOWMAN(Type.MOB, "EntitySnowman"),
	SPIDER(Type.MOB, "EntitySpider"),
	SQUID(Type.MOB, "EntitySquid"),
	VILLAGER(Type.MOB, "EntityVillager"),
	WITCH(Type.MOB, "EntityWitch"),
	WITHER(Type.MOB, "EntityWither"),
	WOLF(Type.MOB, "EntityWolf"),
	ZOMBIE(Type.MOB, "EntityZombie"),
	
	GHOST(Type.PLAYER, "EntityPlayer"),
	PLAYER(Type.PLAYER, "EntityPlayer");
	
	//BLOCK(Type.OBJECT),
	//ENDER_CRYSTAL(Type.OBJECT),
	//PRIMED_TNT(Type.OBJECT);
	
	private Type type;
	private String className;
	
	private DisguiseType(Type type, String className) {
		this.type = type;
		this.className = className;
	}
	
	/**
	 * Checks whether the type is a mob.
	 * 
	 * @since 2.1.3
	 * @return true if it's a mob, false if not
	 */
	public boolean isMob() {
		return type == Type.MOB;
	}
	
	/**
	 * Checks whether the type is a player.
	 * 
	 * @since 2.1.3
	 * @return true if it's a player, false if not
	 */
	public boolean isPlayer() {
		return type == Type.PLAYER;
	}
	
	/**
	 * Checks whether the type is an object.
	 * 
	 * @since 2.1.3
	 * @return true if it's an object, false if not
	 */
	public boolean isObject() {
		return type == Type.OBJECT;
	}
	
	/**
	 * Returns the type of this disguise type.
	 * 
	 * @since 2.2.2
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	public Class<?> getClass(String packageName) throws ClassNotFoundException {
		return Class.forName(packageName + "." + className);
	}
	
	private static Random random = new Random();
	
	/**
	 * Creates a random disguise type.
	 * 
	 * @since 2.2.2
	 * @param type the type the disguise type should be, if this is null the type is ignored
	 * @return a random disguise type
	 */
	public static DisguiseType random(Type type) {
		LinkedList<DisguiseType> types = new LinkedList<DisguiseType>(Arrays.asList(values()));
		if(type != null) {
			int pos = 0;
			while(pos < types.size()) {
				if(types.get(pos).getType() != type) {
					types.remove(pos);
				} else {
					pos++;
				}
			}
		}
		return types.get(random.nextInt(types.size()));
	}
	
	/**
	 * The type a disguise can be: mob, player, object.
	 * 
	 * @since 2.1.3
	 * @author Robingrether
	 */
	public enum Type {
		
		MOB,
		PLAYER,
		OBJECT
		
	}
	
}