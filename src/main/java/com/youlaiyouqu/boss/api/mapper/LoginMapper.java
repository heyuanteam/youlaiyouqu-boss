package com.youlaiyouqu.boss.api.mapper;

import com.youlaiyouqu.boss.api.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ly
 */
@Repository
public interface LoginMapper extends MyBaseMapper<SystemUser> {

    List<SystemUser> getSystemUserMsg(@Param("loginName") String loginName, @Param("password") String password,@Param("id") String id,
                                @Param("phone") String phone);

    @Select("SELECT c.menuKey,c.saveKey,c.removeKey FROM yuyue_system_permission c" +
            " WHERE c.systemUserId =#{systemUserId} AND c.`status` = '10B' ORDER BY c.CREATE_TIME")
    List<SystemPermission> getSystemUserVO(@Param("systemUserId") String systemUserId);

    List<SystemMenuVo> getMenuList(@Param("loginName") String loginName, @Param("password") String password);

    List<SystemMenu> getMenu(@Param("id") String id, @Param("sort") Integer sort, @Param("role") String role,
                             @Param("menuName")String menuName, @Param("status")String status);

    @Transactional
    @Insert("INSERT into yuyue_system_menu (id,menuName,menuAction,sort,role)  values  " +
            "(#{id},#{menuName},#{menuAction},#{sort},#{role})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertSystemMenu(SystemMenu systemMenu);

    @Transactional
    void updateSystemMenu(@Param("id")String id,@Param("upSort") int upSort,@Param("status")String status,
                          @Param("menuName")String menuName,@Param("menuAction")String menuAction);

    @Transactional
    @Insert("INSERT into yuyue_system_permission (id,systemUserId,menuId,menuKey,saveKey,removeKey)  values  " +
            "(#{id},#{systemUserId},#{menuId},#{menuKey},#{saveKey},#{removeKey})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertSystemPermission(@Param("id") String id,@Param("systemUserId") String systemUserId, @Param("menuId") String menuId,
                                @Param("menuKey") String menuKey, @Param("saveKey") String saveKey, @Param("removeKey") String removeKey);

    @Transactional
    @Delete("DELETE FROM yuyue_system_menu WHERE id =#{id} ")
    void delMenu(@Param("id") String id);

    List<SystemPermission> getSystemPermission(@Param("menuId")String menuId,@Param("systemUserId")String systemUserId,
                                               @Param("id") String id);

    @Transactional
    @Delete("DELETE FROM yuyue_system_permission WHERE id =#{id} ")
    void delSystemPermission(@Param("id")String id);

    List<SystemUser> getSystemUser(@Param("status") String status,@Param("systemName") String systemName,@Param("loginName") String loginName,
                                   @Param("id") String id,@Param("phone") String phone);

    @Transactional
    void updateSystemUser(@Param("id") String id,@Param("loginName") String loginName,@Param("password") String password,
                          @Param("systemName") String systemName,@Param("phone") String phone,@Param("status") String status);

    @Transactional
    @Delete("DELETE FROM yuyue_system_user WHERE id =#{id} ")
    void delSystemUser(@Param("id")String id);

    List<SystemUserVO> getAppUserMsg(@Param("loginName")String loginName, @Param("password") String password);

    @Transactional
    @Insert("INSERT into yuyue_system_user (id,loginName,password,systemName,phone,createUserId)  values  " +
            "(#{id},#{loginName},#{password},#{systemName},#{phone},#{createUserId})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertSystemUser(SystemUser systemUser);

    @Transactional
    @Update("UPDATE yuyue_system_permission SET menuKey=#{menuKey},saveKey=#{saveKey},removeKey=#{removeKey} WHERE id =#{id} ")
    void updateSystemPermission(@Param("id")String id,@Param("menuKey") String menuKey,@Param("saveKey") String saveKey,
                                @Param("removeKey")String removeKey);

}
