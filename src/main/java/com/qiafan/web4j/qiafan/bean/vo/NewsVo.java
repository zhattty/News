package com.qiafan.web4j.qiafan.bean.vo;

import com.qiafan.web4j.qiafan.bean.News;
import com.qiafan.web4j.qiafan.bean.User;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 16:11
 */
public class NewsVo {
    private int like;
    private News news;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }


    @Override
    public String toString() {
        return "NewsVo{" +
                "like=" + like +
                ", news=" + news +
                '}';
    }
}

