package kg.t_media.questlist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyClient {

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("http://tabarman.t-media.kg/api/")
//                .baseUrl("http://192.168.88.246/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MyApi getMyApi() {
        return getRetrofitInstance().create(MyApi.class);
    }
}
