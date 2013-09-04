package shaun.mods.miracles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shaun.mods.miracles.lib.Crafting;
import shaun.mods.miracles.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = MiraclesMod.modid, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MiraclesMod {
    
    //Mod ID
    public static final String modid = "ICP_Mod";
    
    //Ores
    public static Block oreMagnetite;
    
    //Machines
    
    //Items
    public static Item lodestones;
    public static Item magneticIron;
    
    //Initialization
    @EventHandler
    public void load(FMLInitializationEvent event) {
        
        //Block Registry
        oreMagnetite = new BlockOreMagnetite(3200, Material.rock).setUnlocalizedName("oreMagnetite");
        
        GameRegistry.registerBlock(oreMagnetite, modid + oreMagnetite.getUnlocalizedName().substring(5));
        
        LanguageRegistry.addName(oreMagnetite, "Magnetite Ore");
        
        //Item Registry
        lodestones = new ItemLodestones(4200).setUnlocalizedName("lodestones");
        magneticIron = new ItemMagneticIron(4201).setUnlocalizedName("magneticIron");
        
        LanguageRegistry.addName(lodestones, "Lodestones");
        LanguageRegistry.addName(magneticIron, "Magnetic Iron");
        
        //Crafting
        Crafting.loadRecipes();
        
    }

    public void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory matrix)
    {
        
        for(int i=0; i<matrix.getSizeInventory(); i++) {
            
            if(matrix.getStackInSlot(i) != null) {
                
                ItemStack itemnew = matrix.getStackInSlot(i);
                
                if(itemnew != null && itemnew.getItem() == lodestones) {
                    
                    ItemStack k = new ItemStack(lodestones, 2);
                    
                    k.damageItem(itemnew.getItemDamage() + 1, player);
                    
                    matrix.setInventorySlotContents(i, k);
                    
                }
                
            }
            
        }
        
    }
    
}
