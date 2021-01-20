package al.qy.xray.mixin;

import al.qy.xray.Xray;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(at = @At("HEAD"), method = "shouldSideBeRendered", cancellable = true)
    private static void afterShouldSideBeRendered(BlockState state, IBlockReader world,
                                                  BlockPos pos, Direction direction,
                                                  CallbackInfoReturnable<Boolean> cir) {
        if (Xray.getInstance().isEnabled()) {
            if (Xray.getInstance().getListManager().isInsideList(state.getBlock())) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
