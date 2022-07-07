
package com.moringaschool.mumapp.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("article_response")
    @Expose
    private List<ArticleResponse> articleResponse = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param copyright
     * @param articleResponse
     * @param hasMore
     * @param numResults
     * @param status
     */
    public Response(String status, String copyright, Boolean hasMore, Integer numResults, List<ArticleResponse> articleResponse) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.hasMore = hasMore;
        this.numResults = numResults;
        this.articleResponse = articleResponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<ArticleResponse> getArticleResponse() {
        return articleResponse;
    }

    public void setArticleResponse(List<ArticleResponse> articleResponse) {
        this.articleResponse = articleResponse;
    }

}
