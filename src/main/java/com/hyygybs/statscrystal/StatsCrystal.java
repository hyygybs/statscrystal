package com.hyygybs.statscrystal;

import com.hyygybs.statscrystal.network.NetworkHandler;
import com.hyygybs.statscrystal.utils.Registration;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(StatsCrystal.MODID)
public class StatsCrystal
{
    public static final String MODID = "statscrystal";

    public StatsCrystal(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        Registration.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
    }
    private void commonSetup(FMLCommonSetupEvent event) {
        NetworkHandler.register();
    }
}