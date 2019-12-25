package com.youlaiyouqu.boss.api.service.impl;

import com.youlaiyouqu.boss.api.service.ChangeMoneyService;
import com.youlaiyouqu.boss.api.domain.ChangeMoney;
import com.youlaiyouqu.boss.api.mapper.ChangeMoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ChangeMoneyService")
public class ChangeMoneyServiceImpl implements ChangeMoneyService {

    @Autowired
    private ChangeMoneyMapper changeMoneyMapper;

    @Override
    public List<ChangeMoney> getChangeMoneyList(String id, String changeNo, String sourceName, String tradeType,
                                                String mobile, String status, String note, String yiName,
                                                String startTime, String endTime) {
        return changeMoneyMapper.getChangeMoneyList(id,changeNo,sourceName,tradeType,mobile,status,note,yiName,startTime,endTime);
    }

    @Override
    public void updateChangeMoney(String id, String money, String note, String status, String mobile) {
        changeMoneyMapper.updateChangeMoney(id,money,note,status,mobile);
    }

    @Override
    public void delOutMoney(String id) {
        changeMoneyMapper.delOutMoney(id);
    }
}
