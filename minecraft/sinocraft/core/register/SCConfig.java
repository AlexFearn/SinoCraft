package sinocraft.core.register;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

/**
 * MOD鐨刢onfig绫\xBB 渚夸簬璋冩暣璁剧疆
 * 
 * @author HopeAsd
 * 
 */
public class SCConfig {
	private static Configuration config;

	public SCConfig(File configFile) {
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				System.out.print(e);
				return;
			}
		}
		config = new Configuration(configFile);
		config.load();
	}

	public void InitliazeConfig(File ConfigFile) {
		if (this != null) {
			return;
		}
		config = new Configuration(ConfigFile);
	}

	public String getGeneralProperties(String PropertyName, String DefaultValue)
			throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.get("general", PropertyName, DefaultValue).getString();
	}

	public Property getProperty(String category, String propertyName,
			String defaultValue) throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.get(category, propertyName, defaultValue);
	}

	public boolean getBoolean(String name, Boolean defaultValue)
			throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.get("general", name, defaultValue).getBoolean(
				defaultValue);
	}

	public int getInteger(String name, Integer defaultValue) throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.get("general", name, defaultValue).getInt();
	}

	public int getItemID(String ItemName, int DefaultValue) throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.getItem("item", "ID." + ItemName, DefaultValue).getInt();
	}

	public int getBlockID(String BlockName, int DefaultID) throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.getBlock("ID." + BlockName, DefaultID).getInt();
	}

	public int getKeyCode(String keyName, int defaultKey) throws Exception {
		if (this == null) {
			throw new NullPointerException();
		}
		return config.get("key", "KB." + keyName, defaultKey).getInt();
	}

	public void SaveConfig() {
		config.save();
	}
}
