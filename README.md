# Autumn Heart · 个人博客系统

一个手动编写的个人博客系统，支持文章、标签、评论、用户与后台管理，使用 JWT 完成登录鉴权，并支持文章封面上传。

项目是大二自学 Spring Boot 期间完成的练手作品，用来把「控制器 → Service → DAO → MyBatis XML → MySQL」这条链路完整走一遍。

## 技术栈

| 层 | 技术 |
|---|---|
| 后端 | Java 21 · Spring Boot 3.4.6 · Spring Web |
| 持久层 | MyBatis 3.0.4（XML Mapper）· MySQL · Druid |
| 鉴权 | JJWT 0.11.5（拦截器校验 Token） |
| 前端 | Vue 3（静态页面）· Axios · 原生 CSS |
| 构建 | Maven |

## 功能

- 文章列表、分页、搜索、详情与点赞
- 标签管理与文章标签关联
- 评论发布与删除
- 用户注册 / 登录，JWT 鉴权
- 后台文章管理、图片上传与删除
- 联系留言

## 项目结构

```
Autumn-Heart/
├── src/main/java/com/mikulovehe/
│   ├── Controller/     # 6 个控制器，36 个接口
│   ├── Service/        # 业务层
│   ├── Dao/            # MyBatis Mapper 接口
│   ├── pojo/ DTO/      # 实体与传输对象
│   ├── Interceptor/    # JWT 拦截器
│   ├── Config/         # Web 配置
│   └── Util/           # JWT、时间、文件工具
├── src/main/resources/
│   ├── Mapper/         # MyBatis XML
│   └── static/         # Vue 3 静态页面
└── pom.xml
```

## 本地运行

前置条件：JDK 21、Maven、MySQL 8+。

1. 创建数据库：

```sql
CREATE DATABASE mikulovehe DEFAULT CHARACTER SET utf8mb4;
```

2. 配置连接（通过环境变量，或直接修改 `application-dev.yml`）：

```bash
export DB_URL='jdbc:mysql://localhost:3306/mikulovehe?useSSL=false&serverTimezone=UTC'
export DB_USERNAME=root
export DB_PASSWORD=your-password
export JWT_SECRET=your-random-secret
```

3. 启动：

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

访问 <http://localhost:9090>。

> 说明：仓库未包含数据库建表脚本，需要根据 `src/main/java/com/mikulovehe/pojo` 与 `src/main/resources/Mapper/*.xml` 自行建表。生产环境请务必通过环境变量注入数据库凭据与 JWT 密钥。

## 说明

- 项目曾是本人早期部署在阿里云上的版本，线上实例已下线。
- 代码为学习和练手性质，未做完整的单元测试与生产级加固。
