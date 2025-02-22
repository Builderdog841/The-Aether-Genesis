package com.aetherteam.genesis;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class GenesisTags {
    public static class Blocks {
        public static final TagKey<Block> LOG_WALLS = tag("log_walls");
        public static final TagKey<Block> CARRION_SPROUT_SPAWNABLE_ON = tag("carrion_sprout_spawnable_on");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(AetherGenesis.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> LOG_WALLS = tag("log_walls");

        public static final TagKey<Item> SKYROOT_LADDER_CRAFTING = tag("skyroot_ladder_crafting");
        public static final TagKey<Item> HOLYSTONE_FURNACE_CRAFTING = tag("holystone_furnace_crafting");

        public static final TagKey<Item> ZEPHYROO_TEMPTATION_ITEMS = tag("zephyroo_temptation_items");

        public static final TagKey<Item> SWET_JELLY = tag("swet_jelly");
        public static final TagKey<Item> DARTS = tag("darts");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(AetherGenesis.MODID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> COMPANIONS = tag("companions");
        public static final TagKey<EntityType<?>> NO_PRESENT_DROPS = tag("no_present_drops");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AetherGenesis.MODID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_GREEN_AERCLOUDS = tag("has_green_aerclouds");
        public static final TagKey<Biome> HAS_PURPLE_AERCLOUDS = tag("has_purple_aerclouds");
        public static final TagKey<Biome> HAS_STORM_AERCLOUDS = tag("has_storm_aerclouds");
        public static final TagKey<Biome> HAS_CONTINUUM_ORE = tag("has_continuum_ore");
        public static final TagKey<Biome> HAS_ORANGE_TREES = tag("has_orange_trees");
        public static final TagKey<Biome> HAS_GROVE_TREES = tag("has_grove_trees");
        public static final TagKey<Biome> HAS_WOODLAND_TREES = tag("has_woodland_trees");
        public static final TagKey<Biome> HAS_FOREST_TREES = tag("has_forest_trees");
        public static final TagKey<Biome> HAS_CARRION_SPROUT = tag("has_carrion_sprout");
        public static final TagKey<Biome> HAS_ZEPHYROO = tag("has_zephyroo");
        public static final TagKey<Biome> HAS_DARK_SWET = tag("has_dark_swet");
        public static final TagKey<Biome> HAS_TEMPEST = tag("has_tempest");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(AetherGenesis.MODID, name));
        }
    }
}
