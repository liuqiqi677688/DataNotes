package cn.liuqiqi.retrofit.apiInterface;

import cn.liuqiqi.entity.UserInfo;
import cn.liuqiqi.retrofit.Intercept.TimeStampInterceptor;
import cn.liuqiqi.retrofit.annotation.Sign;
import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import org.springframework.stereotype.Component;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//@RetrofitClient(baseUrl = "${test.baseUrl}")
//通过`@RetrofitClient`的`poolName`属性来指定使用的连接池。
@RetrofitClient(baseUrl = "${test.baseUrl}", poolName = "test1", errorDecoder = ErrorDecoderT.class)
//这样就能在指定url的请求上，自动加上签名信息了。
@Sign(accessKeyId = "${test.accessKeyId}", accessKeySecret = "${test.accessKeySecret}", exclude = {"/api/test/person"})
//拦截`HttpApi`接口下`/api/**`路径下（排除`/api/test/savePerson`）的请求，拦截处理器使用`TimeStampInterceptor`。
//@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"}, exclude = "/api/test/savePerson")
public interface HttpApi {

    @GET("person")
    UserInfo getPerson(@Query("id") Long id);

    @POST("savePerson")
    UserInfo savePerson(@Body UserInfo userInfo);
}