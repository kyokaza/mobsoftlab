package hu.bm.mobsoft.lab.costlog.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.model.User;


public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Item> getItems() {
        return SugarRecord.listAll(Item.class);
    }

    @Override
    public void saveItem(Item item) {
        SugarRecord.save(item);
    }

    @Override
    public void updateItem(Item item) {
//        List<Item> itemsAll = getItems();
//        List<Item> toUpdate = new ArrayList<>(itemsAll.size());
//        for (Item itemIter : itemsAll) {
//            for (Item i : item) {
//                if (item.getId().equals(itemIter.getId())) {
//                    toUpdate.add(item);
//                }
//            }
//        }
//        SugarRecord.saveInTx(toUpdate);
        SugarRecord.save(item);
    }

    @Override
    public void removeItem(Item item) {
        SugarRecord.delete(item);
    }


    @Override
    public List<User>getUser(User user) {
        return SugarRecord.find(User.class, "username", user.getUsername());
    }

    @Override
    public void saveUser(User user) {
        SugarRecord.save(user);
    }
}