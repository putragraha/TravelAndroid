package com.neptuunia.travel.common;

import io.rollout.configuration.RoxContainer;
import io.rollout.flags.RoxFlag;

public class Flags implements RoxContainer {

    // TODO (Rengar): 19/07/20 Change default value to false later
    private final RoxFlag travelable = new RoxFlag(true);

    public RoxFlag getTravelable() {
        return travelable;
    }
}