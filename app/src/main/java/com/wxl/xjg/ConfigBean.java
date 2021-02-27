package com.wxl.xjg;


/**
 * create file time : 2021/2/27
 * create user : wxl
 * subscribe :
 */
public class ConfigBean {

    private String version;//Android apk安装包 版本号
    private String downloadApkUrl;//Android apk安装包 下载地址
    private String updateDes;//版本更新描述
    private String liveWxShareUrl;//直播间微信分享地址
    private String liveShareTitle;//直播间分享标题
    private String liveShareDes;//直播间分享描述
    private String videoShareTitle;//短视频分享标题
    private String videoShareDes;//短视频分享描述
    private int videoAuditSwitch;//短视频审核是否开启
    private int videoCloudType;//短视频云储存类型 1七牛云 2腾讯云
    private String videoQiNiuHost;//短视频七牛云域名
    private String txCosAppId;//腾讯云存储appId
    private String txCosRegion;//腾讯云存储区域
    private String txCosBucketName;//腾讯云存储桶名字
    private String txCosVideoPath;//腾讯云存储视频文件夹
    private String txCosImagePath;//腾讯云存储图片文件夹
    private String coinName;//钻石名称
    private String votesName;//映票名称
    private String promotionlink;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadApkUrl() {
        return downloadApkUrl;
    }

    public void setDownloadApkUrl(String downloadApkUrl) {
        this.downloadApkUrl = downloadApkUrl;
    }

    public String getUpdateDes() {
        return updateDes;
    }

    public void setUpdateDes(String updateDes) {
        this.updateDes = updateDes;
    }

    public String getLiveWxShareUrl() {
        return liveWxShareUrl;
    }

    public void setLiveWxShareUrl(String liveWxShareUrl) {
        this.liveWxShareUrl = liveWxShareUrl;
    }

    public String getLiveShareTitle() {
        return liveShareTitle;
    }

    public void setLiveShareTitle(String liveShareTitle) {
        this.liveShareTitle = liveShareTitle;
    }

    public String getLiveShareDes() {
        return liveShareDes;
    }

    public void setLiveShareDes(String liveShareDes) {
        this.liveShareDes = liveShareDes;
    }

    public String getVideoShareTitle() {
        return videoShareTitle;
    }

    public void setVideoShareTitle(String videoShareTitle) {
        this.videoShareTitle = videoShareTitle;
    }

    public String getVideoShareDes() {
        return videoShareDes;
    }

    public void setVideoShareDes(String videoShareDes) {
        this.videoShareDes = videoShareDes;
    }

    public int getVideoAuditSwitch() {
        return videoAuditSwitch;
    }

    public void setVideoAuditSwitch(int videoAuditSwitch) {
        this.videoAuditSwitch = videoAuditSwitch;
    }

    public int getVideoCloudType() {
        return videoCloudType;
    }

    public void setVideoCloudType(int videoCloudType) {
        this.videoCloudType = videoCloudType;
    }

    public String getVideoQiNiuHost() {
        return videoQiNiuHost;
    }

    public void setVideoQiNiuHost(String videoQiNiuHost) {
        this.videoQiNiuHost = videoQiNiuHost;
    }

    public String getTxCosAppId() {
        return txCosAppId;
    }

    public void setTxCosAppId(String txCosAppId) {
        this.txCosAppId = txCosAppId;
    }

    public String getTxCosRegion() {
        return txCosRegion;
    }

    public void setTxCosRegion(String txCosRegion) {
        this.txCosRegion = txCosRegion;
    }

    public String getTxCosBucketName() {
        return txCosBucketName;
    }

    public void setTxCosBucketName(String txCosBucketName) {
        this.txCosBucketName = txCosBucketName;
    }

    public String getTxCosVideoPath() {
        return txCosVideoPath;
    }

    public void setTxCosVideoPath(String txCosVideoPath) {
        this.txCosVideoPath = txCosVideoPath;
    }

    public String getTxCosImagePath() {
        return txCosImagePath;
    }

    public void setTxCosImagePath(String txCosImagePath) {
        this.txCosImagePath = txCosImagePath;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getVotesName() {
        return votesName;
    }

    public void setVotesName(String votesName) {
        this.votesName = votesName;
    }

    public String getPromotionlink() {
        return promotionlink;
    }

    public void setPromotionlink(String promotionlink) {
        this.promotionlink = promotionlink;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "version='" + version + '\'' +
                ", downloadApkUrl='" + downloadApkUrl + '\'' +
                ", updateDes='" + updateDes + '\'' +
                ", liveWxShareUrl='" + liveWxShareUrl + '\'' +
                ", liveShareTitle='" + liveShareTitle + '\'' +
                ", liveShareDes='" + liveShareDes + '\'' +
                ", videoShareTitle='" + videoShareTitle + '\'' +
                ", videoShareDes='" + videoShareDes + '\'' +
                ", videoAuditSwitch=" + videoAuditSwitch +
                ", videoCloudType=" + videoCloudType +
                ", videoQiNiuHost='" + videoQiNiuHost + '\'' +
                ", txCosAppId='" + txCosAppId + '\'' +
                ", txCosRegion='" + txCosRegion + '\'' +
                ", txCosBucketName='" + txCosBucketName + '\'' +
                ", txCosVideoPath='" + txCosVideoPath + '\'' +
                ", txCosImagePath='" + txCosImagePath + '\'' +
                ", coinName='" + coinName + '\'' +
                ", votesName='" + votesName + '\'' +
                '}';
    }
}
