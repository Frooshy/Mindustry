package io.anuke.mindustry.world.blocks;

import io.anuke.mindustry.Vars;
import io.anuke.mindustry.entities.effect.Fx;
import io.anuke.mindustry.resource.Item;
import io.anuke.mindustry.resource.Liquid;
import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.Tile;
import io.anuke.mindustry.world.blocks.types.production.*;
import io.anuke.ucore.core.Effects;
import io.anuke.ucore.core.Timers;

public class ProductionBlocks{
	public static final Block
	
	core = new Block("core"){
		{
			health = 600;
			solid = true;
			destructible = true;
			width = 3;
			height = 3;
		}
		
		@Override
		public int handleDamage(Tile tile, int amount){
			return Vars.debug ? 0 : amount;
		}
		
		@Override
		public void handleItem(Item item, Tile tile, Tile source){
			Vars.control.addItem(item, 1);
		}
		
		@Override
		public boolean acceptItem(Item item, Tile dest, Tile source){
			return true;
		}
	},
	
	pump = new Pump("pump"){{
		description = "Pumps liquids into nearby conduits.";
		fullDescription = "Pumps liquids from a source block- usually water, lava or oil. Outputs liquid into nearby conduits.";
	}},
	
	fluxpump = new Pump("fluxpump"){{
		pumpAmount = 3f;
		description = "Pumps liquids into nearby conduits.";
		fullDescription = "An advanced version of the pump. Stores more liquid and pumps liquid faster.";
	}},
	
	smelter = new Crafter("smelter"){
		{
			health = 70;
			requirements = new Item[]{Item.coal, Item.iron};
			result = Item.steel;
			description = "Converts coal + iron to steel.";
			fullDescription = "The essential crafting block. When inputted 1x iron and 1x iron, outputs one steel.";
		}
	},
	
	crucible = new Crafter("crucible"){
		{
			health = 90;
			requirements = new Item[]{Item.titanium, Item.steel};
			result = Item.dirium;
			description = "Converts steel + titanium to dirium.";
			fullDescription = "An advanced crafting block. When inputted 1x titanium and 1x steel, outputs one dirium.";
		}
	},
	
	coalpurifier = new LiquidCrafter("coalpurifier"){
		{
			formalName = "coal extractor";
			input = Item.stone;
			inputAmount = 5;
			inputLiquid = Liquid.water;
			liquidAmount = 18.99f;
			output = Item.coal;
			health = 50;
			purifyTime = 60;
			description = "Converts stone + water to coal.";
			fullDescription = "A basic extractor block. Outputs coal when supplied with large amounts of water and stone.";
		}
	},
	
	titaniumpurifier = new LiquidCrafter("titaniumpurifier"){
		{
			formalName = "titanium extractor";
			input = Item.iron;
			inputAmount = 6;
			inputLiquid = Liquid.water;
			liquidAmount = 40f;
			liquidCapacity = 41f;
			purifyTime = 80;
			output = Item.titanium;
			health = 70;
			description = "Converts iron + water to titanium.";
			fullDescription = "A standard extractor block. Outputs titanium when supplied with large amounts of water and iron.";
		}
	},
	
	oilrefinery = new LiquidCrafter("oilrefinery"){
		{
			formalName = "oil refinery";
			inputLiquid = Liquid.oil;
			liquidAmount = 45f;
			liquidCapacity = 46f;
			purifyTime = 70;
			output = Item.coal;
			health = 80;
			craftEffect = Fx.purifyoil;
			description = "Converts oil to coal.";
			fullDescription = "Refines large amounts of oil into coal items. Useful for fueling coal-based turrets when coal veins are scarce.";
		}
	},
	
	stoneformer = new LiquidCrafter("stoneformer"){
		{
			formalName = "stone former";
			input = Item.iron;
			inputAmount = 2;
			inputLiquid = Liquid.lava;
			liquidAmount = 20f;
			liquidCapacity = 21f;
			purifyTime = 10;
			output = Item.stone;
			health = 80;
			craftEffect = Fx.purifystone;
			description = "Converts lava to stone.";
			fullDescription = "Soldifies liquid lava into stone. Useful for producing massive amounts of stone for coal purifiers.";
		}
	},
	
	lavasmelter = new LiquidCrafter("lavasmelter"){
		{
			formalName = "lava smelter";
			inputLiquid = Liquid.lava;
			liquidAmount = 40f;
			liquidCapacity = 41f;
			purifyTime = 30;
			output = Item.stone;
			health = 80;
			craftEffect = Fx.purifystone;
			description = "Converts iron + lava to steel.";
			fullDescription = "Uses lava to convert iron to steel. An alternative to smelteries. Useful in situations where coal is scarace.";
		}
	},
	
