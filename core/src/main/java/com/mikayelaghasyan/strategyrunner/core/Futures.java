package com.mikayelaghasyan.strategyrunner.core;

import lombok.Getter;

import java.util.Collection;

@Getter
public class Futures implements AssetClass<Future> {
    private String id;
    private String name;

    @Override
    public Collection<Future> getAssets() {
        return null;
    }
}
