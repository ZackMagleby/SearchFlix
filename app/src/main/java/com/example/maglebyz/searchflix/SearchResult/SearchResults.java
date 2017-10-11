
package com.example.maglebyz.searchflix.SearchResult;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class SearchResults implements Serializable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    private final static long serialVersionUID = 3675859071306044585L;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("results", results).toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(results).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof SearchResults) == false) {
//            return false;
//        }
//        SearchResults rhs = ((SearchResults) other);
//        return new EqualsBuilder().append(results, rhs.results).isEquals();
//    }

}
