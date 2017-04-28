package hu.bm.mobsoft.lab.costlog.ui.itemlist;


import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;

public interface ItemListScreen {
    void showErrorMessage(String message);
    void showList();

    void listItems(List<Item> items);
}
