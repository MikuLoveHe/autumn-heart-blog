package com.mikulovehe.Util;

import com.mikulovehe.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DeleteImageUtil {

    private final String uploadDir;

    @Autowired
    public DeleteImageUtil(@Value("${upload.dir}") String UPLOAD_DIR) {
        this.uploadDir = UPLOAD_DIR;
    }

    public void deleteImage(String imageUrl) throws IOException {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            System.out.println("删除方法" + imageUrl);
            try {
                // 提取文件名（防止路径注入）
                String fileName = Paths.get(imageUrl).getFileName().toString();
                Path filePath = Paths.get(uploadDir , fileName);

                System.out.println(filePath);

                if (Files.exists(filePath)) {
                    Files.delete(filePath);
                    System.out.println("已删除旧图片: " + fileName);
                }
            } catch (Exception e) {
                System.err.println("旧图片删除失败: " + e.getMessage());
                // 不阻断主流程，仅记录日志
            }
        }
    }




    /*@Value("${upload.dir}")
    private static String UPLOAD_DIR;


    public static void deleteImage(String oldImageUrl) throws IOException {
        System.out.println("删除方法" + oldImageUrl);
        try {
            // 提取文件名（防止路径注入）
            String fileName = Paths.get(oldImageUrl).getFileName().toString();
            Path filePath = Paths.get(UPLOAD_DIR + "/" + fileName);

            System.out.println(filePath);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("已删除旧图片: " + fileName);
            }
        } catch (Exception e) {
            System.err.println("旧图片删除失败: " + e.getMessage());
            // 不阻断主流程，仅记录日志
        }

    }*/
}
