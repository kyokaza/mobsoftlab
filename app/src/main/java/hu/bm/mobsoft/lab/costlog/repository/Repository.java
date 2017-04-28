package hu.bm.mobsoft.lab.costlog.repository;

import android.content.Context;

import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.model.User;

public interface Repository {

    void open(Context context);

    void close();

    List<Item> getItems();

    void saveItem(Item item);

    void updateItem(Item item);

    void removeItem(Item item);

    List<User> getUser(User user);

    void saveUser(User user);
}