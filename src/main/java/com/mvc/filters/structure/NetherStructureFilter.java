package com.mvc.filters.structure;

import com.mvc.Config;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mcfeature.structure.BastionRemnant;
import com.seedfinding.mcfeature.structure.Fortress;

public class NetherStructureFilter {
    private final long structureSeed;
    private final ChunkRand chunkRand;

    public NetherStructureFilter(long structureSeed, ChunkRand chunkRand) {
        this.structureSeed = structureSeed;
        this.chunkRand = chunkRand;
    }

    public boolean filterStructures() {
        return hasBastion() && hasFortress();
    }

    private boolean hasBastion() {
        BastionRemnant bastion = new BastionRemnant(Config.VERSION);
        CPos bastionPP = bastion.getInRegion(structureSeed, 0, 0, chunkRand);
        CPos bastionPN = bastion.getInRegion(structureSeed, 0, -1, chunkRand);
        CPos bastionNN = bastion.getInRegion(structureSeed, -1, -1, chunkRand);
        CPos bastionNP = bastion.getInRegion(structureSeed, -1, 0, chunkRand);

        return (bastionPP != null && bastionPP.getMagnitudeSq() <= Config.BASTION_DISTANCE) ||
                (bastionPN != null && bastionPN.getMagnitudeSq() <= Config.BASTION_DISTANCE) ||
                (bastionNN != null && bastionNN.getMagnitudeSq() <= Config.BASTION_DISTANCE) ||
                (bastionNP != null && bastionNP.getMagnitudeSq() <= Config.BASTION_DISTANCE);
    }

    private boolean hasFortress() {
        Fortress fortress = new Fortress(Config.VERSION);
        CPos fortressPP = fortress.getInRegion(structureSeed, 0, 0, chunkRand);
        CPos fortressPN = fortress.getInRegion(structureSeed, 0, -1, chunkRand);
        CPos fortressNN = fortress.getInRegion(structureSeed, -1, -1, chunkRand);
        CPos fortressNP = fortress.getInRegion(structureSeed, -1, 0, chunkRand);

        return (fortressPP != null && fortressPP.getMagnitudeSq() <= Config.FORTRESS_DISTANCE) ||
                (fortressPN != null && fortressPN.getMagnitudeSq() <= Config.FORTRESS_DISTANCE) ||
                (fortressNN != null && fortressNN.getMagnitudeSq() <= Config.FORTRESS_DISTANCE) ||
                (fortressNP != null && fortressNP.getMagnitudeSq() <= Config.FORTRESS_DISTANCE);
    }
}
