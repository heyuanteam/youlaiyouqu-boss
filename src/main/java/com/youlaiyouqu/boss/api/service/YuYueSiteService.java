package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.SiteShow;
import com.youlaiyouqu.boss.api.domain.YuYueSite;


import java.util.List;


public interface YuYueSiteService {

    List<YuYueSite> getYuYueSiteInfo(String id);

    List<YuYueSite> searchYuYueSiteInfo(String siteAddr, String status,String jPushStatus,
                                        String mainPerson,String startTime,String endTime);

    void insertQRCodePath(String id ,String qrCodePath);

    void insertYuYueSite(YuYueSite yuYueSite);

    void updateYuYueSite(YuYueSite yuYueSite);

    void deleteYuYueSiteById(String id);
/*--------------------------------下面为节目单功能-------------------------------------->*/
    //List<SiteShow> getSiteShowList(String siteId);

    void insertSiteShow(SiteShow siteShow);

    void updateSiteShow(SiteShow siteShow);

    void deleteSiteShow(String showId);

}
