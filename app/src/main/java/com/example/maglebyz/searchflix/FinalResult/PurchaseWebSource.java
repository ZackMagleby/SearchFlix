
package com.example.maglebyz.searchflix.FinalResult;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchaseWebSource implements Serializable
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
    @SerializedName("formats")
    @Expose
    private List<Format> formats = null;
    private final static long serialVersionUID = -5526090105516329852L;

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

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

}
