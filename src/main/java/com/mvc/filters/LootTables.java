package com.mvc.filters;

import com.seedfinding.mcfeature.loot.LootPool;
import com.seedfinding.mcfeature.loot.LootTable;
import com.seedfinding.mcfeature.loot.entry.EmptyEntry;
import com.seedfinding.mcfeature.loot.entry.ItemEntry;
import com.seedfinding.mcfeature.loot.function.EnchantRandomlyFunction;
import com.seedfinding.mcfeature.loot.function.SetCountFunction;
import com.seedfinding.mcfeature.loot.item.Items;
import com.seedfinding.mcfeature.loot.roll.ConstantRoll;
import com.seedfinding.mcfeature.loot.roll.UniformRoll;

public class LootTables {
    public static final LootTable DESERT_PYRAMID_CHEST = new LootTable(
            new LootPool(new UniformRoll(3.0F, 4.0F),
                    new ItemEntry(Items.DIAMOND, 5).apply(version -> SetCountFunction.uniform(1.0F, 3.0F)),
                    new ItemEntry(Items.IRON_INGOT, 15).apply(version -> SetCountFunction.uniform(3.0F, 5.0F)),
                    new ItemEntry(Items.GOLD_INGOT, 15).apply(version -> SetCountFunction.uniform(2.0F, 7.0F)),
                    new ItemEntry(Items.EMERALD, 15).apply(version -> SetCountFunction.uniform(1.0F, 3.0F)),
                    new ItemEntry(Items.BONE, 25).apply(version -> SetCountFunction.uniform(4.0F, 6.0F)),
                    new ItemEntry(Items.SPIDER_EYE, 25).apply(version -> SetCountFunction.uniform(1.0F, 3.0F)),
                    new ItemEntry(Items.ROTTEN_FLESH, 25).apply(version -> SetCountFunction.uniform(3.0F, 7.0F)),
                    new ItemEntry(Items.SADDLE, 20),
                    new ItemEntry(Items.ENCHANTED_BOOK, 20).apply(version -> new EnchantRandomlyFunction(Items.ENCHANTED_BOOK).apply(version)),
                    new ItemEntry(Items.GOLDEN_APPLE, 20),
                    new ItemEntry(Items.ENCHANTED_GOLDEN_APPLE, 6),
                    new EmptyEntry(5)),
            new LootPool(new ConstantRoll(4),
                    new ItemEntry(Items.BONE, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.GUNPOWDER, 10).apply(version -> SetCountFunction.uniform(4.0F, 8.0F)),
                    new ItemEntry(Items.ROTTEN_FLESH, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.STRING, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.SAND, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)))
    );
}
