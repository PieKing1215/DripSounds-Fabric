package me.pieking1215.waterdripsound.mixin.client.sodium;

import me.pieking1215.waterdripsound.CustomRandom;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;

@Mixin(ClientWorld.class)
public class MixinSodiumClientWorld {

    // these commented out versions would be ideal if the Modify mixins could be nested

//    @ModifyConstant(method = "performFluidDisplayTick", remap = false, constant = @Constant(intValue = 10))
//    private int modifyDripChance(int original){
//        return WaterDripSoundConfig.GENERAL.dripChance.get();
//    }

//    @ModifyArg(method = "performFluidDisplayTick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt()I"), index = 0)
//    private int modifyDripChance(int original){
//        return WaterDripSoundConfig.GENERAL.dripChance.get();
//    }

    /**
     * Since all of the good mixin types don't work on other mixins, need to do it this way.
     */
    @ModifyVariable(method = "performFluidDisplayTick", at = @At("HEAD"))
    private Random modifyDripChance(Random original){
        return CustomRandom.INSTANCE.update(original);
    }

}
