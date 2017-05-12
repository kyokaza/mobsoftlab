package hu.bm.mobsoft.lab.costlog;

import android.app.Application;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.repository.Repository;
import hu.bm.mobsoft.lab.costlog.ui.UIModule;


public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;
    @Inject
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }

    public void setInjector(MobSoftApplicationComponent injector) {
        MobSoftApplication.injector = injector;
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
