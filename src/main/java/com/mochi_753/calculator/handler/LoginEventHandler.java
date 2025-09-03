package com.mochi_753.calculator.handler;

import com.mochi_753.calculator.CalculatorConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

public class LoginEventHandler {
    @SubscribeEvent
    public static void onLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        if (CalculatorConfig.SUPPRESS_WARNINGS.get()) return;
        Minecraft.getInstance().player.displayClientMessage(
                Component.translatable("message.calculator.login"),
                false
        );
    }
}
