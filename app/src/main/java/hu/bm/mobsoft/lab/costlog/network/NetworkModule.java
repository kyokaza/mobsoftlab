package hu.bm.mobsoft.lab.costlog.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bm.mobsoft.lab.costlog.model.Item;
import hu.bm.mobsoft.lab.costlog.network.costlogapi.ItemApi;
import hu.bm.mobsoft.lab.costlog.network.costlogapi.LoginApi;
import hu.bm.mobsoft.lab.costlog.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public ItemApi provideAnItemApi(Retrofit retrofit) {
        return retrofit.create(ItemApi.class);
    }

    @Provides
    @Singleton
    public LoginApi provideALoginApi(Retrofit retrofit) {
        return retrofit.create(LoginApi.class);
    }


}
