package me.pieking1215.waterdripsound.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class DripSoundPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {

        if(mixinClassName.equals("me.pieking1215.waterdripsound.mixin.client.MixinClientWorld"))
            return !FabricLoader.getInstance().isModLoaded("sodium");

        if(mixinClassName.equals("me.pieking1215.waterdripsound.mixin.client.sodium.MixinSodiumClientWorld"))
            return FabricLoader.getInstance().isModLoaded("sodium");

        if(mixinClassName.equals("me.pieking1215.waterdripsound.mixin.client.sodium.MixinSodiumFluidState"))
            return FabricLoader.getInstance().isModLoaded("sodium");

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
