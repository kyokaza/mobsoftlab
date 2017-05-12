package hu.bm.mobsoft.lab.costlog.ui.loing;


import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.interactor.login.UserInteractor;
import hu.bm.mobsoft.lab.costlog.interactor.login.events.StartLoginEvent;
import hu.bm.mobsoft.lab.costlog.model.User;
import hu.bm.mobsoft.lab.costlog.ui.Presenter;
import hu.bm.mobsoft.lab.costlog.ui.main.MainScreen;

import static hu.bm.mobsoft.lab.costlog.MobSoftApplication.injector;

public class LoginPresenter extends Presenter<LoginScreen> {
    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void startLogin(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.startLogin(user);
            }
        });
    }


    public void onEventMainThread(StartLoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.loginSuccess();
            }
        }
    }
}
