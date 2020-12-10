package cn.liuqiqi;

import cn.liuqiqi.entity.UserInfo;
import cn.liuqiqi.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CodeGenApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(100);
        userInfo.setCity("杭州");
        userInfo.setAddress("西湖");
        userInfo.setStatus("ok");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        int i = userInfoMapper.insert(userInfo);
        Assert.isTrue(i == 1, "insert fail");
        Assert.isTrue(userInfo.getId() > 0, "insert fail, not set id");
    }

    @Test
    public void listAll() {
        List<UserInfo> userInfos = userInfoMapper.listAll();
        userInfos.forEach(System.out::println);
        Assert.isTrue(userInfos.size() > 0, "insert fail");
    }

    @Test
    public void update() {
        List<UserInfo> userInfos = userInfoMapper.listAll();
        Assert.isTrue(userInfos.size() > 0, "insert fail");
        UserInfo userInfo = userInfos.get(0);
        userInfo.setStatus("err");
        int i = userInfoMapper.update(userInfo);
        Assert.isTrue(i == 1, "insert fail");
    }

}