package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.Advertisement;

import java.util.List;

public interface AdReviewService {

    List<Advertisement> getAdReviewList(String id,String merchantName,String merchantAddr,String phone,String status,String applicationStartTime,String applicationEndTime);

    void updateAdReviewStatus(String id,String status);

    Advertisement getAdReview(String merchantId);
}
