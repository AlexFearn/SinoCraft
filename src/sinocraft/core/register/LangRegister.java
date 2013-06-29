package sinocraft.core.register;

import java.util.HashSet;
import java.util.Set;

import bilicraft.core.util.BCLog;
import cpw.mods.fml.common.registry.LanguageRegistry;

import sinocraft.core.SCLog;

public class LangRegister {
	public static Set<String> languages = new HashSet<String>();

	static {
		languages.add("zh_CN");
		languages.add("en_US");
	}
	
	public static void load()
	{
		try
		{
			for (String lang : languages) {
				LanguageRegistry.instance().loadLocalization(
						"/sinocraft/lang/" + lang + ".properties", lang, false);
				SCLog.info("Load Language:"+lang);
			}
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading languages from init . " + e);
		}
	}

}
