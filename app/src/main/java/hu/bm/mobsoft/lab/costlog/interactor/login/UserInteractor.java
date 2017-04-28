package hu.bm.mobsoft.lab.costlog.interactor.login;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.interactor.login.events.StartLoginEvent;
import hu.bm.mobsoft.lab.costlog.model.User;
import hu.bm.mobsoft.lab.costlog.repository.Repository;

public class UserInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public UserInteractor(Repository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public void startLogin(User user) {
        StartLoginEvent event = new StartLoginEvent();
        try {
            User fetchUser = repository.getUser();
            event.setUser(fetchUser);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
