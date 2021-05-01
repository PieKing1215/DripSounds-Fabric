package me.pieking1215.waterdripsound;

import net.minecraft.fluid.WaterFluid;

import java.util.Random;

/**
 * See MixinSodiumClientWorld
 */
public class CustomRandom extends Random {

    public static final CustomRandom INSTANCE = new CustomRandom();

    private Random wrap;

    private CustomRandom(){}

    @Override
    public int nextInt(int bound) {
        // NOTE: the drip chance is not the only nextInt(10) call normally
        // the Random needs to be reset to the regular one inside FluidState#randomDisplayTick
        // (this is what MixinSodiumFluidState does)
        return wrap.nextInt(bound == 10 ? WaterDripSoundConfig.GENERAL.dripChance.get() : bound);
    }

    public Random update(Random original) {
        this.wrap = original;
        return this;
    }

    public Random getWrapped(){
        return wrap;
    }

}
