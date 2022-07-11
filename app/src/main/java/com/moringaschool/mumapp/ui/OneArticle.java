package com.moringaschool.mumapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.models.ArticleResponse;

public class OneArticle extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_article);
        ArticleResponse articleResponse = (ArticleResponse) getIntent().getSerializableExtra("article");
        String Author = getIntent().getStringExtra("author");
        TextView Title = (TextView) findViewById(R.id.articleTitle);
        TextView author = findViewById(R.id.articleAuthor);
        TextView content = (TextView) findViewById(R.id.articleContent);
        Title.setText(articleResponse.getHeading().toUpperCase());
        author.setText(("Article by "+ Author).toUpperCase());
        content.setText(articleResponse.getArticleContent()+"\n");
    }
}