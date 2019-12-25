package com.youlaiyouqu.boss.api.service;

import com.youlaiyouqu.boss.api.domain.ChangeMoney;
import com.youlaiyouqu.boss.api.domain.Order;

import java.util.List;

public interface PayService {

    void updateOrderStatus(String responseCode, String responseMessage, String status, String orderno);

    List<Order> findOrderList(String startTime);

    void createShouMoney(ChangeMoney tGMoney);
}
