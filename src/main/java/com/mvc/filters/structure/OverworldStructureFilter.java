package com.mvc.filters.structure;

import com.mvc.Config;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mcfeature.loot.LootContext;
import com.seedfinding.mcfeature.loot.LootTable;
import com.seedfinding.mcfeature.loot.MCLootTables;
import com.seedfinding.mcfeature.loot.item.Item;
import com.seedfinding.mcfeature.loot.item.ItemStack;
import com.seedfinding.mcfeature.structure.DesertPyramid;
import com.seedfinding.mcfeature.structure.Village;

import java.util.List;

public class OverworldStructureFilter {
    private final long structureSeed;
    private final ChunkRand chunkRand;
    private CPos templePos;

    public OverworldStructureFilter(long structureSeed, ChunkRand chunkRand) {
        this.structureSeed = structureSeed;
        this.chunkRand = chunkRand;
    }

    public boolean filterStructures() {
        return hasVillage() && hasTemple();
    }

    private boolean hasVillage() {
        Village village = new Village(Config.VERSION);
        CPos villagePos = village.getInRegion(structureSeed, 0, 0, chunkRand);

        return villagePos.getMagnitudeSq() <= Config.VILLAGE_DISTANCE;
    }

    private boolean hasTemple() {
        DesertPyramid temple = new DesertPyramid(Config.VERSION);
        templePos = temple.getInRegion(structureSeed, 0, 0, chunkRand);

        return templePos.getMagnitudeSq() <= Config.TEMPLE_DISTANCE;
    }

    private boolean hasTempleLoot() {
        chunkRand.setDecoratorSeed(structureSeed, templePos.getX() << 4, templePos.getZ() << 4, 40003, Config.VERSION);
        LootTable lootTable = MCLootTables.DESERT_PYRAMID_CHEST.get();
        lootTable.apply(Config.VERSION);

        for (int i = 0; i < 4; i++) {
            LootContext lootContext = new LootContext(chunkRand.nextLong(), Config.VERSION);
            List<ItemStack> chest = lootTable.generate(lootContext);

            for (ItemStack itemStack : chest) {
                Item item = itemStack.getItem();

                // check for loot here
            }
        }

        return false;
    }
}
