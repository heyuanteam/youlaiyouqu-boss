package com.youlaiyouqu.boss.api.mapper;

import com.youlaiyouqu.boss.api.domain.Advertisement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface AdReviewMapper extends MyBaseMapper<Advertisement> {

    List<Advertisement> getAdReviewList(@Param(value = "id") String id,
                                        @Param(value = "merchantName") String merchantName,
                                        @Param(value = "merchantAddr") String merchantAddr,
                                        @Param(value = "phone") String phone,
                                        @Param(value = "status") String status, @Param(value = "applicationStartTime") String applicationStartTime,
                                        @Param(value = "applicationEndTime")String applicationEndTime);

    @Transactional
    void updateAdReviewStatus(@Param(value = "id")String id,@Param(value = "status")String status);



    Advertisement getAdReview(@Param(value = "merchantId")String merchantId);



}
