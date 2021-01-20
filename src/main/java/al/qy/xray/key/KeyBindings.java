package al.qy.xray.key;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeyBindings {
    public static final KeyBinding XRAY_KEY = new KeyBinding(
            "description.key.xray",
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            "description.key.category.xray");

    public KeyBindings() {
        ClientRegistry.registerKeyBinding(XRAY_KEY);
    }
}
