package com.mikayelaghasyan.strategyrunner.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikayelaghasyan.strategyrunner.core.*;

import java.io.IOException;
import java.io.InputStream;

public class ExampleStrategy extends Strategy {
    public static void main(String[] args) {
        Strategy strategy = new ExampleStrategy();

        StrategyRunner runner = new BacktestStrategyRunner();
        runner.setDataSource(new );
        runner.run(strategy);
    }

    @Override
    public void init(StrategyContext context) {
        context.dataSource
        addAssetSubscription(Futures.Indices.Eminis.SP500Continuous)

    }
}
