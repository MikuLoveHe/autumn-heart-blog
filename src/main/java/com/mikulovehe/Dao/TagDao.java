package com.mikulovehe.Dao;

import com.mikulovehe.pojo.Comment;
import com.mikulovehe.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper
public interface TagDao {
    @ResultMap("TagResultMap")
    int insertTag(Tag tag);

    boolean updateTag(Tag tag);

    boolean deleteTag(int id);

    Tag selectTagById(int id);

    List<Tag> selectAllTags();

    List<Tag> selectAllTagName();

    List<String> selectWithTagName();

    void deleteTagsByName(@Param("tagNames") List<String> tagNames);
}
