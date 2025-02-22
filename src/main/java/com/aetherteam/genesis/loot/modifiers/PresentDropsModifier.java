package com.aetherteam.genesis.loot.modifiers;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.EquipmentUtil;
import com.aetherteam.genesis.GenesisTags;
import com.aetherteam.genesis.item.GenesisItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class PresentDropsModifier extends LootModifier {
    public static final Codec<PresentDropsModifier> CODEC = RecordCodecBuilder.create((instance) -> LootModifier.codecStart(instance).apply(instance, PresentDropsModifier::new));

    public PresentDropsModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    /**
     * Has a 1/5 chance to drop a present if a mob is attacked with full strength with an item while wearing a Lucky Bell if the mob isn't tagged with {@link GenesisTags.Entities#NO_PRESENT_DROPS}.
     *
     * @param lootStacks Result items from a loot table as an {@link ObjectArrayList} of {@link ItemStack}s.
     * @param context    The {@link LootContext}.
     * @return A new {@link ObjectArrayList} of {@link ItemStack}s that a loot table will give.
     */
    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> lootStacks, LootContext context) {
        Entity entity = context.getParamOrNull(LootContextParams.DIRECT_KILLER_ENTITY);
        Entity target = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        ObjectArrayList<ItemStack> newStacks = new ObjectArrayList<>(lootStacks);
        if (entity instanceof LivingEntity livingEntity && target instanceof LivingEntity livingTarget) {
            if (EquipmentUtil.isFullStrength(livingEntity) && EquipmentUtil.hasCurio(livingEntity, GenesisItems.LUCKY_BELL.get()) && livingTarget instanceof Enemy && !livingTarget.getType().is(GenesisTags.Entities.NO_PRESENT_DROPS) && livingTarget.getRandom().nextInt(5) == 0) {
                newStacks.add(new ItemStack(AetherBlocks.PRESENT.get()));
            }
        }
        return newStacks;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return PresentDropsModifier.CODEC;
    }
}