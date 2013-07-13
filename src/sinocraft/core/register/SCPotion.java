package sinocraft.core.register;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.potion.PotionIndigestion;

public class SCPotion
{
	public static int PotionIndigestionID;
	
	public static void load()
	{
		try
		{
			PotionIndigestionID = SinoCraft.config.getInteger("PotionIndigestionID", 25);
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading positionIDs from config . " + e);
		}
		
	}
}
