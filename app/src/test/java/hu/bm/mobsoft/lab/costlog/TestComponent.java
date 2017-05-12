package hu.bm.mobsoft.lab.costlog;

import javax.inject.Singleton;

import dagger.Component;
import hu.bm.mobsoft.lab.costlog.interactor.InteractorModule;
import hu.bm.mobsoft.lab.costlog.mock.MockNetworkModule;
import hu.bm.mobsoft.lab.costlog.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
