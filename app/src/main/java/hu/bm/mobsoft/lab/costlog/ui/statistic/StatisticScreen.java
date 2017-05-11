package hu.bm.mobsoft.lab.costlog.ui.statistic;


import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;

public interface StatisticScreen {
    void showStatistic(List<Item> items);
    void showErrorMessage(String message);
}
