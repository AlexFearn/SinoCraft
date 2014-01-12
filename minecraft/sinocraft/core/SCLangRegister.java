package sinocraft.core;

import java.util.HashSet;
import java.util.Set;

import cpw.mods.fml.common.registry.LanguageRegistry;

import sinocraft.core.SCLog;
import java.net.URL;

public class SCLangRegister {
    public static Set<String> languages = new HashSet<String>();
    // public static URL langURL ;

    static {
        languages.add("zh_CN");
        // languages.add("en_US");
    }

    public static void load() {
        try {
            SCLog.log("try loading languages!");
            // langURL = new URL("/assets/sinocraft/lang");
            // SCLog.log("..."+ langURL);
            for (String lang : languages) {
                LanguageRegistry.instance().loadLocalization(
                    "/assets/sinocraft/lang/" + lang + ".lang", lang, false);
                SCLog.log("Load Language:" + lang);
            }
        } catch (Exception e) {
            SCLog.log("Error when loading languages from init . " + e);
        }
    }

}
