package com.qiafan.web4j.qiafan.service.impl;

import com.qiafan.web4j.qiafan.bean.News;
import com.qiafan.web4j.qiafan.mapper.NewsMapper;
import com.qiafan.web4j.qiafan.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 16:24
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> listNews() {
        return newsMapper.listNews();
    }
}
