package me.pieking1215.waterdripsound;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WaterDripSound implements ClientModInitializer {

    public static final Identifier LAVA_DRIP_ID = new Identifier("waterdripsound:lavadrip");
    public static SoundEvent LAVA_DRIP_EVENT = new SoundEvent(LAVA_DRIP_ID);

    @Override
    public void onInitializeClient() {
        WaterDripSoundConfig.doneLoading();

        Registry.register(Registry.SOUND_EVENT, LAVA_DRIP_ID, LAVA_DRIP_EVENT);
    }
}
