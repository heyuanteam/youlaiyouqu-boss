package com.youlaiyouqu.boss.api.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

public interface MyBaseMapper<T> extends Mapper<T>, IdsMapper<T> {
}
