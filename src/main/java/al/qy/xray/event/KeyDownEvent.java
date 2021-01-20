package al.qy.xray.event;

import al.qy.xray.Xray;
import al.qy.xray.key.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Xray.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyDownEvent {
    @SubscribeEvent
    public static void onKeyDown(InputEvent.KeyInputEvent event) {
        if (KeyBindings.XRAY_KEY.isKeyDown()) {
            Xray.getInstance().setEnabled(!Xray.getInstance().isEnabled());

            if (Xray.getInstance().isEnabled()) {
                Xray.getInstance().setPrevGamma(Minecraft.getInstance().gameSettings.gamma);
                Minecraft.getInstance().gameSettings.gamma = 233;
            } else {
                Minecraft.getInstance().gameSettings.gamma = Xray.getInstance().getPrevGamma();
            }

            Minecraft.getInstance().worldRenderer.loadRenderers();
        }
    }
}
