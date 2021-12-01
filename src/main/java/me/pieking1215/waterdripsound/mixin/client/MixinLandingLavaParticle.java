package me.pieking1215.waterdripsound.mixin.client;

import me.pieking1215.waterdripsound.WaterDripSound;
import me.pieking1215.waterdripsound.WaterDripSoundConfig;
import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockLeakParticle.LandingLavaFactory.class)
public class MixinLandingLavaParticle {

    @Inject(at = @At("HEAD"), method = "createParticle", cancellable = true)
    private void createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double vx, double vy, double vz, CallbackInfoReturnable<Particle> callback) {
        // if mod is enabled in the config
        if(WaterDripSoundConfig.GENERAL.enabled.get()){
            // only play sound if landed on block or non-lava fluid (water)
            if (clientWorld.getBlockState(new BlockPos(x, y - 1, z)).getFluidState().getFluid() != Fluids.LAVA) {
                // play the sound
                float vol = MathHelper.clamp(WaterDripSoundConfig.GENERAL.volume.floatValue() * 0.5f, 0f, 1f);
                if(WaterDripSoundConfig.GENERAL.useDripstoneSounds.get()) {
                    vol *= Math.random() * 0.7 + 0.3; // same as vanilla dripstone drips
                }
                clientWorld.playSound(x, y, z, WaterDripSoundConfig.GENERAL.useDripstoneSounds.get() ? SoundEvents.BLOCK_POINTED_DRIPSTONE_DRIP_LAVA : WaterDripSound.LAVA_DRIP_EVENT, WaterDripSoundConfig.GENERAL.soundCategory.get(), vol, 1f + (float)(Math.random() * 0.1f), false);
            }
        }
    }
}
