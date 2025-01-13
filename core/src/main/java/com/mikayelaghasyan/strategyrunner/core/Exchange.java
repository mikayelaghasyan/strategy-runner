package com.mikayelaghasyan.strategyrunner.core;

import lombok.Getter;

import java.util.Collection;

@Getter
public class Exchange {
    private String id;
    private String name;
    private String country;
    private Collection<String> assetClasses;
}
