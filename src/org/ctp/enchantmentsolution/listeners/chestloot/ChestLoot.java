package org.ctp.enchantmentsolution.listeners.chestloot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.ctp.enchantmentsolution.nms.ChestPopulateNMS;

public class ChestLoot {

	private Block startingBlock;
	private List<Block> lootToCheck = new ArrayList<Block>();
	private List<Block> checkedBlocks = new ArrayList<Block>();
	private boolean checkBlocks = false;
	
	protected ChestLoot(Block b) {
		startingBlock = b;
	}
	
	protected void checkBlocks() {
		checkBlocks(startingBlock);
		checkBlocks = true;
	}
	
	@SuppressWarnings("deprecation")
	private void checkBlocks(Block block) {
		if(checkedBlocks.contains(block)) return;
		checkedBlocks.add(block);
		if(block.getType() == Material.HOPPER) {
			Block[] possibleChest = new Block[3];
			switch(block.getData()) {
			case 0:
			case 8:
				possibleChest[0] = block.getRelative(BlockFace.DOWN);
				break;
			case 2:
			case 10:
				possibleChest[0] = block.getRelative(BlockFace.NORTH);
				break;
			case 3:
			case 11:
				possibleChest[0] = block.getRelative(BlockFace.SOUTH);
				break;
			case 4:
			case 12:
				possibleChest[0] = block.getRelative(BlockFace.EAST);
				break;
			case 5:
			case 13:
				possibleChest[0] = block.getRelative(BlockFace.WEST);
				break;
			default:
				possibleChest[0] = block.getRelative(BlockFace.DOWN);
			}
			possibleChest[1] = block.getRelative(BlockFace.DOWN);
			possibleChest[2] = block.getRelative(BlockFace.UP);
			for(int i = 0; i < possibleChest.length; i++) {
				checkBlocks(possibleChest[i]);
			}
		}
		if(block.getType() == Material.CHEST) {
			checkChest(block);
		}
	}
	
	private void checkChest(Block block) {
		if(ChestPopulateNMS.isLootChest(block)) {
			lootToCheck.add(block);
		}
	}
	
	protected List<Block> getLootToCheck() throws ChestLootException{
		if(checkBlocks == false) {
			throw new ChestLootException("Property has yet to be defined.", new Throwable("Property has yet to be defined."));
		}
		return lootToCheck;
	}
}
