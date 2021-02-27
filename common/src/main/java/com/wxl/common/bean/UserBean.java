package com.wxl.common.bean;

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
public class UserBean extends AbsLiveData<UserBean> {

    private String userName;

    public String getUserName() {
        return userName;
    }

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
