
package sinocraft.core.register;

import java.lang.reflect.Field;

import sinocraft.core.Configurable;

import net.minecraftforge.common.Property;

/**
 * 
 * 琚敞鍐岀被涓爣璁扮殑鍩熷繀椤讳负闈欐€佸煙銆\x82
 */
public class GeneralRegistry {

	private static SCConfig config;

	/**
	 * 鍔犺浇涓€涓惈鏈夊彲璁剧疆鍙傛暟鐨勭被銆\x82
	 * 
	 * @param conf
	 *            鍏敤璁剧疆
	 * @param cl
	 *            绫伙紝瑕佹敞鍐岀殑鍙傛暟蹇呴』涓篠tatic
	 */
	public static void loadConfigurableClass(SCConfig conf, Class<?> cl) {
		Property prop;
		for (Field f : cl.getFields()) {
			Configurable c = f.getAnnotation(Configurable.class);
			if (c != null) {
				try {
					prop = conf
							.getProperty(c.category(), c.key(), c.defValue());
					prop.comment = c.comment();
					Class<?> type = f.getType();
					if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
						f.setInt(null,
								prop.getInt(Integer.parseInt(c.defValue())));
					} else if (type.equals(Boolean.TYPE)
							|| type.equals(Boolean.class)) {
						f.setBoolean(null, prop.getBoolean(Boolean
								.parseBoolean(c.defValue())));
					} else if (type.equals(Double.TYPE)
							|| type.equals(Double.class)) {
						f.setDouble(null, prop.getDouble(Double.parseDouble(c
								.defValue())));
					} else if (type.equals(String.class)) {
						f.set(null, prop.getString());
					} else {
						throw new UnsupportedOperationException();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
