package sinocraft.core.register;

import cpw.mods.fml.client.registry.RenderingRegistry;
import sinocraft.SinoCraft;
import sinocraft.renderers.RendererTeaBush;

/**
 * MOD中的渲染器注册类
 * @author Liong
 *
 */

public class SCRenderer
{
	public static int RendererTeaBushID = 80;
	
	public static void load(SCConfig config)
	{
		try
		{
			//RendererTeaBushID = config.getInteger("rendererTeaBush", 80);
		}
		catch(Exception e)
		{
			SinoCraft.log.warning("Error when loading renderIDs from config . " + e);
		}
		RenderingRegistry.registerBlockHandler(RendererTeaBushID, new RendererTeaBush());
	}
}
