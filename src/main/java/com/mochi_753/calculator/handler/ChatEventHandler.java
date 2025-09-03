package com.mochi_753.calculator.handler;

import com.mochi_753.calculator.CalculatorConfig;
import com.mochi_753.calculator.util.MathEvaluator;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientChatEvent;

public class ChatEventHandler {
    @SubscribeEvent
    public static void onChat(ClientChatEvent event) {
        if (Minecraft.getInstance().player == null) return;

        String msg = event.getMessage();
        if (msg.startsWith("@")) {
            String input = msg.length() > 1 ? msg.substring(1) : "";
            String result = MathEvaluator.evaluate(input);

            event.setCanceled(true);
            if (CalculatorConfig.RESULT_INLINE.get()) {
                Minecraft.getInstance().player.displayClientMessage(Component.literal("= " + result + " (" + input + ")"), false);
            } else {
                Minecraft.getInstance().player.displayClientMessage(Component.literal(input), false);
                Minecraft.getInstance().player.displayClientMessage(Component.literal("= " + result), false);
            }
        }
    }
}
