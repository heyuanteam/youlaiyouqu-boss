package com.youlaiyouqu.boss.api.service.impl;

import com.youlaiyouqu.boss.api.service.AppService;
import com.youlaiyouqu.boss.api.domain.AppVersion;
import com.youlaiyouqu.boss.api.domain.Banner;
import com.youlaiyouqu.boss.api.domain.VideoCategory;
import com.youlaiyouqu.boss.api.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ly
 */
@Service(value = "AppService")
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Override
    public List<AppVersion> getVersionList(String systemType, String versionNo, String appVersionId){
        return appMapper.getVersionList(systemType,versionNo,appVersionId); }

    @Override
    public void insertAppVersion(AppVersion appVersion) {
        appMapper.insertAppVersion(appVersion); }

    @Override
    public void updateAppVersion(String appVersionId, String versionNo, String systemType, String programDescription, String status,String number) {
        appMapper.updateAppVersion(appVersionId,versionNo,systemType,programDescription,status,number); }

    @Override
    public void delVersion(String appVersionId) {
        appMapper.delVersion(appVersionId); }

    @Override
    public List<VideoCategory> getAPPMenuList(String id, String category, String status, int number) {
        return appMapper.getAPPMenuList(id,category,status,number); }

    @Override
    public void insertVideoCategory(VideoCategory videoCategory) {
        appMapper.insertVideoCategory(videoCategory); }

    @Override
    public void updateAPPMenu(String id, int sort, String status, String category,String url) {
        appMapper.updateAPPMenu(id,sort,status,category,url); }

    @Override
    public void delAPPMenu(String id) {
        appMapper.delAPPMenu(id); }

    @Override
    public List<Banner> getBannerList(String id, String name, String status, int sort) {
        return appMapper.getBannerList(id,name,status,sort); }

    @Override
    public void insertBanner(Banner banner) { appMapper.insertBanner(banner); }

    @Override
    public void updateBanner(String id, int sort, String name, String status, String url) {
        appMapper.updateBanner(id,sort,name,status,url); }

    @Override
    public void delBanner(String id) { appMapper.delBanner(id); }
}
