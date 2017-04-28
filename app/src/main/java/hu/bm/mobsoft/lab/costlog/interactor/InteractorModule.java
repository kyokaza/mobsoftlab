package hu.bm.mobsoft.lab.costlog.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bm.mobsoft.lab.costlog.interactor.item.CostItemInteractor;
import hu.bm.mobsoft.lab.costlog.interactor.login.UserInteractor;

@Module
public class InteractorModule {

    @Provides
    public CostItemInteractor provideItems() {
        return new CostItemInteractor();
    }

    @Provides
    public UserInteractor provideUserInteractor() {
        return new UserInteractor();
    }
}