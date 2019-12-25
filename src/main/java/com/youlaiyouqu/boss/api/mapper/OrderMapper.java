package com.youlaiyouqu.boss.api.mapper;

import com.youlaiyouqu.boss.api.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderMapper extends MyBaseMapper<Order> {

    @Select("SELECT *,DATE_FORMAT(COMPLETE_TIME ,'%Y-%m-%d %H:%i:%s') completeTime FROM yuyue_order b WHERE b.id = #{orderId} limit 1")
    Order getOrderById(String orderId);

    @Transactional
    void  deleteOrderById(String id);

    @Transactional
    void updateOrder(Order order);

    String getMallAddress(@Param(value = "orderId") String orderId);


    List<Order> getOrderList(@Param("orderNo") String orderNo,@Param("realName") String realName,@Param("mobile") String mobile,
                             @Param("tradeType") String tradeType,@Param("status") String status,
                             @Param("startTime") String startTime,@Param("endTime") String endTime,
                             @Param("type") String type,@Param("userType") String userType);
}
