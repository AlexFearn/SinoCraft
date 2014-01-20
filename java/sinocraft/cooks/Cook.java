package sinocraft.cooks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Cook {
    protected String cookname;
    protected List<ItemStack> primary_material;
    protected List<ItemStack> assistant_material;
    protected static Map<String, Cook> cookmap = new HashMap<String, Cook>();
    protected int pagecolor = 0xffffff;

    public Cook(String name) {
        this.cookname = name;
        cookmap.put(name, this);
    }

    public static String[] getCooklist()
    {
        return cookmap.keySet().toArray(new String[] {});
    }

    public Cook setColor(int color) {
        this.pagecolor = color;
        return this;
    }

    public int getColor() {
        return this.pagecolor;
    }

    public Item getProduct() {
        return null;
    }

    public static Cook getCook(String name) {
        return cookmap.get(name);
    }

    public String getName() {
        return this.cookname;
    }

}