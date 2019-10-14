package com.yuyue.boss.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyue.boss.api.domain.*;
import com.yuyue.boss.api.mapper.LoginMapper;
import com.yuyue.boss.api.service.LoginService;
import com.yuyue.boss.utils.BeanUtil;
import com.yuyue.boss.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 */
@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
    private Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<SystemUser> getSystemUserMsg(String loginName,String password,String id,String phone) { return loginMapper.getSystemUserMsg(loginName,password,id,phone); }


    @Override
    public UserVO getUser(String loginName, String password) {
        List<SystemUser> systemUser = getSystemUserMsg(loginName, password,"","");
        UserVO userVO = BeanUtil.copyProperties(systemUser.get(0), UserVO.class);
        List<SystemPermission> list = loginMapper.getSystemUserVO(systemUser.get(0).getId());
        List<String> arrayList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (SystemPermission systemPermission: list) {
                if (StringUtils.isNotEmpty(systemPermission.getMenuKey())) {
                    arrayList.add(systemPermission.getMenuKey());
                }
                if (StringUtils.isNotEmpty(systemPermission.getSaveKey())){
                    arrayList.add(systemPermission.getSaveKey());
                }
                if (StringUtils.isNotEmpty(systemPermission.getRemoveKey())){
                    arrayList.add(systemPermission.getRemoveKey());
                }
            }
        }
        userVO.setPermissions(arrayList);
        userVO.setToken(getToken(userVO));
        return userVO;
    }

    @Override
    public String getToken(UserVO systemUser) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(systemUser.getId())          // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(systemUser.getPassword()));   // 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException ignore) {
            ignore.printStackTrace();
            log.info("token生成错误！" );
        }
        return token;
    }

    @Override
    public List<SystemMenuVo> getMenuList(String loginName, String password){
        return loginMapper.getMenuList(loginName,password);
    }

    @Override
    public List<SystemMenu> getMenu(String id,Integer sort,String role,String menuName,String status){
        return loginMapper.getMenu(id,sort,role,menuName,status);
    }

    @Override
    public void insertSystemMenu(SystemMenu systemMenu) { loginMapper.insertSystemMenu(systemMenu); }

    @Override
    public void updateSystemMenu(String id, int upSort,String status,String menuName) { loginMapper.updateSystemMenu(id,upSort,status,menuName); }

    @Override
    public void insertSystemPermission(String id, String systemUserId, String menuId, String menuKey, String saveKey, String removeKey) {
        loginMapper.insertSystemPermission(id,systemUserId,menuId,menuKey,saveKey,removeKey);
    }

    @Override
    public void delMenu(String id) { loginMapper.delMenu(id);}

    @Override
    public List<SystemPermission> getSystemPermission(String menuId,String systemUserId,String id) {
        return loginMapper.getSystemPermission(menuId,systemUserId,id);
    }

    @Override
    public void delSystemPermission(String id) { loginMapper.delSystemPermission(id);}

    @Override
    public List<SystemUser> getSystemUser(String status, String systemName,String loginName,String id) { return loginMapper.getSystemUser(status,systemName,loginName,id); }

    @Override
    public void updateSystemUser(String id, String loginName, String password, String systemName, String phone,String status) {
        loginMapper.updateSystemUser(id,loginName,password,systemName,phone,status);
    }

    @Override
    public void delSystemUser(String id) { loginMapper.delSystemUser(id); }

    @Override
    public List<SystemUserVO> getAppUserMsg(String loginName, String password) { return loginMapper.getAppUserMsg(loginName,password); }

    @Override
    public void insertSystemUser(SystemUser user) { loginMapper.insertSystemUser(user); }

    @Override
    public void updateSystemPermission(String id, String menuKey, String saveKey, String removeKey) {
        loginMapper.updateSystemPermission(id,menuKey,saveKey,removeKey); }

    @Override
    public List<LookupCde> getLookupCdeSystem(String status, String typeName, String id) { return loginMapper.getLookupCdeSystem(status,typeName,id); }

    @Override
    public void insertLookupCde(LookupCde lookupCde) { loginMapper.insertLookupCde(lookupCde); }

    @Override
    public void updateLookupCde(String id, String typeName, String status) {
        loginMapper.updateLookupCde(id,typeName,status); }

    @Override
    public List<LookupCdeConfig> getLookupCdeList(String systemId,String id) {
        return loginMapper.getLookupCdeList(systemId,id); }

    @Override
    public void insertLookupCdeConfig(LookupCdeConfig lookupCdeConfig) {
        loginMapper.insertLookupCdeConfig(lookupCdeConfig); }

    @Override
    public void updateLookupCdeList(String id, String type, String status) {
        loginMapper.updateLookupCdeList(id,type,status); }

    @Override
    public void delLookupCdeList(String id) {
        loginMapper.delLookupCdeList(id); }

    @Override
    public void delLookupCdeSystem(String id) {
        loginMapper.delLookupCdeSystem(id); }

    @Override
    public List<AppVersion> getVersionList(String systemType, String versionNo,String appVersionId){
        return loginMapper.getVersionList(systemType,versionNo,appVersionId); }

    @Override
    public void insertAppVersion(AppVersion appVersion) {
        loginMapper.insertAppVersion(appVersion); }

    @Override
    public void updateAppVersion(String appVersionId, String versionNo, String systemType, String programDescription, String status) {
        loginMapper.updateAppVersion(appVersionId,versionNo,systemType,programDescription,status); }

    @Override
    public void delVersion(String appVersionId) {
        loginMapper.delVersion(appVersionId); }
}
