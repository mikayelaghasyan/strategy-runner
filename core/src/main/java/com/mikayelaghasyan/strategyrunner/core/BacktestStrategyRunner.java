package com.mikayelaghasyan.strategyrunner.core;

import java.util.Date;

public class BacktestStrategyRunner extends StrategyRunner {
    private Date startDate;
    private Date endDate;

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public void run(Strategy strategy) {
        StrategyContext context = new StrategyContext();
        strategy.init(context);
    }
}
