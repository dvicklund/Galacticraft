package micdoodle8.mods.galacticraft.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * Copyright 2012, micdoodle8
 * 
 *  All rights reserved.
 *
 */
public class GCCoreConfigManager 
{
	public static boolean loaded;
	
	static Configuration configuration;
	
	public GCCoreConfigManager(File file)
	{
		if (!loaded)
		{
			configuration = new Configuration(file);
			setDefaultValues();
		}
	}

	// BLOCKS
	public static int idBlockBreatheableAir;
	public static int idBlockTreasureChest;
	public static int idBlockLandingPad;
	public static int idBlockUnlitTorch;
	public static int idBlockUnlitTorchLit;
	public static int idBlockAirDistributor;
	public static int idBlockAirDistributorActive;
	public static int idBlockAirPipe;
	public static int idBlockAirCollector;
	public static int idBlockOre;

	// ITEMS
	public static int idItemLightOxygenTank;
	public static int idItemLightOxygenTankEmpty;
	public static int idItemMedOxygenTank;
	public static int idItemMedOxygenTankEmpty;
	public static int idItemHeavyOxygenTank;
	public static int idItemHeavyOxygenTankEmpty;
	public static int idItemSpaceship;
	public static int idItemIngotTitanium;
	public static int idItemIngotCopper;
	public static int idItemIngotAluminum;
	public static int idItemAluminumCanister;
	public static int idItemAirVent;
	public static int idItemOxygenConcentrator;
	public static int idItemFan;
	
	// ARMOR
	public static int idArmorOxygenMask;
	public static int idArmorSensorGlasses;
	public static int idArmorSensorGlassesWithOxygenMask;
	public static int idArmorTitaniumHelmet;
	public static int idArmorTitaniumChestplate;
	public static int idArmorTitaniumLeggings;
	public static int idArmorTitaniumBoots;
	public static int idArmorTitaniumHelmetBreathable;

	// TOOLS
	public static int idToolTitaniumSword;
	public static int idToolTitaniumPickaxe;
	public static int idToolTitaniumAxe;
	public static int idToolTitaniumSpade;
	public static int idToolTitaniumHoe;
	
	// GUI
	public static int idGuiTankRefill;
	public static int idGuiAirDistributor;
	
	// ACHIEVEMENTS
	public static int idAchievBase;
	
