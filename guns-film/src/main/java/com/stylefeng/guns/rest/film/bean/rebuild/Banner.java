package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeBannerT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 15:02
 */
public class Banner extends MtimeBannerT {
    private int bannerId;


    public Banner() {
    }


    public Banner(int bannerId, String bannerAddress, String bannerUrl) {
        this.setBannerId(bannerId);
        this.setBannerAddress(bannerAddress);
        this.setBannerUrl(bannerUrl);
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    @Override
    public String getBannerAddress(){
        return super.getBannerAddress();
    }

    @Override
    public String getBannerUrl(){
        return super.getBannerUrl();
    }

}
