
package com.example.maglebyz.searchflix.FinalResult;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format implements Serializable
{

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("pre_order")
    @Expose
    private Boolean preOrder;
    private final static long serialVersionUID = -4941949383840222130L;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

}
