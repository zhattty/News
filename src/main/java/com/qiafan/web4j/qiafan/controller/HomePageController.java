package com.qiafan.web4j.qiafan.controller;

import com.qiafan.web4j.qiafan.bean.News;
import com.qiafan.web4j.qiafan.bean.User;
import com.qiafan.web4j.qiafan.bean.vo.NewsVo;
import com.qiafan.web4j.qiafan.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 15:52
 */
@Controller
public class HomePageController {
    @Autowired
    NewsService newsService;

    @RequestMapping("home")
    public String forwardToHomepage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user!=null){
            model.addAttribute("user",user);
        }else {
            model.addAttribute("pop",1);
        }
        List<News> newsList =  newsService.listNews();
        ArrayList<NewsVo> newsVos = new ArrayList<>();
        if (newsList != null){
            for (News news : newsList) {
                NewsVo newsVo = new NewsVo();
                newsVo.setNews(news);
                newsVo.setLike(0);
                newsVos.add(newsVo);
            }
        }
        model.addAttribute("vos",newsVos);
        return "home";
    }
}
