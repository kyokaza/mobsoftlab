package hu.bm.mobsoft.lab.costlog;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bm.mobsoft.lab.costlog.ui.UIModule;
import hu.bm.mobsoft.lab.costlog.ui.createitem.CreateItemPresenter;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListPresenter;
import hu.bm.mobsoft.lab.costlog.ui.loing.LoginPresenter;
import hu.bm.mobsoft.lab.costlog.ui.main.MainPresenter;
import hu.bm.mobsoft.lab.costlog.ui.statistic.StatisticPresenter;
import hu.bm.mobsoft.lab.costlog.utils.UiExecutor;


@Module
public class TestModule {

	private final hu.bm.mobsoft.lab.costlog.ui.UIModule UIModule;

	public TestModule(Context context) {
		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}


	@Provides
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}

	@Provides
	public ItemListPresenter provideItemListPresenter() {
		return UIModule.provideItemListPresenter();
	}

	@Provides
	public LoginPresenter provideLoginPresenter() {
		return UIModule.provideLoginPresenter();
	}

	@Provides
	public CreateItemPresenter provideCreateItemPresenter() {
		return UIModule.provideCreateItemPresenter();
	}

	@Provides
	public StatisticPresenter provideStatisticPresenter() {
		return UIModule.provideStatisticPresenter();
	}


	@Provides
	@Singleton
	public EventBus provideEventBus() {
		return EventBus.getDefault();
	}

	@Provides
	@Singleton
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}


}
