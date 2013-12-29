package sinocraft.core.register;

import sinocraft.SinoCraft;


/**
 * 
 * 鑾峰彇涓€浜汳OD鐨勫熀鏈俊鎭\xAF
 * @author HopeAsd
 *
 */
public class SCProperty {
	
	
	
	public static void loadProps(SCConfig config) {
		GeneralRegistry
				.loadConfigurableClass(SinoCraft.config, SCProperty.class);
	}

}
