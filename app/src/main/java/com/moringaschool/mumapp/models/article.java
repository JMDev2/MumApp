package com.moringaschool.mumapp.models;

public class article {
    private  String Author;
    private int AuthorId;

    private String Heading;

    private String ArticleContent;
    private int id;

    public article(int authorId, String heading, String articleContent, int id) {
        AuthorId = authorId;
        Heading = heading;
        ArticleContent = articleContent;
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getArticleContent() {
        return ArticleContent;
    }

    public void setArticleContent(String articleContent) {
        ArticleContent = articleContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