	private void setDefaultValues()
    {
		try
		{
	        configuration.load();
	        
			idBlockBreatheableAir = configuration.getOrCreateIntProperty("Breathable Air Block",								configuration.CATEGORY_BLOCK, 	202).getInt(202);
	        idBlockTreasureChest = configuration.getOrCreateIntProperty("idBlockTreasureChest",		 							configuration.CATEGORY_BLOCK, 	209).getInt(209);
	        idBlockLandingPad = configuration.getOrCreateIntProperty("idBlockLandingPad", 										configuration.CATEGORY_BLOCK, 	210).getInt(210);
	        idBlockUnlitTorch = configuration.getOrCreateIntProperty("idBlockUnlitTorch", 										configuration.CATEGORY_BLOCK, 	213).getInt(213);
	        idBlockUnlitTorchLit = configuration.getOrCreateIntProperty("idBlockUnlitTorchLit", 								configuration.CATEGORY_BLOCK, 	214).getInt(214);
	        idBlockAirDistributor = configuration.getOrCreateIntProperty("idBlockAirDistributor", 								configuration.CATEGORY_BLOCK, 	215).getInt(215);
	        idBlockAirDistributorActive = configuration.getOrCreateIntProperty("idBlockAirDistributorActive", 					configuration.CATEGORY_BLOCK, 	216).getInt(216);
	        idBlockAirPipe = configuration.getOrCreateIntProperty("idBlockAirPipe", 											configuration.CATEGORY_BLOCK, 	217).getInt(217);
	        idBlockAirCollector = configuration.getOrCreateIntProperty("idBlockAirCollector", 									configuration.CATEGORY_BLOCK, 	219).getInt(219);
	        idBlockOre = configuration.getOrCreateIntProperty("idBlockOre", 													configuration.CATEGORY_BLOCK, 	218).getInt(218);

	        idItemLightOxygenTankEmpty = configuration.getOrCreateIntProperty("idItemLightOxygenTankEmpty", 					configuration.CATEGORY_ITEM, 	9854).getInt(9854);
	        idItemLightOxygenTank = configuration.getOrCreateIntProperty("idItemLightOxygenTank", 								configuration.CATEGORY_ITEM, 	9855).getInt(9855);
	        idItemMedOxygenTankEmpty = configuration.getOrCreateIntProperty("idItemMedOxygenTankEmpty", 						configuration.CATEGORY_ITEM, 	9856).getInt(9856);
	        idItemMedOxygenTank = configuration.getOrCreateIntProperty("idItemMedOxygenTank", 									configuration.CATEGORY_ITEM, 	9857).getInt(9857);
	        idItemHeavyOxygenTankEmpty = configuration.getOrCreateIntProperty("idItemHeavyOxygenTankEmpty", 					configuration.CATEGORY_ITEM, 	9858).getInt(9858);
	        idItemHeavyOxygenTank = configuration.getOrCreateIntProperty("idItemHeavyOxygenTank", 								configuration.CATEGORY_ITEM, 	9859).getInt(9859);
	        idArmorOxygenMask = configuration.getOrCreateIntProperty("idArmorOxygenMask", 										configuration.CATEGORY_ITEM, 	9861).getInt(9861);
	        idItemSpaceship = configuration.getOrCreateIntProperty("idItemSpaceship", 											configuration.CATEGORY_ITEM, 	9862).getInt(9862);
			idArmorSensorGlasses = configuration.getOrCreateIntProperty("idItemSensorGlasses", 									configuration.CATEGORY_ITEM, 	9863).getInt(9863);
			idArmorSensorGlassesWithOxygenMask = configuration.getOrCreateIntProperty("idItemSensorGlassesWithOxygenMask", 		configuration.CATEGORY_ITEM, 	9864).getInt(9864);
			idItemIngotTitanium = configuration.getOrCreateIntProperty("idItemIngotTitanium", 									configuration.CATEGORY_ITEM, 	9874).getInt(9874);
			idItemIngotCopper = configuration.getOrCreateIntProperty("idItemIngotCopper", 										configuration.CATEGORY_ITEM, 	9875).getInt(9875);
			idItemIngotAluminum = configuration.getOrCreateIntProperty("idItemIngotAluminum", 									configuration.CATEGORY_ITEM, 	9876).getInt(9876);
			idItemAluminumCanister = configuration.getOrCreateIntProperty("idItemAluminumCanister", 							configuration.CATEGORY_ITEM, 	9914).getInt(9914);
			idItemAirVent = configuration.getOrCreateIntProperty("idItemAirVent", 												configuration.CATEGORY_ITEM, 	9915).getInt(9915);
			idItemOxygenConcentrator = configuration.getOrCreateIntProperty("idItemOxygenConcentrator", 						configuration.CATEGORY_ITEM, 	9916).getInt(9916);
			idItemFan = configuration.getOrCreateIntProperty("idItemFan", 														configuration.CATEGORY_ITEM, 	9917).getInt(9917);

			idToolTitaniumSword = configuration.getOrCreateIntProperty("idToolTitaniumSword", 									configuration.CATEGORY_ITEM, 	9892).getInt(9892);
			idToolTitaniumPickaxe = configuration.getOrCreateIntProperty("idToolTitaniumPickaxe", 								configuration.CATEGORY_ITEM, 	9893).getInt(9893);
			idToolTitaniumSpade = configuration.getOrCreateIntProperty("idToolTitaniumSpade", 									configuration.CATEGORY_ITEM, 	9894).getInt(9894);
			idToolTitaniumHoe = configuration.getOrCreateIntProperty("idToolTitaniumHoe", 										configuration.CATEGORY_ITEM, 	9895).getInt(9895);
			idToolTitaniumAxe = configuration.getOrCreateIntProperty("idToolTitaniumAxe", 										configuration.CATEGORY_ITEM, 	9896).getInt(9896);
			
			idArmorTitaniumHelmet = configuration.getOrCreateIntProperty("idArmorTitaniumHelmet", 								configuration.CATEGORY_ITEM, 	9907).getInt(9907);
			idArmorTitaniumChestplate = configuration.getOrCreateIntProperty("idArmorTitaniumChestplate", 						configuration.CATEGORY_ITEM, 	9908).getInt(9908);
			idArmorTitaniumLeggings = configuration.getOrCreateIntProperty("idArmorTitaniumLeggings", 							configuration.CATEGORY_ITEM, 	9909).getInt(9909);
			idArmorTitaniumBoots = configuration.getOrCreateIntProperty("idArmorTitaniumBoots", 								configuration.CATEGORY_ITEM, 	9910).getInt(9910);
			idArmorTitaniumHelmetBreathable = configuration.getOrCreateIntProperty("idArmorTitaniumHelmetBreathable", 			configuration.CATEGORY_ITEM, 	9911).getInt(9911);
			
	        idGuiTankRefill = configuration.getOrCreateIntProperty("GuiIdTankRefill", 											"GUI", 							128).getInt(128);
	        idGuiAirDistributor = configuration.getOrCreateIntProperty("idGuiAirDistributor", 									"GUI", 							129).getInt(129);
	        
	        idAchievBase = configuration.getOrCreateIntProperty("idAchievBase", 												"Achievements", 				1784).getInt(1784);
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Galacticraft Core has a problem loading it's configuration");
		}
		finally 
		{
			configuration.save();
			loaded = true;
		}
    }
}
