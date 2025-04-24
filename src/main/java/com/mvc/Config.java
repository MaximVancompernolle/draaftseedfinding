package com.mvc;

import com.seedfinding.mccore.version.MCVersion;

import java.io.File;

public class Config {
    public static final int SEED_MATCHES = 1;
    public static final int LOG_DELAY = 10_000;
    public static final MCVersion VERSION = MCVersion.v1_16_1;
    public static final boolean FILTER_FILE = true;
    public static final File INPUT_FILE = new File("./src/main/resources/ssvFastionEndCityShipSeeds.txt");
    public static final File OUTPUT_FILE = new File("./src/main/resources/output.txt");
    public static final boolean FILTER_INCREMENTAL = false;
}
