package cn.liuqiqi.service;

import cn.liuqiqi.entity.UserInfo;
import cn.liuqiqi.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<UserInfo> listAll() {
        return userInfoMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public UserInfo getById(Integer id) {
        return userInfoMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param userInfo 新增的记录
     * @return 返回影响行数
     */
    public int insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    /**
     * 新增，忽略null字段
     *
     * @param userInfo 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(UserInfo userInfo) {
        return userInfoMapper.insertIgnoreNull(userInfo);
    }

    /**
     * 修改，修改所有字段
     *
     * @param userInfo 修改的记录
     * @return 返回影响行数
     */
    public int update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    /**
     * 修改，忽略null字段
     *
     * @param userInfo 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(UserInfo userInfo) {
        return userInfoMapper.updateIgnoreNull(userInfo);
    }

    /**
     * 删除记录
     *
     * @param userInfo 待删除的记录
     * @return 返回影响行数
     */
    public int delete(UserInfo userInfo) {
        return userInfoMapper.delete(userInfo);
    }

}