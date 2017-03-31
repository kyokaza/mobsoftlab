package hu.bm.mobsoft.lab.costlog;

import javax.inject.Singleton;

import dagger.Component;
import hu.bm.mobsoft.lab.costlog.ui.UIModule;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemActivity;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemPresenter;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListActivity;
import hu.bm.mobsoft.lab.costlog.ui.loing.LoginActivity;
import hu.bm.mobsoft.lab.costlog.ui.main.MainActivity;
import hu.bm.mobsoft.lab.costlog.ui.modifieitem.ModifieItemActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity        mainActivity);
    void inject(LoginActivity       loginActivity);
    void inject(ItemListActivity    itemListActivity);
    void inject(CreateItemActivity  createItemActivity);
    void inject(ModifieItemActivity modifieItemActivity);
}