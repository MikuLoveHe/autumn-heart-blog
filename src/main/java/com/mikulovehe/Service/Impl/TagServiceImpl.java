package com.mikulovehe.Service.Impl;

import com.mikulovehe.Dao.TagDao;
import com.mikulovehe.Service.TagService;
import com.mikulovehe.pojo.Tag;
import com.mikulovehe.Util.nowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public int insertTag(Tag tag) {
        tofTag(tag);

        tag.setAddTime(nowTime.getTime());

        return tagDao.insertTag(tag);
    }

    @Override
    public String deleteTagById(int id) {
        return tagDao.deleteTag(id) ? "标签删除成功" : "标签删除失败";
    }

    @Override
    public String updateTag(Tag tag) {
        tofTag(tag);
        return tagDao.updateTag(tag) ? "标签更新成功" : "标签更新失败";
    }

    @Override
    public String findTagById(int id) {
        return tagDao.selectTagById(id).toString();
    }

    @Override
    public List<Tag> findAllTags() {
        return tagDao.selectAllTags();
    }

    public void tofTag(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("标签不能位空");
        } else if (tag.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("标签内容不能位空");
        } else if (tag.getName().length() > 50) {
            throw new IllegalArgumentException("标签内容不能超过50位字符");
        }
    }

}
