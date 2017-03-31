package hu.bm.mobsoft.lab.costlog.ui;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemPresenter;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListPresenter;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListScreen;
import hu.bm.mobsoft.lab.costlog.ui.loing.LoginPresenter;
import hu.bm.mobsoft.lab.costlog.ui.main.MainPresenter;
import hu.bm.mobsoft.lab.costlog.ui.modifieitem.ModifieItemPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public ItemListPresenter provideItemListPresenter() {
        return new ItemListPresenter();
    }

    @Provides
    @Singleton
    public CreateItemPresenter provideCreateItemPresenter() {
        return new CreateItemPresenter();
    }

    @Provides
    @Singleton
    public ModifieItemPresenter provideModifieItemPresenter() {
        return new ModifieItemPresenter();
    }

}
