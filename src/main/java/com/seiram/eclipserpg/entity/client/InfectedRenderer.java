package com.seiram.eclipserpg.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.seiram.eclipserpg.EclipseRPG;
import com.seiram.eclipserpg.entity.custom.InfectedEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class InfectedRenderer extends MobRenderer<InfectedEntity, InfectedModel<InfectedEntity>> {

    public InfectedRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedModel<>(context.bakeLayer(InfectedModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(InfectedEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(EclipseRPG.MOD_ID, "textures/entity/infected/infected_1.png" );
    }

    @Override
    public void render(InfectedEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }else{
            poseStack.scale(1f, 1f, 1f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }



}
