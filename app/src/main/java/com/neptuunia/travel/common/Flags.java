package com.neptuunia.travel.common;

import io.rollout.configuration.RoxContainer;
import io.rollout.flags.RoxFlag;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version Flags, v 0.0.1 18/07/20 12.28 by Putra Nugraha
 */
public class Flags implements RoxContainer {

    // TODO (Putra): 19/07/20 Change default value to false later
    private final RoxFlag travelable = new RoxFlag(true);

    public RoxFlag getTravelable() {
        return travelable;
    }
}