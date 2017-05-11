package hu.bm.mobsoft.lab.costlog.interactor.item;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.interactor.item.events.GetItemsEvent;
import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.repository.Repository;

public class CostItemInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public CostItemInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public CostItemInteractor(Repository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public void getItems() {
        GetItemsEvent event = new GetItemsEvent();
        try {
            List<Item> items = repository.getItems();
            event.setItems(items);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void doCreateItemInteraction(Item item){
        GetItemsEvent event = new GetItemsEvent();
        try {
            Item itemSaved = repository.saveItem(item);
            event.saveItem(itemSaved);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }


}
