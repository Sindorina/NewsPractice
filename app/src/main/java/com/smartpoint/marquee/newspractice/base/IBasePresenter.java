package com.smartpoint.marquee.newspractice.base;

/**
 * Created by Administrator on 2018/8/15
 * 邮箱 18780569202@163.com
 */
public interface IBasePresenter {
    /**
     * 刷新数据
     */
    void doRefresh();

    /**
     * 显示网络错误
     */
    void doShowNetError();
}
