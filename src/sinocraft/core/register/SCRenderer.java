package sinocraft.core.register;

import javax.sql.CommonDataSource;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.RenderingRegistry;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.renderers.RendererBush;
import sinocraft.renderers.RendererWolk;

/**
 * MOD中的渲染器注册类
 * @author Liong
 *
 */

public class SCRenderer
{
	public static int RendererBushID;
	public static int RendererWolkID;
	
	public static void load(SCConfig config)
	{
		try
		{
			RendererBushID = config.getInteger("rendererBush", 80);
			RendererWolkID = config.getInteger("rendererWolk", 81);
		}
		catch(Exception e)
		{
			SCLog.info("Error when loading renderIDs from config . " + e);
		}

		RenderingRegistry.registerBlockHandler(RendererBushID, new RendererBush());
		RenderingRegistry.registerBlockHandler(RendererWolkID, new RendererWolk());
		SCLog.info("Client Render load!");
	}
}
