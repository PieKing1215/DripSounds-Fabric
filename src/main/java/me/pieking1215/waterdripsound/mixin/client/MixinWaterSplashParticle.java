package me.pieking1215.waterdripsound.mixin.client;

import me.pieking1215.waterdripsound.WaterDripSoundConfig;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.WaterSplashParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WaterSplashParticle.SplashFactory.class)
public class MixinWaterSplashParticle {

    @Inject(at = @At("HEAD"), method = "createParticle", cancellable = true)
    private void createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double vx, double vy, double vz, CallbackInfoReturnable<Particle> callback) {
        // if mod is enabled in the config
        if(WaterDripSoundConfig.GENERAL.enabled.get()){
            // the splash when moving in water has speed, while drips and fishing splashes don't
            if(vx == 0 && vy == 0 && vz == 0) {
                // check that the block below isn't fluid since fishing splashes have water below
                if (clientWorld.getBlockState(new BlockPos(x, y - 1, z)).getFluidState().isEmpty()) {
                    // play the sound
                    float vol = MathHelper.clamp(WaterDripSoundConfig.GENERAL.volume.floatValue(), 0f, 1f);
                    /*if(WaterDripSoundConfig.GENERAL.useDripstoneSounds.get()) {
                        vol *= Math.random() * 0.7 + 0.3; // same as vanilla dripstone drips
                    }*/
                    clientWorld.playSound(x, y, z, /*WaterDripSoundConfig.GENERAL.useDripstoneSounds.get() ? SoundEvents.BLOCK_POINTED_DRIPSTONE_DRIP_WATER : */SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, WaterDripSoundConfig.GENERAL.soundCategory.get(), vol, 1f, false);
                }
            }
        }
    }
}
