package com.aetherteam.genesis.client.renderer.entity;

import com.aetherteam.genesis.AetherGenesis;
import com.aetherteam.genesis.client.renderer.GenesisModelLayers;
import com.aetherteam.genesis.client.renderer.entity.layers.HostMimicLayer;
import com.aetherteam.genesis.client.renderer.entity.model.SliderHostMimicModel;
import com.aetherteam.genesis.entity.monster.dungeon.boss.SliderHostMimic;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HostMimicRenderer extends MobRenderer<SliderHostMimic, SliderHostMimicModel> {
    private static final ResourceLocation HOST_MIMIC_ASLEEP_TEXTURE = new ResourceLocation(AetherGenesis.MODID, "textures/entity/mobs/slider_host_mimic/slider_host_mimic_asleep.png");
    private static final ResourceLocation HOST_MIMIC_AWAKE_TEXTURE = new ResourceLocation(AetherGenesis.MODID, "textures/entity/mobs/slider_host_mimic/slider_host_mimic_critical.png");

    public HostMimicRenderer(EntityRendererProvider.Context context) {
        super(context, new SliderHostMimicModel(context.bakeLayer(GenesisModelLayers.SLIDER_HOST_MIMIC)), 0.5F);
        this.addLayer(new HostMimicLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(SliderHostMimic hostMimic) {
        return hostMimic.isAwake() ? HOST_MIMIC_AWAKE_TEXTURE : HOST_MIMIC_ASLEEP_TEXTURE;
    }
}
