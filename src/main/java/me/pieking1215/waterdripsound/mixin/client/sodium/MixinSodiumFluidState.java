package me.pieking1215.waterdripsound.mixin.client.sodium;

import me.pieking1215.waterdripsound.CustomRandom;
import net.minecraft.fluid.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(WaterFluid.class)
public class MixinSodiumFluidState {

    @ModifyVariable(method = "randomDisplayTick", at = @At("HEAD"))
    private Random modifyDripChance(Random original){
        return CustomRandom.INSTANCE.getWrapped();
    }

}
