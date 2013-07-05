package sinocraft.core.register;

import sinocraft.SinoCraft;


/**
 * 
 * 获取一些MOD的基本信息
 * @author HopeAsd
 *
 */
public class SCProperty {
	
	
	
	public static void loadProps(SCConfig config) {
		GeneralRegistry
				.loadConfigurableClass(SinoCraft.config, SCProperty.class);
	}

}
