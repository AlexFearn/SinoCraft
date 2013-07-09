package sinocraft.potion;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class PotionIndigestion extends Potion
{
	protected PotionIndigestion(int Id, boolean isBad, int liquidColor)
	{
		super(Id, isBad, liquidColor);
		
		setPotionName("Indigestion");
	}
	
	@Override
	public void performEffect(EntityLiving entity, int exhaustion)
	{
        ((EntityPlayer)entity).addExhaustion(0.01F * (float)(exhaustion + 1));
	}
}
