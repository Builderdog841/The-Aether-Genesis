package com.aetherteam.genesis.blockentity;

import com.aetherteam.genesis.AetherGenesis;
import com.aetherteam.genesis.inventory.menu.HolystoneFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HolystoneFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public HolystoneFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(GenesisBlockEntityTypes.HOLYSTONE_FURNACE.get(), pos, state, RecipeType.SMELTING);
    }

    protected Component getDefaultName() {
        return Component.translatable("menu." + AetherGenesis.MODID + ".holystone_furnace");
    }

    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new HolystoneFurnaceMenu(id, playerInventory, this, this.dataAccess);
    }
}
