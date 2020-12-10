package cn.liuqiqi.retrofit;

import cn.liuqiqi.retrofit.apiInterface.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private HttpApi httpApi;

    public void test() {
        // 通过httpApi发起http请求
        httpApi.getPerson(1L);
    }
}