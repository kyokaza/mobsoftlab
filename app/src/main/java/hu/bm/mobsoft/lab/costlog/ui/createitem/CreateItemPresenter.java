package hu.bm.mobsoft.lab.costlog.ui.createitem;


import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.interactor.item.CostItemInteractor;
import hu.bm.mobsoft.lab.costlog.interactor.item.events.GetItemsEvent;
import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.ui.Presenter;

import static hu.bm.mobsoft.lab.costlog.MobSoftApplication.injector;

public class CreateItemPresenter extends Presenter<CreateItemScreen> {
    @Inject
    CostItemInteractor costItemInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    @Override
    public void attachScreen(CreateItemScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void doCreateItemInteraction(final Item item){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costItemInteractor.doCreateItemInteraction(item);
            }
        });
    }


    public void fetchItems() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costItemInteractor.getItems();
            }
        });
    }

    public void onEventMainThread(GetItemsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showErrorMessage("error in loadin items");
            }
            Log.e("Networking", "Error reading items", event.getThrowable());
        } else {
            if (screen != null) {
                screen.listItems(event.getItems());
            }
        }
    }
}
