package hu.bm.mobsoft.lab.costlog.ui.main;


import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}