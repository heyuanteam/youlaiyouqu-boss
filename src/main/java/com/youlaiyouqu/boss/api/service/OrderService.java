package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(String orderId);

    void  deleteOrderById(String id);

    void updateOrder(Order order);
    String getMallAddress(String orderId);

    List<Order> getOrderList(String orderNo, String realName, String mobile,
                             String tradeType, String status, String startTime,
                             String endTime, String type,String userType);
}
