package hu.bm.mobsoft.lab.costlog;

import javax.inject.Singleton;

import dagger.Component;
import hu.bm.mobsoft.lab.costlog.ui.UIModule;
import hu.bm.mobsoft.lab.costlog.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
}