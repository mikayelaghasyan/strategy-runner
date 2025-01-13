package com.mikayelaghasyan.strategyrunner.core;

public abstract class StrategyRunner {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public abstract void run(Strategy strategy);
}
