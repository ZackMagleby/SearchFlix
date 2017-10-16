package com.example.maglebyz.searchflix.FinalResult;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewMovie extends Movie {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("release_year")
    @Expose
    private Integer releaseYear;
    @SerializedName("themoviedb")
    @Expose
    private Integer themoviedb;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("alternate_titles")
    @Expose
    private List<String> alternateTitles = null;
    @SerializedName("imdb")
    @Expose
    private String imdb;
    @SerializedName("pre_order")
    @Expose
    private Boolean preOrder;
    @SerializedName("in_theaters")
    @Expose
    private Boolean inTheaters;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("rottentomatoes")
    @Expose
    private Integer rottentomatoes;
    @SerializedName("freebase")
    @Expose
    private String freebase;
    @SerializedName("wikipedia_id")
    @Expose
    private Integer wikipediaId;
    @SerializedName("metacritic")
    @Expose
    private String metacritic;
    @SerializedName("common_sense_media")
    @Expose
    private String commonSenseMedia;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_120x171")
    @Expose
    private String poster120x171;
    @SerializedName("poster_240x342")
    @Expose
    private String poster240x342;
    @SerializedName("poster_400x570")
    @Expose
    private String poster400x570;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("free_web_sources")
    @Expose
    private List<Object> freeWebSources = null;
    @SerializedName("free_ios_sources")
    @Expose
    private List<Object> freeIosSources = null;
    @SerializedName("free_android_sources")
    @Expose
    private List<Object> freeAndroidSources = null;
    @SerializedName("tv_everywhere_web_sources")
    @Expose
    private List<Object> tvEverywhereWebSources = null;
    @SerializedName("tv_everywhere_ios_sources")
    @Expose
    private List<Object> tvEverywhereIosSources = null;
    @SerializedName("tv_everywhere_android_sources")
    @Expose
    private List<Object> tvEverywhereAndroidSources = null;
    @SerializedName("subscription_web_sources")
    @Expose
    private List<SubscriptionWebSource> subscriptionWebSources = null;
    @SerializedName("subscription_ios_sources")
    @Expose
    private List<SubscriptionIosSource> subscriptionIosSources = null;
    @SerializedName("subscription_android_sources")
    @Expose
    private List<SubscriptionAndroidSource> subscriptionAndroidSources = null;
    @SerializedName("purchase_web_sources")
    @Expose
    private List<PurchaseWebSource> purchaseWebSources = null;
    @SerializedName("purchase_ios_sources")
    @Expose
    private List<PurchaseIosSource> purchaseIosSources = null;
    @SerializedName("purchase_android_sources")
    @Expose
    private List<PurchaseAndroidSource> purchaseAndroidSources = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getThemoviedb() {
        return themoviedb;
    }

    public void setThemoviedb(Integer themoviedb) {
        this.themoviedb = themoviedb;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<String> getAlternateTitles() {
        return alternateTitles;
    }

    public void setAlternateTitles(List<String> alternateTitles) {
        this.alternateTitles = alternateTitles;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    public Boolean getInTheaters() {
        return inTheaters;
    }

    public void setInTheaters(Boolean inTheaters) {
        this.inTheaters = inTheaters;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getRottentomatoes() {
        return rottentomatoes;
    }

    public void setRottentomatoes(Integer rottentomatoes) {
        this.rottentomatoes = rottentomatoes;
    }

    public String getFreebase() {
        return freebase;
    }

    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    public Integer getWikipediaId() {
        return wikipediaId;
    }

    public void setWikipediaId(Integer wikipediaId) {
        this.wikipediaId = wikipediaId;
    }

    public String getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }

    public String getCommonSenseMedia() {
        return commonSenseMedia;
    }

    public void setCommonSenseMedia(String commonSenseMedia) {
        this.commonSenseMedia = commonSenseMedia;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster120x171() {
        return poster120x171;
    }

    public void setPoster120x171(String poster120x171) {
        this.poster120x171 = poster120x171;
    }

    public String getPoster240x342() {
        return poster240x342;
    }

    public void setPoster240x342(String poster240x342) {
        this.poster240x342 = poster240x342;
    }

    public String getPoster400x570() {
        return poster400x570;
    }

    public void setPoster400x570(String poster400x570) {
        this.poster400x570 = poster400x570;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Object> getFreeWebSources() {
        return freeWebSources;
    }

    public void setFreeWebSources(List<Object> freeWebSources) {
        this.freeWebSources = freeWebSources;
    }

    public List<Object> getFreeIosSources() {
        return freeIosSources;
    }

    public void setFreeIosSources(List<Object> freeIosSources) {
        this.freeIosSources = freeIosSources;
    }

    public List<Object> getFreeAndroidSources() {
        return freeAndroidSources;
    }

    public void setFreeAndroidSources(List<Object> freeAndroidSources) {
        this.freeAndroidSources = freeAndroidSources;
    }

    public List<Object> getTvEverywhereWebSources() {
        return tvEverywhereWebSources;
    }

    public void setTvEverywhereWebSources(List<Object> tvEverywhereWebSources) {
        this.tvEverywhereWebSources = tvEverywhereWebSources;
    }

    public List<Object> getTvEverywhereIosSources() {
        return tvEverywhereIosSources;
    }

    public void setTvEverywhereIosSources(List<Object> tvEverywhereIosSources) {
        this.tvEverywhereIosSources = tvEverywhereIosSources;
    }

    public List<Object> getTvEverywhereAndroidSources() {
        return tvEverywhereAndroidSources;
    }

    public void setTvEverywhereAndroidSources(List<Object> tvEverywhereAndroidSources) {
        this.tvEverywhereAndroidSources = tvEverywhereAndroidSources;
    }

    public List<SubscriptionWebSource> getSubscriptionWebSources() {
        return subscriptionWebSources;
    }

    public void setSubscriptionWebSources(List<SubscriptionWebSource> subscriptionWebSources) {
        this.subscriptionWebSources = subscriptionWebSources;
    }

    public List<SubscriptionIosSource> getSubscriptionIosSources() {
        return subscriptionIosSources;
    }

    public void setSubscriptionIosSources(List<SubscriptionIosSource> subscriptionIosSources) {
        this.subscriptionIosSources = subscriptionIosSources;
    }

    public List<SubscriptionAndroidSource> getSubscriptionAndroidSources() {
        return subscriptionAndroidSources;
    }

    public void setSubscriptionAndroidSources(List<SubscriptionAndroidSource> subscriptionAndroidSources) {
        this.subscriptionAndroidSources = subscriptionAndroidSources;
    }

    public List<PurchaseWebSource> getPurchaseWebSources() {
        return purchaseWebSources;
    }

    public void setPurchaseWebSources(List<PurchaseWebSource> purchaseWebSources) {
        this.purchaseWebSources = purchaseWebSources;
    }

    public List<PurchaseIosSource> getPurchaseIosSources() {
        return purchaseIosSources;
    }

    public void setPurchaseIosSources(List<PurchaseIosSource> purchaseIosSources) {
        this.purchaseIosSources = purchaseIosSources;
    }

    public List<PurchaseAndroidSource> getPurchaseAndroidSources() {
        return purchaseAndroidSources;
    }

    public void setPurchaseAndroidSources(List<PurchaseAndroidSource> purchaseAndroidSources) {
        this.purchaseAndroidSources = purchaseAndroidSources;
    }
}