package cn.liuqiqi.retrofit.apiInterface;

import cn.liuqiqi.entity.UserInfo;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.OkHttpClient;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

import java.util.concurrent.TimeUnit;

@RetrofitClient(baseUrl = "http://ke.com")
public interface HttpApi3 {

    @OkHttpClientBuilder
    static OkHttpClient.Builder okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS);

    }

    @GET
    UserInfo getPerson(@Url String url, @Query("id") Long id);
}