	stonedrill = new Drill("stonedrill"){{
		resource = Blocks.stone;
		result = Item.stone;
		formalName = "stone drill";
		description = "Mines 1 "+resource.name+" every "+time+" seconds.";
		fullDescription = "The essential drill. When placed on stone tiles, outputs stone at a slow pace indefinitely.";
	}},
	
	irondrill = new Drill("irondrill"){{
		resource = Blocks.iron;
		result = Item.iron;
		formalName = "iron drill";
		description = "Mines 1 "+resource.name+" every "+time+" seconds.";
		fullDescription = "A basic drill. When placed on iron ore tiles, outputs iron at a slow pace indefinitely.";
	}},
	
	coaldrill = new Drill("coaldrill"){{
		resource = Blocks.coal;
		result = Item.coal;
		formalName = "coal drill";
		description = "Mines 1 "+resource.name+" every "+time+" seconds.";
		fullDescription = "A basic drill. When placed on coal ore tiles, outputs coal at a slow pace indefinitely.";
	}},
	
	uraniumdrill = new Drill("uraniumdrill"){{
		resource = Blocks.uranium;
		result = Item.uranium;
		formalName = "uranium drill";
		time = 7;
		description = "Mines 1 "+resource.name+" every "+time+" seconds.";
		fullDescription = "An advanced drill. When placed on uranium ore tiles, outputs uranium at a slow pace indefinitely.";
	}},
	
	titaniumdrill = new Drill("titaniumdrill"){{
		resource = Blocks.titanium;
		result = Item.titanium;
		formalName = "titanium drill";
		description = "Mines 1 "+resource.name+" every "+time+" seconds.";
		fullDescription = "An advanced drill. When placed on titanium ore tiles, outputs titanium at a slow pace indefinitely.";
	}},
	
	omnidrill = new Drill("omnidrill"){
		{
			time = 3;
			formalName = "omnidrill";
			description = "Mines 1 of any resource every "+time+" seconds.";
			fullDescription = "The ultimate drill. Will mine any ore it is placed on at a rapid pace.";
		}
		
		@Override
		public void update(Tile tile){

			if(tile.floor().drops != null && Timers.get(tile, "drill", 60 * time)){
				offloadNear(tile, tile.floor().drops.item);
				Effects.effect(Fx.sparkbig, tile.worldx(), tile.worldy());
			}

			if(Timers.get(tile, "dump", 30)){
				tryDump(tile);
			}
		}
	},
	coalgenerator = new ItemPowerGenerator("coalgenerator"){
		{
			//TODO
			formalName = "coal generator";
			generateItem = Item.coal;
			generateAmount = 4f;
			powerCapacity = 40f;
			description = "Generates power from coal.";
			fullDescription = "The essential generator. Generates power from coal. Outputs power as lasers to its 4 sides.";
		}
	},
	thermalgenerator = new LiquidPowerGenerator("thermalgenerator"){
		{
			formalName = "thermal generator";
			//TODO
			generateLiquid = Liquid.lava;
			inputLiquid = 20f;
			generatePower = 1f;
			powerCapacity = 40f;
			description = "Generates power from lava.";
			fullDescription = "Generates power from lava. Outputs power as lasers to its 4 sides.";
		}
	},
	combustiongenerator = new LiquidPowerGenerator("combustiongenerator"){
		{
			formalName = "combustion generator";
			//TODO
			generateLiquid = Liquid.oil;
			inputLiquid = 14f;
			generatePower = 1f;
			powerCapacity = 40f;
			description = "Generates power from oil.";
			fullDescription = "Generates power from oil. Outputs power as lasers to its 4 sides.";
		}
	},
	rtgenerator = new ItemPowerGenerator("rtgenerator"){
		{
			//TODO make this generate slowly
			formalName = "RTG generator";
			generateItem = Item.uranium;
			generateAmount = 10f;
			powerCapacity = 40f;
			generateTime = 50f;
			description = "Generates power from uranium.";
			fullDescription = "Generates small amounts of power from the radioactive decay of uranium. Outputs power as lasers to its 4 sides.";
		}
	},
	nuclearReactor = new LiquidItemPowerGenerator("nuclearreactor"){
		{
			//TODO
			formalName = "nuclear reactor";
			width = 3;
			height = 3;
			generateLiquid = Liquid.water;
			generateItem = Item.uranium;
			itemCapacity = 60;
			itemInput = 6;
			inputLiquid = 2f;
			health = 500;
			breaktime *= 2.2f;
			powerCapacity = 100f;
			description = "Generates power from uranium + water.";
			fullDescription = "The ultimate power generator. Highly volatile. Generates power from uranium. Requires constant cooling in the form of water. "
					+ "Will explode violently if insufficient amounts of coolant are supplied. ";
		}
	};
}
