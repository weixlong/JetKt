package com.wxl.common.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserBean extends AbsLiveData<UserBean> {

    private String userName;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    protected void onActive() {
        super.onActive();

    }

    @Override
    protected void onInactive() {
        super.onInactive();

    }
}
