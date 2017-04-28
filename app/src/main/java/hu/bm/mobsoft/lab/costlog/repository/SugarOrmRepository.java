package hu.bm.mobsoft.lab.costlog.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;


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
    public void saveItems(Item item) {
        SugarRecord.saveInTx(item);
    }

    @Override
    public void updateFavourites(List<Item> items) {
        List<Item> itemsAll = getItems();
        List<Item> toUpdate = new ArrayList<>(itemsAll.size());
        for (Item itemIter : itemsAll) {
            for (Item item : items) {
                if (item.getId().equals(itemIter.getId())) {
                    toUpdate.add(item);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeFavourite(Item item) {
        SugarRecord.deleteInTx(item);
    }

    @Override
    public boolean isInDB(Item item) {
//        return SugarRecord.findById(Item.class, item.getId()) != null;
        //TODO need some sugar db addition.
        return true;
    }

}