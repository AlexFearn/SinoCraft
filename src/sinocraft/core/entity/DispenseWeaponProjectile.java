package sinocraft.core.entity;

import java.util.Random;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class DispenseWeaponProjectile extends
		BehaviorProjectileDispense {
	protected Random rand;

	public DispenseWeaponProjectile() {
		this.rand = new Random();
	}

	public ItemStack dispenseStack(IBlockSource blocksource, ItemStack itemstack) {
		World world = blocksource.getWorld();
		IPosition pos = BlockDispenser.getIPositionFromBlockSource(blocksource);
		EnumFacing face = EnumFacing.getFront(blocksource.getBlockMetadata());
		IProjectile projectile = getProjectileEntity(world, pos);
		projectile.setThrowableHeading(face.getFrontOffsetX(), getYVel(),
				face.getFrontOffsetZ(), getVelocity(), getDeviation());
		world.spawnEntityInWorld((Entity) projectile);
		itemstack.splitStack(1);
		return itemstack;
	}

	public double getYVel() {
		return 0.1D;
	}

	public float getVelocity() {
		return func_82500_b();
	}

	public float getDeviation() {
		return func_82498_a();
	}

	protected void playDispenseSound(IBlockSource blocksource) {
		super.playDispenseSound(blocksource);
	}

	protected void spawnDispenseParticles(IBlockSource blocksource, EnumFacing facing) {
		super.spawnDispenseParticles(blocksource, facing);
	}

	public static int getXFromFacing(EnumFacing face) {
		if (face == EnumFacing.WEST) {
			return 1;
		}
		if (face == EnumFacing.EAST) {
			return -1;
		}
		return 0;
	}

	public static int getZFromFacing(EnumFacing face) {
		if (face == EnumFacing.NORTH) {
			return -1;
		}
		if (face == EnumFacing.SOUTH) {
			return 1;
		}
		return 0;
	}
}
