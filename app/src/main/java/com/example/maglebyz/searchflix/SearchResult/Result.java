
package com.example.maglebyz.searchflix.SearchResult;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Result implements Serializable
{

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
    private Object commonSenseMedia;
    @SerializedName("poster_120x171")
    @Expose
    private String poster120x171;
    @SerializedName("poster_240x342")
    @Expose
    private String poster240x342;
    @SerializedName("poster_400x570")
    @Expose
    private String poster400x570;
    private final static long serialVersionUID = 1513263674832944255L;

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

    public Object getCommonSenseMedia() {
        return commonSenseMedia;
    }

    public void setCommonSenseMedia(Object commonSenseMedia) {
        this.commonSenseMedia = commonSenseMedia;
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
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("id", id).append("title", title).append("releaseYear", releaseYear).append("themoviedb", themoviedb).append("originalTitle", originalTitle).append("alternateTitles", alternateTitles).append("imdb", imdb).append("preOrder", preOrder).append("inTheaters", inTheaters).append("releaseDate", releaseDate).append("rating", rating).append("rottentomatoes", rottentomatoes).append("freebase", freebase).append("wikipediaId", wikipediaId).append("metacritic", metacritic).append("commonSenseMedia", commonSenseMedia).append("poster120x171", poster120x171).append("poster240x342", poster240x342).append("poster400x570", poster400x570).toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(alternateTitles).append(rottentomatoes).append(inTheaters).append(imdb).append(poster120x171).append(commonSenseMedia).append(themoviedb).append(metacritic).append(releaseYear).append(poster400x570).append(id).append(title).append(releaseDate).append(poster240x342).append(originalTitle).append(freebase).append(rating).append(preOrder).append(wikipediaId).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof Result) == false) {
//            return false;
//        }
//        Result rhs = ((Result) other);
//        return new EqualsBuilder().append(alternateTitles, rhs.alternateTitles).append(rottentomatoes, rhs.rottentomatoes).append(inTheaters, rhs.inTheaters).append(imdb, rhs.imdb).append(poster120x171, rhs.poster120x171).append(commonSenseMedia, rhs.commonSenseMedia).append(themoviedb, rhs.themoviedb).append(metacritic, rhs.metacritic).append(releaseYear, rhs.releaseYear).append(poster400x570, rhs.poster400x570).append(id, rhs.id).append(title, rhs.title).append(releaseDate, rhs.releaseDate).append(poster240x342, rhs.poster240x342).append(originalTitle, rhs.originalTitle).append(freebase, rhs.freebase).append(rating, rhs.rating).append(preOrder, rhs.preOrder).append(wikipediaId, rhs.wikipediaId).isEquals();
//    }

}
