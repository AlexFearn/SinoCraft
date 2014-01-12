package sinocraft.items;

import sinocraft.core.Annotation.SCItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
// import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
// import cpw.mods.fml.relauncher.Side;
// import cpw.mods.fml.relauncher.SideOnly;


public class SCItemCookbook extends ItemBook {

	public static SCItemCookbook cookbook;

    public SCItemCookbook(int id) 
    {
        super(id);
    }

	@SCItem(DefaultID = 5000,Name = "Cookbook")
	public static Item setPeony(Item b)
	{
		cookbook = (SCItemCookbook)b.setTextureName("sinocraft:cookbook");
		return (Item)cookbook;
	}

}