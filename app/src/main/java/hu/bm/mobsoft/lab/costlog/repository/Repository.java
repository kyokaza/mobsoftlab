package hu.bm.mobsoft.lab.costlog.repository;

import android.content.Context;

import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;

public interface Repository {

    void open(Context context);

    void close();

    List<Item> getItems();

    void saveItems(Item todo);

    void updateFavourites(List<Item> todos);

    void removeFavourite(Item todo);

    boolean isInDB(Item todo);
}