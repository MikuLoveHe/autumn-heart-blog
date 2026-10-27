package com.mikulovehe.Controller;

import com.mikulovehe.Service.TagService;
import com.mikulovehe.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/{id}")
    public String findTagById(@PathVariable int id) {
        return tagService.findTagById(id);
    }

    @GetMapping
    public List<Tag> findAllTags() {
        return tagService.findAllTags();
    }

    @PostMapping
    public String addTag(@RequestBody Tag tag) {
        return tagService.insertTag(tag) > 0 ? "添加成功" : "添加失败";
    }

    @DeleteMapping("/{id}")
    public String deleteTag(@PathVariable int id) {
        return tagService.deleteTagById(id);
    }

    @PutMapping
    public String updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }

}



// 把输入标签的框去掉，展示标签的留下
// 搞个按钮“选择标签”，点击按钮后弹出一个竖着的长方形框，然后左上角有个搜索标签，左下角有个返回，右上角有个添加标签的输入框右边是添加按钮。按下按钮后会发送axios.post请求然后把标签添加到数据库后，可不可以直接把这个添加的标签展示出来，不用用户再去找了。添加的时候，还要防止标签名与数据库里已经存在的标签名重复
// 这个页面就用来展示标签，展示内容有标签名称，标签添加时间，后面还有对没有添加的标签有选择的按钮和编辑，对已选中的标签有取消的按钮。点击选择或取消按钮后，直接在展示标签的地方变化
// 点击标签的编辑按钮后，在编辑按钮上出现一个类似聊天气泡（下面尖尖的那种）的比较小的框，里面有标签名的输入框，和保存、取消按钮。按下保存后会发送axios.put请求
// 分页查询，一页展示十行
// 可以多选标签添加取消