package shaun.mods.miracles.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import shaun.mods.miracles.MiraclesMod;
import cpw.mods.fml.common.registry.GameRegistry;



@SuppressWarnings("unused")

public class Crafting {
    
    public static void loadRecipes() {
        
        //Shaped Recipes
        /*GameRegistry.addShapedRecipe(new ItemStack(example), new Object[]{
              "XYX"
              "YZY"
              "XYX"
              'X', Item.example, 'Y', Item.demonstration, 'Z', Item.illustration
          });*/
        
        //Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(MiraclesMod.magneticIron), new Object[]{
            new ItemStack(Item.ingotIron), new ItemStack(MiraclesMod.lodestones)
        });
        
        //Smelting Recipes
        //FurnaceRecipes.smelting().addSmelting(Item.example, Item.demonstration, 0.1F);
    }
    
}
