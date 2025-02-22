package com.aetherteam.genesis.client.renderer.entity.layers;

import com.aetherteam.genesis.AetherGenesis;
import com.aetherteam.genesis.entity.monster.dungeon.BattleSentry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class BattleSentryLayer extends EyesLayer<BattleSentry, SlimeModel<BattleSentry>> {
	private static final RenderType BATTLE_SENTRY_EYE = RenderType.eyes(new ResourceLocation(AetherGenesis.MODID, "textures/entity/mobs/battle_sentry/eye.png"));

	public BattleSentryLayer(RenderLayerParent<BattleSentry, SlimeModel<BattleSentry>> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, BattleSentry sentry, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		VertexConsumer consumer = buffer.getBuffer(this.renderType());
		if (sentry.isAwake() || !sentry.isStalking()) {
			this.getParentModel().renderToBuffer(poseStack, consumer, LightTexture.FULL_SKY, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public RenderType renderType() {
		return BATTLE_SENTRY_EYE;
	}
}