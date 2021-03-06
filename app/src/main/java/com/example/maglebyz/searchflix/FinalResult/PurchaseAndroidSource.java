
package com.example.maglebyz.searchflix.FinalResult;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseAndroidSource implements Serializable
{

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("app_link")
    @Expose
    private Integer appLink;
    @SerializedName("app_required")
    @Expose
    private Integer appRequired;
    @SerializedName("app_download_link")
    @Expose
    private String appDownloadLink;
    @SerializedName("formats")
    @Expose
    private List<Format__> formats = null;
    private final static long serialVersionUID = 184816760997998606L;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAppLink() {
        return appLink;
    }

    public void setAppLink(Integer appLink) {
        this.appLink = appLink;
    }

    public Integer getAppRequired() {
        return appRequired;
    }

    public void setAppRequired(Integer appRequired) {
        this.appRequired = appRequired;
    }

    public String getAppDownloadLink() {
        return appDownloadLink;
    }

    public void setAppDownloadLink(String appDownloadLink) {
        this.appDownloadLink = appDownloadLink;
    }

    public List<Format__> getFormats() {
        return formats;
    }

    public void setFormats(List<Format__> formats) {
        this.formats = formats;
    }

}
