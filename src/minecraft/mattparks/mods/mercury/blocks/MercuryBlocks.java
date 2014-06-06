package mattparks.mods.mercury.blocks;

import mattparks.mods.MattparksCore.ConfigManager;
import mattparks.mods.mercury.GCMercury;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;


public class MercuryBlocks
{
	public static Block MercuryMeteorBlock;
	public static Block MercuryMeteorOre;
	public static Block MercuryGoldOre;
	public static Block MercuryGrass;
	public static Block MercuryDirt;
	public static Block MercuryStone;
	public static Block MercuryBrick;
	public static Block MercuryIridiumBlock;
	public static Block MercuryIridiumOre;
	public static Block MercuryTinOre;
	public static Block MercuryCopperOre;
	public static Block CaravanModule;
	public static Block CaravanModulePart;

	
	public static void initBlocks()
	{
		MercuryBlocks.MercuryGrass = new GCMercuryGrass(ConfigManager.idBlockMercuryGrass, null).setHardness(-1.0F).setUnlocalizedName( "MercuryGrass").setTextureName("galacticraftmercury:grassMercury");

		MercuryBlocks.MercuryDirt = new GCMercuryBlock(ConfigManager.idBlockMercuryDirt, null).setHardness(-1.0F).setUnlocalizedName( "MercuryDirt").setTextureName("galacticraftmercury:dirtMercury");

		MercuryBlocks.MercuryStone = new GCMercuryBlock(ConfigManager.idBlockMercuryStone, null).setHardness(-1.0F).setUnlocalizedName( "MercuryStone").setTextureName("galacticraftmercury:stoneMercury");

		MercuryBlocks.MercuryBrick = new GCMercuryBrick(ConfigManager.idBlockMercuryBrick, null).setHardness(-1.0F).setUnlocalizedName( "MercuryBrick").setTextureName("galacticraftmercury:mercuryBrick");

		MercuryBlocks.MercuryIridiumBlock = new GCMercuryBlock(ConfigManager.idBlockMercuryIridiumBlock, null).setHardness(-1.0F).setUnlocalizedName( "MercuryIridiumBlock").setTextureName("galacticraftmercury:iridiumBlock");

		MercuryBlocks.MercuryIridiumOre = new GCMercuryOre(ConfigManager.idBlockMercuryIridiumOre, null).setHardness(-1.0F).setUnlocalizedName( "MercuryIridiumOre").setTextureName("galacticraftmercury:iridiumOre");

		MercuryBlocks.MercuryTinOre = new GCMercuryOre(ConfigManager.idBlockMercuryTinOre, null).setHardness(-1.0F).setUnlocalizedName( "MercuryTinOre").setTextureName("galacticraftmercury:tinOre");

		MercuryBlocks.MercuryCopperOre = new GCMercuryOre(ConfigManager.idBlockMercuryCopperOre, null).setHardness(-1.0F).setUnlocalizedName( "MercuryCopperOre").setTextureName("galacticraftmercury:copperOre");

		MercuryBlocks.MercuryMeteorBlock = new GCMercuryBlock(ConfigManager.idBlockMercuryMeteorBlock, null).setHardness(-1.0F).setUnlocalizedName("MercuryMeteorBlock").setTextureName("galacticraftmercury:meteorBlock");

		MercuryBlocks.MercuryMeteorOre = new GCMercuryOre(ConfigManager.idBlockMercuryMeteorOre, null).setHardness(-1.0F).setUnlocalizedName("MercuryMeteorOre").setTextureName("galacticraftmercury:meteorOre");
	    
		MercuryBlocks.MercuryGoldOre = new GCMercuryOre(ConfigManager.idBlockMercuryGoldOre, null).setHardness(-1.0F).setUnlocalizedName("MercuryGoldOre").setTextureName("galacticraftmercury:goldOre");

		MercuryBlocks.CaravanModule = new GCCaravanModule(ConfigManager.idBlockCaravanModule, null).setHardness(-1.0F).setUnlocalizedName("CaravanModule").setTextureName("galacticraftmercury:caravanModule");

		MercuryBlocks.CaravanModulePart = new GCCaravanPart(ConfigManager.idBlockCaravanModulePart, null).setHardness(-1.0F).setUnlocalizedName("CaravanModulePart").setTextureName("galacticraftmercury:caravanModulePart");
	}

	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryGrass, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryDirt, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryStone, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryIridiumBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryIridiumOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryTinOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryCopperOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryGoldOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryMeteorOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.MercuryMeteorBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(MercuryBlocks.CaravanModule, "pickaxe", 1);
	}

	public static void registerBlocks()
	{
		GameRegistry.registerBlock(MercuryBlocks.MercuryGrass, ItemBlock.class, MercuryBlocks.MercuryGrass.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryDirt, ItemBlock.class, MercuryBlocks.MercuryDirt.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryStone, ItemBlock.class, MercuryBlocks.MercuryStone.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryBrick, ItemBlock.class, MercuryBlocks.MercuryBrick.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryIridiumBlock, ItemBlock.class, MercuryBlocks.MercuryIridiumBlock.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryIridiumOre, ItemBlock.class, MercuryBlocks.MercuryIridiumOre.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryTinOre, ItemBlock.class, MercuryBlocks.MercuryTinOre.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryCopperOre, ItemBlock.class, MercuryBlocks.MercuryCopperOre.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryMeteorOre, ItemBlock.class, MercuryBlocks.MercuryMeteorOre.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryMeteorBlock, ItemBlock.class, MercuryBlocks.MercuryMeteorBlock.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.MercuryGoldOre, ItemBlock.class, MercuryBlocks.MercuryGoldOre.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.CaravanModule, ItemBlock.class, MercuryBlocks.CaravanModule.getUnlocalizedName(), GCMercury.MODID);
		GameRegistry.registerBlock(MercuryBlocks.CaravanModulePart, ItemBlock.class, MercuryBlocks.CaravanModulePart.getUnlocalizedName(), GCMercury.MODID);	
	}
}
