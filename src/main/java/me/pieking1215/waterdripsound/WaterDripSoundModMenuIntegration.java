package me.pieking1215.waterdripsound;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class WaterDripSoundModMenuIntegration implements ModMenuApi {
    @Override
    public String getModId() {
        return "waterdripsound"; // Return your modid here
    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return WaterDripSoundConfig::registerClothConfig;
    }
}