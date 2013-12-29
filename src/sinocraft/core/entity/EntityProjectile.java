package sinocraft.core.entity;

import java.util.List;

import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityProjectile extends Entity implements IProjectile,
		IThrowableEntity {

	public static final int NO_PICKUP = 0;
	public static final int PICKUP_ALL = 1;
	public static final int PICKUP_CREATIVE = 2;
	public static final int PICKUP_OWNER = 3;
	protected int xTile;
	protected int yTile;
	protected int zTile;
	protected int inTile;
	protected int inData;
	protected boolean inGround;
	public int arrowShake;
	public int pickupMode;
	public Entity shootingEntity;
	protected int ticksInGround;
	protected int ticksInAir;
	public boolean beenInGround;
	protected int extraDamage;
	protected int knockBack;

	public EntityProjectile(World par1World) {
		super(par1World);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍\xB9
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.inTile = 0;
		this.inData = 0;
		this.inGround = false;
		this.arrowShake = 0;
		this.ticksInAir = 0;
		this.yOffset = 0.0F;
		this.pickupMode = 0;

		this.extraDamage = 0;
		this.knockBack = 0;
		this.setSize(0.5F, 0.5F);
	}

	@Override
	public Entity getThrower() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍\xB9
		return this.shootingEntity;
	}

	@Override
	public void setThrower(Entity entity) {
		this.shootingEntity = entity;
	}

	protected void setPickupModeFromEntity(EntityLivingBase var1) {
		if (var1 instanceof EntityPlayer) {
			if (((EntityPlayer) var1).capabilities.isCreativeMode) {
				this.setPickupMode(2);
			} else {
				this.setPickupMode(1);
			}
		} else {
			this.setPickupMode(0);
		}
	}

	@Override
	public void setThrowableHeading(double x, double y, double z, float speed,
			float deviation) {
		float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
		x /= f2;
		y /= f2;
		z /= f2;
		x += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
		y += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
		z += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
		x *= speed;
		y *= speed;
		z *= speed;
		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;
		float f3 = MathHelper.sqrt_double(x * x + z * z);
		this.prevRotationYaw = (this.rotationYaw = (float) (Math.atan2(x, z) * 180.0D / 3.141592653589793D));
		this.prevRotationPitch = (this.rotationPitch = (float) (Math.atan2(y,
				f3) * 180.0D / 3.141592653589793D));
		this.ticksInGround = 0;

	}

	@Override
	protected void entityInit() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍\xB9
		if (canBeCritical()) {
			this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
		}
	}

	public void onEntityHit(Entity entity) {
		this.bounceBack();
	}

	protected void bounceBack() {
		this.motionX *= -0.1D;
		this.motionY *= -0.1D;
		this.motionZ *= -0.1D;
		this.rotationYaw += 180.0F;
		this.prevRotationYaw += 180.0F;
		this.ticksInAir = 0;
	}

	public void onGroundHit(MovingObjectPosition mop) {
		this.xTile = mop.blockX;
		this.yTile = mop.blockY;
		this.zTile = mop.blockZ;
		this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile,
				this.zTile);
		this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile,
				this.zTile);
		this.motionX = (mop.hitVec.xCoord - this.posX);
		this.motionY = (mop.hitVec.yCoord - this.posY);
		this.motionZ = (mop.hitVec.zCoord - this.posZ);
		float f1 = MathHelper.sqrt_double(this.motionX * this.motionX
				+ this.motionY * this.motionY + this.motionZ * this.motionZ);
		this.posX -= this.motionX / f1 * 0.05D;
		this.posY -= this.motionY / f1 * 0.05D;
		this.posZ -= this.motionZ / f1 * 0.05D;
		this.inGround = true;
		this.beenInGround = true;
		setCritical(false);
		this.arrowShake = getMaxArrowShake();
		playHitSound();

		if (this.inTile != 0) {
			Block.blocksList[this.inTile].onEntityCollidedWithBlock(
					this.worldObj, this.xTile, this.yTile, this.zTile, this);
		}
	}

	public final double getTotalVelocity() {
		return Math.sqrt(this.motionX * this.motionX + this.motionY
				* this.motionY + this.motionZ * this.motionZ);
	}

	public int getMaxLifetime() {
		return 1200;
	}

	public ItemStack getPickupItem() {
		return null;
	}

	public float getAirResistance() {
		return 0.99F;
	}

	public float getGravity() {
		return 0.05F;
	}

	public int getMaxArrowShake() {
		return 7;
	}

	public void playHitSound() {
	}

	public void setCritical(boolean flag) {
		if (!canBeCritical())
			return;
		if (flag) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) 1));
		} else
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) 0));
	}

	public boolean isCritical() {
		return (canBeCritical())
				&& (this.dataWatcher.getWatchableObjectByte(16) != 0);
	}

	public void setExtraDamage(int i) {
		this.extraDamage = i;
	}

	public void setKnockback(int i) {
		this.knockBack = i;
	}

	public void setPickupMode(int i) {
		this.pickupMode = i;
	}

	public int getPickupMode() {
		return this.pickupMode;
	}

	public boolean canPickup(EntityPlayer entityplayer) {
		if (this.pickupMode == 1) {
			return true;
		}
		if (this.pickupMode == 2) {
			return entityplayer.capabilities.isCreativeMode;
		}
		if (this.pickupMode == 3) {
			return entityplayer == this.shootingEntity;
		}

		return false;
	}

	public void setVelocity(double d, double d1, double d2) {
		this.motionX = d;
		this.motionY = d1;
		this.motionZ = d2;
		if (this.aimRotation() && this.prevRotationPitch == 0.0F
				&& this.prevRotationYaw == 0.0F) {
			float var7 = MathHelper.sqrt_double(d * d + d2 * d2);
			this.prevRotationYaw = this.rotationYaw = (float) (Math
					.atan2(d, d2) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(
					d1, (double) var7) * 180.0D / Math.PI);
			this.setLocationAndAngles(this.posX, this.posY, this.posZ,
					this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}

	private boolean aimRotation() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍\xB9
		return true;
	}

	public void onUpdate() {
		super.onUpdate();
		if (aimRotation()) {
			float f = MathHelper.sqrt_double(this.motionX * this.motionX
					+ this.motionZ * this.motionZ);
			this.prevRotationYaw = (this.rotationYaw = (float) (Math.atan2(
					this.motionX, this.motionZ) * 180.0D / 3.141592653589793D));
			this.prevRotationPitch = (this.rotationPitch = (float) (Math.atan2(
					this.motionY, f) * 180.0D / 3.141592653589793D));
		}

		int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
		if (i > 0) {
			Block.blocksList[i].setBlockBoundsBasedOnState(this.worldObj,
					this.xTile, this.yTile, this.zTile);
			AxisAlignedBB axisalignedbb = Block.blocksList[i]
					.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile,
							this.yTile, this.zTile);
			if ((axisalignedbb != null)
					&& (axisalignedbb.isVecInside(Vec3.createVectorHelper(
							this.posX, this.posY, this.posZ)))) {
				this.inGround = true;
			}
		}

		if (this.arrowShake > 0) {
			this.arrowShake -= 1;
		}

		if (this.inGround) {
			int j = this.worldObj
					.getBlockId(this.xTile, this.yTile, this.zTile);
			int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile,
					this.zTile);
			if ((j == this.inTile) && (k == this.inData)) {
				this.ticksInGround += 1;
				int t = getMaxLifetime();
				if ((t != 0) && (this.ticksInGround >= t)) {
					setDead();
				}
			} else {
				this.inGround = false;
				this.motionX *= this.rand.nextFloat() * 0.2F;
				this.motionY *= this.rand.nextFloat() * 0.2F;
				this.motionZ *= this.rand.nextFloat() * 0.2F;
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
			return;
		}

		this.ticksInAir += 1;

		Vec3 vec3d = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		Vec3 vec3d1 = Vec3.createVectorHelper(this.posX + this.motionX,
				this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition movingobjectposition = this.worldObj
				.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
		vec3d = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
		vec3d1 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY
				+ this.motionY, this.posZ + this.motionZ);
		if (movingobjectposition != null) {
			vec3d1 = Vec3.createVectorHelper(
					movingobjectposition.hitVec.xCoord,
					movingobjectposition.hitVec.yCoord,
					movingobjectposition.hitVec.zCoord);
		}

		Entity entity = null;
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
				this,
				this.boundingBox.addCoord(this.motionX, this.motionY,
						this.motionZ).expand(1.0D, 1.0D, 1.0D));
		double d = 0.0D;
		for (int l = 0; l < list.size(); l++) {
			Entity entity1 = (Entity) list.get(l);
			if ((!entity1.canBeCollidedWith())
					|| ((entity1 == this.shootingEntity) && (this.ticksInAir < 5))) {
				continue;
			}
			float f4 = 0.3F;
			AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f4, f4,
					f4);
			MovingObjectPosition movingobjectposition1 = axisalignedbb1
					.calculateIntercept(vec3d, vec3d1);
			if (movingobjectposition1 == null) {
				continue;
			}
			double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);
			if ((d1 >= d) && (d != 0.0D))
				continue;
			entity = entity1;
			d = d1;
		}

		if (entity != null) {
			movingobjectposition = new MovingObjectPosition(entity);
		}

		if (movingobjectposition != null) {
			if (movingobjectposition.entityHit != null) {
				onEntityHit(movingobjectposition.entityHit);
			} else {
				onGroundHit(movingobjectposition);
			}
		}

		if (isCritical()) {
			for (int i1 = 0; i1 < 2; i1++) {
				this.worldObj.spawnParticle("crit", this.posX + this.motionX
						* i1 / 4.0D, this.posY + this.motionY * i1 / 4.0D,
						this.posZ + this.motionZ * i1 / 4.0D, -this.motionX,
						-this.motionY + 0.2D, -this.motionZ);
			}
		}

		this.posX += this.motionX;
		this.posY += this.motionY;
		this.posZ += this.motionZ;

		if (aimRotation()) {
			float f2 = MathHelper.sqrt_double(this.motionX * this.motionX
					+ this.motionZ * this.motionZ);
			this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D);
			for (this.rotationPitch = (float) (Math.atan2(this.motionY, f2) * 180.0D / 3.141592653589793D); this.rotationPitch
					- this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
				;
			while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
				this.prevRotationPitch += 360.0F;

			while (this.rotationYaw - this.prevRotationYaw < -180.0F)
				this.prevRotationYaw -= 360.0F;

			while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
				this.prevRotationYaw += 360.0F;

			this.rotationPitch = (this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F);
			this.rotationYaw = (this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F);
		}

		float res = getAirResistance();
		float grav = getGravity();
		if (isInWater()) {
			this.beenInGround = true;
			for (int i1 = 0; i1 < 4; i1++) {
				float f6 = 0.25F;
				this.worldObj.spawnParticle("bubble", this.posX - this.motionX
						* f6, this.posY - this.motionY * f6, this.posZ
						- this.motionZ * f6, this.motionX, this.motionY,
						this.motionZ);
			}

			res *= 0.8080808F;
		}
		this.motionX *= res;
		this.motionY *= res;
		this.motionZ *= res;
		this.motionY -= grav;
		setPosition(this.posX, this.posY, this.posZ);
		doBlockCollisions();
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		this.xTile = var1.getShort("xTile");
        this.yTile = var1.getShort("yTile");
        this.zTile = var1.getShort("zTile");
        this.inTile = var1.getByte("inTile") & 255;
        this.inData = var1.getByte("inData") & 255;
        this.arrowShake = var1.getByte("shake") & 255;
        this.inGround = var1.getBoolean("inGround");
        this.beenInGround = var1.getBoolean("beenInGrond");
        this.pickupMode = var1.getByte("pickup");

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		var1.setShort("xTile", (short) this.xTile);
		var1.setShort("yTile", (short) this.yTile);
		var1.setShort("zTile", (short) this.zTile);
		var1.setByte("inTile", (byte) this.inTile);
		var1.setByte("inData", (byte) this.inData);
		var1.setByte("shake", (byte) this.arrowShake);
		var1.setBoolean("inGround", this.inGround);
		var1.setBoolean("beenInGround", this.beenInGround);
		var1.setByte("pickup", (byte) this.pickupMode);

	}

	public void onCollideWithPlayer(EntityPlayer entityplayer) {
		if ((this.inGround) && (this.arrowShake <= 0)) {
			if (canPickup(entityplayer)) {
				if (!this.worldObj.isRemote) {
					ItemStack item = getPickupItem();
					if (item == null)
						return;

					if (((this.pickupMode == 2) && (entityplayer.capabilities.isCreativeMode))
							|| (entityplayer.inventory
									.addItemStackToInventory(item))) {
						this.worldObj
								.playSoundAtEntity(
										this,
										"random.pop",
										0.2F,
										((this.rand.nextFloat() - this.rand
												.nextFloat()) * 0.7F + 1.0F) * 2.0F);
						onItemPickup(entityplayer);
					}
					setDead();
				}
			}
		}
	}

	protected void onItemPickup(EntityPlayer entityplayer) {
		if ((!this.isDead) && (!this.worldObj.isRemote)) {
			EntityTracker tracker = ((WorldServer) this.worldObj)
					.getEntityTracker();
			tracker.sendPacketToAllPlayersTrackingEntity(this,
					new Packet22Collect(this.entityId, entityplayer.entityId));
		}
	}

	public boolean canBeCritical() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0F;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

}
