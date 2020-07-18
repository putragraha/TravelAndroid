package com.neptuunia.travel.common;

import io.rollout.configuration.RoxContainer;
import io.rollout.flags.RoxFlag;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version Flags, v 0.0.1 18/07/20 12.28 by Putra Nugraha
 */
public class Flags implements RoxContainer {

    private final RoxFlag travelable = new RoxFlag(false);

    public RoxFlag getTravelable() {
        return travelable;
    }
}