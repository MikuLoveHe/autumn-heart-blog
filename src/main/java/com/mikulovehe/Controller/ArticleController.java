package com.mikulovehe.Controller;


import com.mikulovehe.DTO.ArticleWithTagsDTO;
import com.mikulovehe.Dao.ArticleWithTagsDao;
import com.mikulovehe.Service.ArticleService;
import com.mikulovehe.Service.ArticleWithTagsService;
import com.mikulovehe.pojo.Article;
import com.mikulovehe.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleWithTagsService articleWithTagsService;

    // 根据id获取文章内容，并且增加一个阅读数
    @GetMapping("/{id}")
    public ArticleWithTagsDTO getArticleById(@PathVariable Integer id) {
        return articleWithTagsService.selectArticleWithTagsById(id);
    }

    // 首页获取文章
    @GetMapping
    public List<ArticleWithTagsDTO> getHomePageArticle(@RequestParam("start") int start, @RequestParam("num") int num) {
        return articleWithTagsService.selectArticleWithTagsByPage(start, num);
    }

    // 取消点赞
    @DeleteMapping("/{id}/like")
    public String cancelGood(@PathVariable int id) {
        return articleService.cancelGood(id);
    }

    // 点赞
    @PostMapping("/{id}/like")
    public String good(@PathVariable int id) {
        return articleService.good(id);
    }

    //更新点赞量
    @GetMapping("/{id}/like")
    public Integer getGoodNum(@PathVariable int id) {
        return articleService.getGoodNum(id);
    }

    // 需要获得文章总数和所有文章的点赞总数
    @GetMapping("/totalArticleAndLikes")
    public Map<String, Integer> totalArticleAndLikes() {
        return articleService.totalArticleAndLikes();
    }


    // 根据标签或标题条件查询文章
    @GetMapping("/search")
    public Map<String, Object> searchArticlesCondition(@RequestParam("keyword") String keyword, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        return articleWithTagsService.searchArticlesCondition(keyword, page, pageSize);
    }

    // 等后面把管理页面的展示方式改后再把路径换成all
    // 要获得查询到的文章，和全部文章的总数
    @GetMapping("/allForPage")
    public Map<String, Object> getArticleForPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        Map<String, Object> result = new HashMap<>();
        result.put("total", articleWithTagsService.selectArticleWithTags().size());
        result.put("data", articleWithTagsService.selectArticleWithTagsByPage(page, pageSize));
        System.out.println("全部文章信息");
        articleWithTagsService.selectArticleWithTagsByPage(page, pageSize).forEach(System.out::println);
        return result;
    }

}
