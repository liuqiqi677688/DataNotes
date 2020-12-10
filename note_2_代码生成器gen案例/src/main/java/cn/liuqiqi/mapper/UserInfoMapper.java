package cn.liuqiqi.mapper;

import cn.liuqiqi.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    List<UserInfo> listAll();


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    UserInfo getById(Integer id);

    /**
     * 新增，插入所有字段
     *
     * @param userInfo 新增的记录
     * @return 返回影响行数
     */
    int insert(UserInfo userInfo);

    /**
     * 新增，忽略null字段
     *
     * @param userInfo 新增的记录
     * @return 返回影响行数
     */
    int insertIgnoreNull(UserInfo userInfo);

    /**
     * 修改，修改所有字段
     *
     * @param userInfo 修改的记录
     * @return 返回影响行数
     */
    int update(UserInfo userInfo);

    /**
     * 修改，忽略null字段
     *
     * @param userInfo 修改的记录
     * @return 返回影响行数
     */
    int updateIgnoreNull(UserInfo userInfo);

    /**
     * 删除记录
     *
     * @param userInfo 待删除的记录
     * @return 返回影响行数
     */
    int delete(UserInfo userInfo);

}