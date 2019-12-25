package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.Commodity;

import java.util.List;

public interface CommodityService {
    void deleteCommodity(String id);

    Commodity getCommodityInfoById(String id);

    List<Commodity> getCommodityInfo( String commodityId,String commodityName, String category,String status,
                                     String startTime, String endTime);

    void updateCommodityInfo(Commodity commodity);

    List<Commodity> getReleaseCommodity(String videoId);

    public void insertCommodity(Commodity commodity);
}
