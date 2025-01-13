package com.mikayelaghasyan.strategyrunner.core;

import java.util.Collection;

public interface AssetClass<T extends Asset> {
    String getId();
    String getName();

    Collection<T> getAssets();
}
