
package com.example.maglebyz.searchflix.FinalResult;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriptionWebSource implements Serializable
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
    private final static long serialVersionUID = -5976964344137609221L;

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

}
