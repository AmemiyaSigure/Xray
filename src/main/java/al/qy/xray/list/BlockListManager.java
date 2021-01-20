package al.qy.xray.list;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Arrays;
import java.util.List;

public class BlockListManager {
    private List<Block> xrayList;

    public BlockListManager() {
        xrayList = Arrays.asList(
                Blocks.COAL_ORE,
                Blocks.DIAMOND_ORE,
                Blocks.EMERALD_ORE,
                Blocks.GOLD_ORE,
                Blocks.IRON_ORE,
                Blocks.LAPIS_ORE,
                Blocks.NETHER_GOLD_ORE,
                Blocks.NETHER_QUARTZ_ORE,
                Blocks.REDSTONE_ORE
        );
    }

    public boolean isInsideList(Block block) {
        return xrayList.contains(block);
    }
}
