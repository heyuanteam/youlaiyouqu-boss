package com.youlaiyouqu.boss.api.service.impl;

import com.youlaiyouqu.boss.api.mapper.LookupCdeMapper;
import com.youlaiyouqu.boss.api.service.LookupCdeService;
import com.youlaiyouqu.boss.api.domain.LookupCde;
import com.youlaiyouqu.boss.api.domain.LookupCdeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ly
 */
@Service(value = "LookupCdeService")
public class LookupCdeServiceImpl implements LookupCdeService {

    @Autowired
    private LookupCdeMapper lookupCdeMapper;

    @Override
    public List<LookupCde> getLookupCdeSystem(String status, String typeName, String id) {
        return lookupCdeMapper.getLookupCdeSystem(status,typeName,id); }

    @Override
    public void insertLookupCde(LookupCde lookupCde) { lookupCdeMapper.insertLookupCde(lookupCde); }

    @Override
    public void updateLookupCde(String id, String typeName, String status) {
        lookupCdeMapper.updateLookupCde(id,typeName,status); }

    @Override
    public List<LookupCdeConfig> getLookupCdeList(String systemId, String id) {
        return lookupCdeMapper.getLookupCdeList(systemId,id); }

    @Override
    public void insertLookupCdeConfig(LookupCdeConfig lookupCdeConfig) {
        lookupCdeMapper.insertLookupCdeConfig(lookupCdeConfig); }

    @Override
    public void updateLookupCdeList(String id, String type, String status) {
        lookupCdeMapper.updateLookupCdeList(id,type,status); }

    @Override
    public void delLookupCdeList(String id) {
        lookupCdeMapper.delLookupCdeList(id); }

    @Override
    public void delLookupCdeSystem(String id) {
        lookupCdeMapper.delLookupCdeSystem(id); }

}
