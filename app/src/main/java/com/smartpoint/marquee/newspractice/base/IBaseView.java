package com.smartpoint.marquee.newspractice.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * Created by Administrator on 2018/8/15
 * 邮箱 18780569202@163.com
 * 各种状态管理
 */
public interface IBaseView<T> {
    /**
     * 显示加载动画
     */
    void onShowLoading();

    /**
     * 隐藏加载
     */
    void onHideLoading();

    /**
     * 显示网络错误
     */
    void onShowNetError();

    /**
     * 设置 presenter
     */
    void setPresenter(T presenter);

    /**
     * 绑定生命周期
     */
    <X> AutoDisposeConverter<X> bindAutoDispose();
}
