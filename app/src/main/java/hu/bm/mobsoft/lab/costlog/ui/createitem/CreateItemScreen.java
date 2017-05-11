package hu.bm.mobsoft.lab.costlog.ui.createitem;


import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;

public interface CreateItemScreen {
    void showItemCreationDialog();
    void showErrorMessage(String message);
    void listItems(List<Item> items);
}
