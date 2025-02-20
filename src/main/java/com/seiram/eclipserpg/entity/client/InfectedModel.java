package com.seiram.eclipserpg.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.seiram.eclipserpg.EclipseRPG;
import com.seiram.eclipserpg.entity.custom.InfectedEntity;
import com.seiram.eclipserpg.entity.client.InfectedAnimations;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class InfectedModel<T extends Entity> extends HierarchicalModel<InfectedEntity> {
    // This layer location should be baked in your renderer and passed into the model's constructor.
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(EclipseRPG.MOD_ID, "infected"), "main");

    // Store the full root so the animation system can find all named parts.
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart bone;
    private final ModelPart headwear;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart bone2;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public InfectedModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.bone = this.head.getChild("bone");
        this.headwear = root.getChild("headwear");
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.bone2 = this.right_arm.getChild("bone2");
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone = head.addOrReplaceChild("bone",
                CubeListBuilder.create()
                        .texOffs(-4, 33).addBox(-4.0F, -9.0F, -1.0F, 3, 1, 4, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-3.0F, -9.0F, -5.0F, 3, 1, 4, new CubeDeformation(0.0F))
                        .texOffs(-2, 33).addBox(4.0F, -5.0F, 1.0F, 1, 4, 4, new CubeDeformation(0.0F))
                        .texOffs(-2, 36).addBox(0.0F, -4.0F, 4.0F, 4, 3, 1, new CubeDeformation(0.0F))
                        .texOffs(-2, 36).addBox(-4.0F, -9.0F, 3.0F, 4, 1, 1, new CubeDeformation(0.0F))
                        .texOffs(-2, 36).addBox(-5.0F, -8.0F, 4.0F, 4, 1, 1, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-2.0F, -10.0F, -2.0F, 3, 1, 4, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(1.0F, -9.0F, -2.0F, 3, 1, 4, new CubeDeformation(0.0F))
                        .texOffs(-1, 36).addBox(1.0F, -9.0F, -3.0F, 3, 1, 1, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-1.0F, -9.0F, -1.0F, 2, 1, 4, new CubeDeformation(0.0F))
                        .texOffs(-1, 36).addBox(-5.0F, -4.0F, -3.0F, 1, 1, 1, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-5.0F, -9.0F, 0.0F, 1, 1, 3, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-4.0F, -10.0F, -1.0F, 1, 1, 3, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(2.0F, -10.0F, -2.0F, 1, 1, 3, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(-1.0F, -11.0F, -1.0F, 1, 1, 2, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(4.0F, -8.0F, -2.0F, 1, 1, 3, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(0.0F, -9.0F, -3.0F, 1, 1, 3, new CubeDeformation(0.0F))
                        .texOffs(-4, 33).addBox(4.0F, -7.0F, -3.0F, 1, 1, 4, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition headwear = partdefinition.addOrReplaceChild("headwear",
                CubeListBuilder.create()
                        .texOffs(32, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .mirror()
                        .addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.0F))
                        .mirror(false),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create()
                        .texOffs(40, 16)
                        .addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition bone2 = right_arm.addOrReplaceChild("bone2",
                CubeListBuilder.create()
                        .texOffs(-4, 33)
                        .addBox(-12.0F, -15.0F, -2.0F, 3, 1, 4, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(11.0F, -5.0F, 0.0F, 0.0324F, -0.0131F, -1.6023F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
                CubeListBuilder.create()
                        .texOffs(0, 16)
                        .mirror()
                        .addBox(-1.9F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.0F))
                        .mirror(false),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(-2.1F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.0F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(InfectedEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Reset poses for all parts from the full root
        this.root().getAllParts().forEach(ModelPart::resetPose);
        applyHeadRotation(netHeadYaw, headPitch);

        // Apply walk animation (for example, on the arms) and then the idle animation.
        this.animateWalk(InfectedAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, InfectedAnimations.idle, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);
        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
