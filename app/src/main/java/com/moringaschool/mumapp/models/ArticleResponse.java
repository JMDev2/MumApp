package com.moringaschool.mumapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleResponse {

    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("AuthorId")
    @Expose
    private Integer authorId;
    @SerializedName("Heading")
    @Expose
    private String heading;
    @SerializedName("ArticleContent")
    @Expose
    private String articleContent;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ArticleResponse() {
    }

    /**
     * 
     * @param heading
     * @param author
     * @param articleContent
     * @param id
     * @param authorId
     */
    public ArticleResponse(String author, Integer authorId, String heading, String articleContent, Integer id) {
        super();
        this.author = author;
        this.authorId = authorId;
        this.heading = heading;
        this.articleContent = articleContent;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
