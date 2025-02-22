package com.aetherteam.genesis.client.renderer.entity;

import com.aetherteam.genesis.AetherGenesis;
import com.aetherteam.genesis.client.renderer.GenesisModelLayers;
import com.aetherteam.genesis.client.renderer.entity.layers.FangrinEyesLayer;
import com.aetherteam.genesis.client.renderer.entity.model.FangrinModel;
import com.aetherteam.genesis.entity.companion.Fangrin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class FangrinRenderer extends CompanionRenderer<Fangrin, FangrinModel> {
    private static final ResourceLocation FANGRIN_TEXTURE = new ResourceLocation(AetherGenesis.MODID, "textures/entity/companions/fangrin/fangrin.png");

    public FangrinRenderer(EntityRendererProvider.Context context) {
        super(context, new FangrinModel(context.bakeLayer(GenesisModelLayers.FANGRIN)), 0.45F);
        this.addLayer(new FangrinEyesLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Fangrin fangrin) {
        return FANGRIN_TEXTURE;
    }
}
