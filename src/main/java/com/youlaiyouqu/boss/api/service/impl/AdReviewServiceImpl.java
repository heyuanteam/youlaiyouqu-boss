package com.youlaiyouqu.boss.api.service.impl;

import com.youlaiyouqu.boss.api.service.AdReviewService;
import com.youlaiyouqu.boss.api.domain.Advertisement;
import com.youlaiyouqu.boss.api.mapper.AdReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "AdReviewService")
public class AdReviewServiceImpl implements AdReviewService {

    @Autowired
    private AdReviewMapper adReviewMapper;
    /**
     * 修改广告商审核状态
     */
    @Override
    public List<Advertisement> getAdReviewList(String id,String merchantName, String merchantAddr,String phone, String status, String applicationStartTime,String applicationEndTime) {
        return adReviewMapper.getAdReviewList(id,merchantName,merchantAddr,phone,status, applicationStartTime,applicationEndTime);
    }
    /**
     * 修改广告商审核状态
     */
    @Override
    public void updateAdReviewStatus(String id, String status) {
        adReviewMapper.updateAdReviewStatus(id,status);
    }

    @Override
    public Advertisement getAdReview(String merchantId) {
        return adReviewMapper.getAdReview(merchantId);
    }


}
