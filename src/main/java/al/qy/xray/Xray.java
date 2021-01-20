package al.qy.xray;

import al.qy.xray.key.KeyBindings;
import al.qy.xray.list.BlockListManager;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixins;

@Mod(Xray.MODID)
public class Xray {
    public static final String MODID = "xray";

    private static Xray Instance;

    private Logger log = LogManager.getLogger("Xray");
    private boolean isEnabled = false;
    private double prevGamma = 0.0f;
    private BlockListManager listManager = new BlockListManager();

    public Xray() {
        Instance = this;

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
    }

    public static Xray getInstance() {
        return Instance;
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        new KeyBindings();
    }

    @SubscribeEvent
    public void onServerSetup(FMLDedicatedServerSetupEvent event) {
        log.fatal("Do NOT put me on server.");
        FMLJavaModLoadingContext.get().getModEventBus().shutdown();
    }

    public BlockListManager getListManager() {
        return listManager;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean value) {
        isEnabled = value;
    }

    public double getPrevGamma() {
        return prevGamma;
    }

    public void setPrevGamma(double value) {
        prevGamma = value;
    }
}
