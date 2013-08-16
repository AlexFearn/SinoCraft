package sinocraft.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class PotionIndigestion extends Potion
{
	protected PotionIndigestion(int Id, boolean isBad, int liquidColor)
	{
		super(Id, isBad, liquidColor);
		
		setPotionName("potion.indigestion");
		
	}
	
	@Override
	public void performEffect(EntityLivingBase entity, int exhaustion)
	{
        ((EntityPlayer)entity).addExhaustion(0.01F * (float)(exhaustion + 1));
	}
}
