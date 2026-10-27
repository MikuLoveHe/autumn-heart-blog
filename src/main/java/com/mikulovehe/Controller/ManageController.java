package com.mikulovehe.Controller;

import com.mikulovehe.DTO.ArticleWithTagsDTO;
import com.mikulovehe.Service.ArticleService;
import com.mikulovehe.Service.ArticleWithTagsService;
import com.mikulovehe.Util.DeleteImageUtil;
import com.mikulovehe.Util.JwtTokenUtil;
import com.mikulovehe.pojo.Result;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/admins")
public class ManageController {

    @Value("${upload.dir}")
    private String UPLOAD_DIR;

    @Autowired
    private ArticleWithTagsService articleWithTagsService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DeleteImageUtil deleteImageUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam(value = "image", required = false) MultipartFile image,
                                              @RequestParam(value = "oldImageUrl", required = false) String oldImageUrl) {
        System.out.println("oldImageUrl:" + oldImageUrl + " image:" + image);

        try {
            // 1. 基础验证
            if (image == null || image.isEmpty()) {
                return ResponseEntity.badRequest().body("旧图片已删除");
            }
            if (!image.getContentType().startsWith("image/")) {
                return ResponseEntity.badRequest().body("仅支持图片文件");
            }
            if (oldImageUrl != null && !oldImageUrl.isEmpty()) {
                //TODO 2
                deleteImageUtil.deleteImage(oldImageUrl);
            }

            // 2. 安全文件名处理
            String fileName = System.currentTimeMillis() + "_" +
                    StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));
            fileName = fileName.replaceAll("[^a-zA-Z0-9.-]", "_");

            // 3. 创建目录
            Path uploadPath = Paths.get(UPLOAD_DIR);
            System.out.println("上传路径："+uploadPath);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 4. 保存文件
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 5. 返回可访问URL
            return ResponseEntity.ok("/uploads/" + fileName);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("上传失败: " + e.getMessage());
        }
    }

    @PostMapping("/upload/delete")
    public ResponseEntity<String> deleteImage(@RequestBody Map<String, String> request) throws IOException {
        String old = request.get("oldImageUrl");
        System.out.println("old:    " + old);
        //TODO 3
        deleteImageUtil.deleteImage(old);
        return ResponseEntity.ok("图片已删除");
    }

    // 获得全部的文章和文章总数量（目前是管理页面用）
    @GetMapping("/article/all")
    public Map<String, Object> getAllArticles() {
        Map<String, Object> result = new HashMap<>();
        result.put("total", articleWithTagsService.selectArticleWithTags().size());
        result.put("data", articleWithTagsService.selectArticleWithTags());

        return result;
    }

    // 编辑文章和标签
    @PutMapping("/article")
    public Result<String> updateArticle(@RequestBody ArticleWithTagsDTO articleWithTags) {
        return Result.success(articleWithTagsService.updateArticleWithTags(articleWithTags));
    }

    // 添加文章和标签
    @PostMapping("/article")
    public Result<String> addArticle(@RequestBody ArticleWithTagsDTO articleWithTags) {
        return Result.success(articleWithTagsService.insertArticleWithTags(articleWithTags));
    }

    @DeleteMapping("/article/{id}")
    public String deleteArticleById(@PathVariable Integer id) throws IOException {
        return articleService.deleteArticleById(id);
    }

    @GetMapping("/auth")
    public Result<String> checkToken(@RequestHeader("Authorization") String token) throws AuthException {

        if (!jwtTokenUtil.validateToken(token.substring(7))) {
            throw new AuthException("无效Token");
        }
        return Result.success("welcome");
    }



}
