package com.aetherteam.genesis.client.renderer.entity;

import com.aetherteam.genesis.AetherGenesis;
import com.aetherteam.genesis.client.renderer.GenesisModelLayers;
import com.aetherteam.genesis.client.renderer.entity.layers.FrostpineTotemEyesLayer;
import com.aetherteam.genesis.client.renderer.entity.model.FrostpineTotemModel;
import com.aetherteam.genesis.entity.companion.FrostpineTotem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FrostpineTotemRenderer extends CompanionRenderer<FrostpineTotem, FrostpineTotemModel> {
    private static final ResourceLocation FROSTPINE_TOTEM_TEXTURE = new ResourceLocation(AetherGenesis.MODID, "textures/entity/companions/frostpine_totem/frostpine_totem.png");

    public FrostpineTotemRenderer(EntityRendererProvider.Context context) {
        super(context, new FrostpineTotemModel(context.bakeLayer(GenesisModelLayers.FROSTPINE_TOTEM)), 0.45F);
        this.addLayer(new FrostpineTotemEyesLayer(this));
    }

    @Override
    protected void scale(FrostpineTotem frostpineTotem, PoseStack poseStack, float partialTickTime) {
        poseStack.translate(0.0, -0.45, 0.0);
        float sin = Mth.sin((frostpineTotem.tickCount + partialTickTime) / 6);
        poseStack.translate(0.0, sin / 15, 0.0);
    }

    @Override
    protected float getBob(FrostpineTotem frostpineTotem, float partialTick) {
        return partialTick;
    }

    @Override
    public ResourceLocation getTextureLocation(FrostpineTotem frostpineTotem) {
        return FROSTPINE_TOTEM_TEXTURE;
    }
}
