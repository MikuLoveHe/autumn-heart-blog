package com.mikulovehe.Service.Impl;

import com.mikulovehe.Dao.ArticleDao;
import com.mikulovehe.Dao.ArticleWithTagsDao;
import com.mikulovehe.Dao.TagDao;
import com.mikulovehe.Service.ArticleService;
import com.mikulovehe.Util.DeleteImageUtil;
import com.mikulovehe.pojo.Article;
import com.mikulovehe.Util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mikulovehe.Util.tofArticleAndTagUtil;

import java.io.IOException;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private DeleteImageUtil deleteImageUtil;

    @Autowired
    private ArticleWithTagsDao articleWithTagsDao;

    @Autowired
    private TagDao tagDao;

    @Override
    public String insertArticle(Article article) {
        tofArticleAndTagUtil.tofArticle(article);

        article.setAddTime(nowTime.getTime());
        return articleDao.insertArticle(article) > 0 ? "添加成功" : "添加失败";
    }

    // 删除文章，同时要从本地删除已存放的图片
    // 根据id查询到文章的图片url，再调用删除方法
    @Override
    public String deleteArticleById(int id) throws IOException {
        //TODO 1
        String imageUrl = articleDao.getImageUrlById(id);

        deleteImageUtil.deleteImage(imageUrl);
        // 查询文章的所有标签[1,2,3]
        List<String> tags = articleWithTagsDao.selectArticleWithTagsByArticleId(id).getTagsName();

        // 先删除文章关联的所有标签[1,2,3]
        articleWithTagsDao.deleteArticleAllWithTagsById(id);
        // 删除文章
        String res = articleDao.deleteArticleById(id) ? "删除成功" : "删除失败";

        // 要获取到被删除的标签名，然后查询 文章和标签的关联表里的 所有文章关联的标签，如果还有相同的标签，就不删除标签，如果没有相同标签了，就删除标签
        // 获取当前关联表里所有存在的标签名[2,4,5]
        List<String> allTags = tagDao.selectWithTagName();

        Set<String> setB = new HashSet<>(allTags);
        List<String> tagsNoInAllTags = tags.stream()
                .filter(e -> !setB.contains(e))
                .toList();

        System.out.println("需要被删除的标签: " + tagsNoInAllTags);
        if (!tagsNoInAllTags.isEmpty()) {
            tagDao.deleteTagsByName(tagsNoInAllTags);
        }


        return res;
    }

    @Override
    public String updateArticle(Article article) {
        tofArticleAndTagUtil.tofArticle(article);
        return articleDao.updateArticle(article) ? "修改成功" : "修改失败";
    }

    @Override
    public String selectArticleById(int id) {
        Article article = articleDao.selectArticleById(id);

        if (article == null) {
            return "空";
        }

        return article.toString();
    }

    @Override
    public List<Article> selectAllArticles() {
        return articleDao.selectAllArticles();
    }

    @Override
    public List<Article> selectHomePageArticle(int start, int num) {
        return articleDao.selectHomePageArticle(start, num);
    }

    @Override
    public String cancelGood(int id) {
        return articleDao.cancelGood(id) ? "取消点赞" : "操作失败";
    }

    @Override
    public String good(int id) {
        return articleDao.good(id) ? "点赞成功" : "操作失败";
    }

    @Override
    public Integer getGoodNum(int id) {
        return articleDao.getGoodNum(id);
    }

    @Override
    public Integer totalArticle() {
        return articleDao.countAllArticles();
    }

    @Override
    public Map<String, Integer> totalArticleAndLikes() {
        Map<String, Integer> map = new HashMap<>();
        // 获得文章总数
        int allArticle = articleDao.countAllArticles();
        // 获得全部文章点赞总数
        int totalGoodNum = 0;
        List<Integer> integers = articleDao.selectAllArticleGoodNums();
        for (int integer : integers) {
            totalGoodNum += integer;
        }
        map.put("allArticle", allArticle);
        map.put("totalGoodNum", totalGoodNum);

        return map;
    }


    //取消点赞

}
