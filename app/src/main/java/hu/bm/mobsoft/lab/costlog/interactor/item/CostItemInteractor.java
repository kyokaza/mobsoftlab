package hu.bm.mobsoft.lab.costlog.interactor.item;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
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


}
