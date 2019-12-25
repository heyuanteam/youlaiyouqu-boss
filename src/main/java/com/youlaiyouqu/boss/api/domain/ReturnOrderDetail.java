package com.youlaiyouqu.boss.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private AppUser appUser;
    private MallAddress mallAddress;
}
