package com.youlaiyouqu.boss.api.mapper;

import com.youlaiyouqu.boss.api.domain.SiteShow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface YuYueSiteShowMapper extends MyBaseMapper<SiteShow> {

    List<SiteShow> getSiteShowList(@Param(value = "siteId") String siteId);

    @Transactional
    void updateSiteShow(SiteShow siteShow);

    @Transactional
    void insertSiteShow(SiteShow siteShow);

    @Transactional
    void deleteSiteShow(@Param(value = "showId")String showId);
}
