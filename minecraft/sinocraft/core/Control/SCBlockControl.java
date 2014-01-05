package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.Annotation.SCConfigAnnotation;
import sinocraft.blocks.*;

import net.minecraftforge.common.ConfigCategory;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModClassLoader;

import java.lang.ClassLoader;
import java.lang.Package;
import java.util.Enumeration;
import java.net.URL;
import java.io.File;
import java.io.FilenameFilter;



public class SCBlockControl {
    public static ConfigCategory SCBlockConfig;
    public static List<String> SCBlockLoadClass;

    @SCConfigAnnotation(Mold = "load", CategoryName = "block")
    public static void laodConfig(ConfigCategory confige) {
        SCBlockConfig = confige;
    }
}