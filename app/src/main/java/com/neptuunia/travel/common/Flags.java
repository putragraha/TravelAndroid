package com.neptuunia.travel.common;

import javax.inject.Inject;

import io.rollout.configuration.RoxContainer;
import io.rollout.flags.RoxFlag;

public class Flags implements RoxContainer {

    // TODO (Rengar): 19/07/20 Change default value to false later
    // TODO (Putra): 31/07/20 Use Dagger instead
    private final RoxFlag travelable = new RoxFlag(true);

    @Inject
    Flags() {
        // For dagger
    }

    public RoxFlag getTravelable() {
        return travelable;
    }
}