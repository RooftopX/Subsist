package net.mcreator.subsist.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.1.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelhermesboots<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("subsist", "modelhermesboots"), "main");
	public final ModelPart LeftBoot;
	public final ModelPart RightBoot;

	public Modelhermesboots(ModelPart root) {
		this.LeftBoot = root.getChild("LeftBoot");
		this.RightBoot = root.getChild("RightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot",
				CubeListBuilder.create().texOffs(0, 57).addBox(-2.0F, 6.0F, -3.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 57)
						.addBox(-2.0F, 6.0F, 2.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 54)
						.addBox(2.0F, 6.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(37, 59)
						.addBox(3.0F, 8.0F, 1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(47, 59)
						.addBox(3.0F, 9.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(47, 53)
						.addBox(3.0F, 10.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(19, 35)
						.addBox(-3.0F, 6.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(26, 48)
						.addBox(-2.0F, 11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(35, 35).addBox(-3.0F, 6.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 33)
						.addBox(-4.0F, 8.0F, 1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(36, 53)
						.addBox(-4.0F, 9.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 39)
						.addBox(-4.0F, 10.0F, -1.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(43, 40)
						.addBox(2.0F, 6.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(13, 49)
						.addBox(-3.0F, 6.0F, 2.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-3.0F, 6.0F, -3.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-3.0F, 6.0F, -3.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 42)
						.addBox(-3.0F, 12.0F, -3.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		LeftBoot.render(poseStack, buffer, packedLight, packedOverlay);
		RightBoot.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
