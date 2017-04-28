package hu.bm.mobsoft.lab.costlog;

import javax.inject.Singleton;

import dagger.Component;
import hu.bm.mobsoft.lab.costlog.interactor.InteractorModule;
import hu.bm.mobsoft.lab.costlog.interactor.item.CostItemInteractor;
import hu.bm.mobsoft.lab.costlog.interactor.login.UserInteractor;
import hu.bm.mobsoft.lab.costlog.repository.RepositoryModule;
import hu.bm.mobsoft.lab.costlog.ui.UIModule;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemActivity;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemPresenter;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListActivity;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListPresenter;
import hu.bm.mobsoft.lab.costlog.ui.loing.LoginActivity;
import hu.bm.mobsoft.lab.costlog.ui.main.MainActivity;
import hu.bm.mobsoft.lab.costlog.ui.main.MainPresenter;
import hu.bm.mobsoft.lab.costlog.ui.modifieitem.ModifieItemActivity;
import hu.bm.mobsoft.lab.costlog.ui.statistic.StatisticActivity;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(ItemListActivity itemListActivity);
    void inject(CreateItemActivity createItemActivity);
    void inject(ModifieItemActivity modifieItemActivity);
    void inject(StatisticActivity statisticActivity);

    void inject(CostItemInteractor costItemInteractor);
    void inject(UserInteractor userInteractor);

    void inject(MainPresenter mainPresenter);
    void inject(ItemListPresenter itemListPresenter);


}