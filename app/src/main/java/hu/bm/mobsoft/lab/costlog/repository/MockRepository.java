package hu.bm.mobsoft.lab.costlog.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.model.User;

public class MockRepository implements Repository {
    private List<User> users;
    private List<Item> items;

    @Override
    public void open(Context context) {
        User user = new User(3L, "Alma", "Alma");
        users = new ArrayList<>();
        users.add(user);

        Item i1 = new Item(1L, "1L", new Date(), 120);
        Item i2 = new Item(2L, "2L", new Date(), -4520);

        items = new ArrayList<>();
        items.add(i1);
        items.add(i2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void saveItem(Item item) {
        this.items.add(item);
    }

    @Override
    public void updateItem(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            Item favourite = this.items.get(i);
            for (Item todo : items) {
                if (todo.getId().equals(favourite.getId())) {
                    this.items.set(i, todo);
                }
            }
        }
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public List<User> getUser(User user) {
        List<User> retUsers = new ArrayList<>();
        for (User i :
                users) {
            if (i.getUsername().equals(user.getUsername())) {
                retUsers.add(i);
            }
        }
        return retUsers;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }
}
