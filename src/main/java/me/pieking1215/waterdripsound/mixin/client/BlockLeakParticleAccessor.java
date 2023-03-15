package me.pieking1215.waterdripsound.mixin.client;

import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockLeakParticle.class)
public interface BlockLeakParticleAccessor {
    @Accessor
    Fluid getFluid();
}
