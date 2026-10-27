package com.mikulovehe.Service.Impl;

import com.mikulovehe.DTO.ArticleWithTagsDTO;
import com.mikulovehe.Dao.ArticleDao;
import com.mikulovehe.Dao.ArticleWithTagsDao;
import com.mikulovehe.Dao.TagDao;
import com.mikulovehe.Service.ArticleWithTagsService;
import com.mikulovehe.pojo.Article;
import com.mikulovehe.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mikulovehe.Util.nowTime;
import com.mikulovehe.Util.tofArticleAndTagUtil;


import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleWithTagsServiceImpl implements ArticleWithTagsService {
    @Autowired
    private ArticleWithTagsDao articleWithTagsDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagDao tagDao;

    @Override
    public List<ArticleWithTagsDTO> selectArticleWithTagsByPage(int start, int num) {
        start = (start - 1) * num;
        return articleWithTagsDao.selectArticleWithTagsByPage(start, num);
    }

    // 根据文章id查找文章和对应的标签（并且，增加一个阅读量）
    @Override
    public ArticleWithTagsDTO selectArticleWithTagsById(int id) {
        System.out.println("根据文章id查找文章和对应的标签：" + articleWithTagsDao.selectArticleWithTagsByArticleId(id));
        articleDao.addLookNum(id);
        return articleWithTagsDao.selectArticleWithTagsByArticleId(id);
    }

    @Override
    public List<ArticleWithTagsDTO> selectArticleWithTags() {
        return articleWithTagsDao.selectArticleWithTags();
    }

    // 添加文章和标签
    @Override
    public String insertArticleWithTags(ArticleWithTagsDTO awt) {
        System.out.println("检查添加数据");
        // 检查文章这三个值是否符合要求
        tofArticleAndTagUtil.tofArticle(new Article(awt.getArticleTitle(), awt.getArticleContext(), awt.getArticleExcerpt(),awt.getAuthor()));
        awt.getTagsName().forEach(tagName -> {
            tofArticleAndTagUtil.tofTags(new Tag(tagName));
        });
        String result = "";
        List<Tag> tagList = tagDao.selectAllTagName();
        try {
            // 添加文章
            Article article = new Article(awt.getArticleTitle(), nowTime.getTime(),
                    awt.getArticleContext(), awt.getArticleImgUrl(), awt.getArticleExcerpt(),awt.getAuthor());

            // 添加文章到数据库
            result = articleDao.insertArticle(article) > 0 ? "文章添加成功" : "文章添加失败";

            // 添加多个标签
            for (int i = 0; i < awt.getTagsName().size(); i++) {
                boolean flag = false;
                // 遍历将要添加的标签名字
                for (Tag value : tagList) {
                    //遍历数据库里所有的标签名字
                    String tagName = value.getName();
                    // 如果将要添加的标签已存在
                    if (tagName.equals(awt.getTagsName().get(i))) {
                        result = articleWithTagsDao.connectArticleAndTags(article.getId(), value.getId()) ? "文章和标签关联成功" : "文章和标签关联失败";
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    Tag tag = new Tag(awt.getTagsName().get(i), nowTime.getTime());

                    // 添加新标签到数据库
                    result = tagDao.insertTag(tag) > 0 ? "标签添加成功" : "标签添加失败";

                    result = articleWithTagsDao.connectArticleAndTags(article.getId(), tag.getId()) ? "文章和标签关联成功" : "文章和标签关联失败";
                }


            }

            return result;
        } catch (Exception e) {

            throw new RuntimeException(result, e);
        }
    }

    // 更新文章和标签
    @Override
    public String updateArticleWithTags(ArticleWithTagsDTO awt) {
        System.out.println("检查更新数据");
        System.out.println(awt.getArticleTitle() + "  , " + awt.getArticleContext() + " ,  " + awt.getArticleExcerpt());
        // 检查文章这三个值是否符合要求
        tofArticleAndTagUtil.tofArticle(new Article(awt.getArticleTitle(), awt.getArticleContext(), awt.getArticleExcerpt(),awt.getAuthor()));
        awt.getTagsName().forEach(tagName -> {
            tofArticleAndTagUtil.tofTags(new Tag(tagName));
        });
        System.out.println("检查通过");
        String result = "";
        // 数据库已存在的所有标签
        List<Tag> tagList = tagDao.selectAllTagName();

        try {
            // 修改文章
            result = articleDao.updateArticle(new Article(awt.getArticleId(), awt.getArticleTitle(),
                    awt.getArticleContext(), awt.getArticleImgUrl(), awt.getArticleExcerpt())) ? "修改成功" : "修改失败";

            /*
             * 根据id获得(这篇文章的所有已关联标签)（集合a），获取(将要修改的awt.getTagsName()标签)（集合b）
             * 删除原来的文章标签，把集合b的标签全部和文章关联起来
             *      要判断数据库里是否已存在将要关联的标签
             * 获得集合a有，集合b没有的标签集合c
             * 判断集合c里的标签是否有其它文章关联，如果有就留下，如果没有就删除标签
             * */

            List<String> listA = articleWithTagsDao.selectArticleTagById(awt.getArticleId());
            List<String> listB = awt.getTagsName();

            // 根据id删除一篇文章所有的标签
            int deleteRows = articleWithTagsDao.deleteArticleAllWithTagsById(awt.getArticleId());
            result = deleteRows >= 0 ? "删除标签成功，删除" + deleteRows + "条标签数据" : "删除标签失败";
            System.out.println(result);

            // 添加多个标签 遍历将要添加的标签
            // 从新关联文章和标签，添加新标签的操作
            for (int i = 0; i < listB.size(); i++) {
                boolean flag = false;
                // 遍历数据库的所有标签
                for (Tag value : tagList) {
                    String tagName = value.getName();
                    // 如果数据库里已经有将要添加的这个标签，就直接关联,然后要开始找下一个将添加的标签
                    if (tagName.equals(awt.getTagsName().get(i))) {
                        result = articleWithTagsDao.connectArticleAndTags(awt.getArticleId(), value.getId()) ? "文章和标签关联成功" : "文章和标签关联失败";
                        System.out.println(result);
                        flag = true;
                        // 如果这个标签已存在，直接开始下一轮循环，不进行添加新标签的操作
                        break;
                    }
                }

                if (!flag) {
                    // 数据库里没有将要添加的新标签时，添加新的标签
                    Tag tag = new Tag(awt.getTagsName().get(i), nowTime.getTime());
                    // 添加标签到数据库
                    result = tagDao.insertTag(tag) > 0 ? "标签添加成功" : "标签添加失败";
                    System.out.println(result);
                    result = articleWithTagsDao.connectArticleAndTags(awt.getArticleId(), tag.getId()) ? "文章和标签关联成功" : "文章和标签关联失败";
                    System.out.println(result);
                }


            }


            // 获得集合a有，集合b没有的标签集合c(旧标签)
            List<String> listC = new ArrayList<>(listA);
            listC.removeAll(listB);

            // 如果没有旧标签，就直接跳过
            if (!listC.isEmpty()) {
                System.out.println("集合c：" + listC);

                // 查询旧标签还有没有其它文章使用
                List<String> unUsedTagList = articleWithTagsDao.selectUnusedTags(listC);
                tagDao.deleteTagsByName(unUsedTagList);
            }


            return result;
        } catch (Exception e) {
            throw new RuntimeException(result, e);
        }
    }

    // 条件查询,搜索框。要返回文章和文章数量
    @Override
    public Map<String, Object> searchArticlesCondition(String keyword, int page, int pageSize) {
        page = (page - 1) * pageSize;

        System.out.println("条件查询到的文章。条件：keyword：" + keyword + "，page：" + page + "，pageSize：" + pageSize);
        int total = articleWithTagsDao.countArticlesCondition(keyword);
        System.out.println("总数：" + total);
        List<Integer> articleIds = articleWithTagsDao.searchArticleIdsCondition(keyword, page, pageSize);
        if (articleIds.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("total", 0);
            map.put("data", Collections.emptyList());
            return map;
        }
        List<ArticleWithTagsDTO> a = articleWithTagsDao.selectArticlesWithTagsByIds(articleIds);
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("data", a);
        return map;
    }
}


/*
 * 添加了文章和标签后，还没有把文章何标签联系
 *
 *
 *
 * */
