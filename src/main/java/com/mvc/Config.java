package com.mvc;

import com.seedfinding.mccore.version.MCVersion;

import java.io.File;

import static com.mvc.Config.FILTER_TYPE.*;

public class Config {
    public static final int SEED_MATCHES = 100_000;
    public static final int LOG_DELAY = 10_000;
    public static final MCVersion VERSION = MCVersion.v1_16_1;
    public static final FILTER_TYPE FILTER = FILE;
    public static final File INPUT_FILE = new File("./src/main/resources/ssvFastionEndCityShipSeeds.txt");
    public static final File OUTPUT_FILE = new File("./src/main/resources/output.txt");
    public static final int VILLAGE_DISTANCE = 16;
    public static final int TEMPLE_DISTANCE = 16;
    public static final int BASTION_DISTANCE = 12;
    public static final int FORTRESS_DISTANCE = 12;
    public static final int END_CITY_DISTANCE = 8;

    public enum FILTER_TYPE {
        FILE,
        INCREMENTAL,
        RANDOM
    }
}
