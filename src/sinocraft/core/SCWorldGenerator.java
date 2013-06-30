package sinocraft.core;

import java.util.Random;

import scala.collection.generic.BitOperations.Int;
import sinocraft.core.register.SCBlocks;
import sinocraft.plants.blocks.BlockGlutinousRice;
import sinocraft.plants.blocks.BlockPeony;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 世界生成器
 * @author Liong
 *
 */

public class SCWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		for (int i = 0; i <= 8; i++)
		{
			if (random.nextBoolean())
				switch (world.provider.dimensionId)
				{
					case 0:
						int j = random.nextInt(1);
						
						switch (j)
						{
							case 0: S_beach(random, chunkX, chunkZ, world, SCBlocks.blockReed); break;
						}
						break;
					case -1: N(random, chunkX, chunkZ, world); break;
				}
		}
	}
	
	private void S_plain(Random random, int chunkX, int chunkZ, World world, Block block)
	{
		int x = chunkX * 16 + random.nextInt(8) - random.nextInt(8);
		int z = chunkZ * 16 + random.nextInt(8) - random.nextInt(8);
		int y = world.getHeightValue(x, z) + random.nextInt(4) - random.nextInt(4);
		
		if (world.isAirBlock(x, y, z) && block.canBlockStay(world, x, y, z))
			world.setBlock(x, y, z, block.blockID, 0, 3);
	}
	
	private void S_wildcrops(Random random, int chunkX, int chunkZ, World world, Block block)
	{
		int x = chunkX * 16 + random.nextInt(8) - random.nextInt(8);
		int z = chunkZ * 16 + random.nextInt(8) - random.nextInt(8);
		int y = world.getHeightValue(x, z) + random.nextInt(4) - random.nextInt(4);
		
		if (world.isAirBlock(x, y, z))
			if (world.getBlockId(x, y - 1, z) == block.tilledField.blockID &&
			(world.getBlockMaterial(x - 1, y - 1, z	  ) == Material.water ||
			world.getBlockMaterial(x + 1, y - 1, z	  ) == Material.water ||
			world.getBlockMaterial(x	, y - 1, z - 1) == Material.water ||
			world.getBlockMaterial(x	, y - 1, z + 1) == Material.water))
				world.setBlock(x, y - 1, z, block.tilledField.blockID, 0, 3);
				world.setBlock(x, y, z, block.blockID, 0, 3);
	}
	
	private void S_beach(Random random, int chunkX, int chunkZ, World world, Block block)
	{
		int x = chunkX * 16 + random.nextInt(8) - random.nextInt(8);
		int z = chunkZ * 16 + random.nextInt(8) - random.nextInt(8);
		int y = world.getHeightValue(x, z) + random.nextInt(4) - random.nextInt(4);
		
		if (world.isAirBlock(x, y, z) && block.canBlockStay(world, x, y, z));
			world.setBlock(x, y, z, block.blockID, 0, 3);
	}
	
	private void N(Random random, int chunkX, int chunkZ, World world)
	{
		
	}
}
