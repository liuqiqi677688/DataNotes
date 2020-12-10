package cn.liuqiqi.controller;

import java.util.List;

import cn.liuqiqi.entity.UserInfo;
import cn.liuqiqi.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @RequestMapping("list")
    public List<UserInfo> listAll() {
        return userInfoService.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @RequestMapping("getById")
    public UserInfo getById(Integer id) {
        return userInfoService.getById(id);
    }

    /**
     * 新增，忽略null字段
     *
     * @param userInfo 新增的记录
     * @return 返回影响行数
     */
    @RequestMapping("insert")
    public int insert(@RequestBody UserInfo userInfo) {
        return userInfoService.insertIgnoreNull(userInfo);
    }

    /**
     * 修改，忽略null字段
     *
     * @param userInfo 修改的记录
     * @return 返回影响行数
     */
    @RequestMapping("update")
    public int update(@RequestBody UserInfo userInfo) {
        return userInfoService.updateIgnoreNull(userInfo);
    }

    /**
     * 删除记录
     *
     * @param userInfo 待删除的记录
     * @return 返回影响行数
     */
    @RequestMapping("delete")
    public int delete(@RequestBody UserInfo userInfo) {
        return userInfoService.delete(userInfo);
    }

}