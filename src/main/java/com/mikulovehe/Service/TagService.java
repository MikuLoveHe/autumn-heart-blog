package com.mikulovehe.Service;

import com.mikulovehe.pojo.Tag;

import java.util.List;

public interface TagService {
    int insertTag(Tag tag);
    String deleteTagById(int id);
    String updateTag(Tag tag);
    String findTagById(int id);
    List<Tag> findAllTags();
}
