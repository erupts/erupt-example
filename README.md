<p align="center"><img src="https://www.erupt.xyz/icon.svg" height="150" alt="logo"/></p>
<h1 align="center">Erupt Engine &nbsp;🚀&nbsp; Example</h1>
<h3 align="center">零前端代码，几行 Java 注解，实现通用数据平台</h3>
<h3 align="center"><a href="https://www.erupt.xyz" target="_blank">https://www.erupt.xyz</a></h3>

---

<p align="center">
    <a href="https://www.erupt.xyz" target="_blank"><img src="https://img.shields.io/badge/Erupt-2.2.0-brightgreen" alt="Erupt 2.2.0"></a>
    <a href="https://spring.io/projects/spring-boot"><img src="https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F.svg" alt="Spring Boot 3.5"></a>
    <a href="https://adoptium.net/"><img src="https://img.shields.io/badge/JDK-17+-green.svg" alt="JDK 17+"></a>
    <a href="./LICENSE"><img src="https://img.shields.io/badge/license-MIT-blue" alt="license MIT"></a>
    <a href="https://gitee.com/erupt/erupt"><img src="https://gitee.com/erupt/erupt/badge/star.svg?theme=dark" alt="Gitee star"></a>
    <a href="https://github.com/erupts/erupt"><img src="https://img.shields.io/github/stars/erupts/erupt?style=social" alt="GitHub stars"></a>
</p>

<p align="center">
    <a href="https://github.com/erupts/erupt">GitHub</a> &nbsp;|&nbsp;
    <a href="https://gitee.com/erupt/erupt">Gitee</a> &nbsp;|&nbsp;
    <a href="https://www.erupt.xyz" target="_blank">官网</a> &nbsp;|&nbsp;
    <a href="https://demo.erupt.xyz" target="_blank">在线体验</a> &nbsp;|&nbsp;
    <a href="https://start.erupt.xyz" target="_blank">项目生成器</a> &nbsp;|&nbsp;
    <a href="https://docs.erupt.xyz" target="_blank"><b>使用文档</b></a>
</p>

<p align="center">QQ 交流群：<a href="https://jq.qq.com/?_wv=1027&k=MCd4plZ0">821389129 🔥</a></p>

---

## 项目简介

这是 [Erupt](https://github.com/erupts/erupt) 框架的官方示例工程，用最少的代码演示 Erupt 的核心能力：

- **注解即页面** —— 一个 `@Erupt` 实体类，自动生成表格、表单、树、查询、导入导出等完整后台功能
- **丰富的组件** —— 输入框、下拉、日期、附件、富文本、地图、自动完成、级联选择等全部内置
- **业务扩展点** —— `@DataProxy` 服务层钩子、自定义按钮操作、动态下拉数据源、行级权限
- **多种页面类型** —— 表格、树、按钮、外链、新页签、自定义模板（Velocity / Freemarker / Thymeleaf）
- **扩展模块** —— 已集成定时任务、系统监控、Magic API、AI 助手、Web 终端、WebSocket、云节点等模块

## 快速开始

### 环境要求

| 依赖 | 版本 |
|------|------|
| JDK | 17+ |
| Maven | 3.6+ |
| Spring Boot | 3.5.x |
| Erupt | 2.2.0 |

### 三步启动

1. **配置数据库（可选）**
   默认使用内嵌 H2 数据库，开箱即用。如需切换到 MySQL、PostgreSQL、Oracle 等，修改 `src/main/resources/application.yml` 中的 `spring.datasource` 即可。
2. **运行入口类**
   执行 `com.example.demo.ExampleApplication` 的 `main` 方法，表结构会自动创建，无需导入 SQL。
3. **访问系统**
   浏览器打开 <http://localhost:8080>，使用默认账号登录：

   | 用户名 | 密码 |
   |--------|------|
   | erupt | erupt |

> 命令行启动：`mvn spring-boot:run`

## 功能体验

登录后进入 **系统管理 → 菜单维护**，点击 **新增**，将下方示例类配置为菜单即可体验。每一项对应一种菜单类型，填写「类型值」时使用类名或路径。

### 基础示例

| 菜单名称 | 菜单类型 | 类型值 | 说明 |
|----------|----------|--------|------|
| 入门示例 | 表格 | `Simple` | 最简单的实体定义 |
| 文章管理 | 表格 | `Article` | 富文本、附件、发布流程 |
| 树示例 | 树 | `TreeView` | 树形结构维护 |
| 组件示例 | 表格 | `Component` | 各类组件与事件代理用法 |
| 复杂示例 🌟 | 表格 | `Complex` | 动态下拉、自定义按钮、一对多、弹窗等高级功能，建议仔细研究 |
| 按钮权限 | 按钮 | `ComplexBtn` | 控制 Complex「多行操作」的按钮权限 |
| 服务层逻辑扩展 | 表格 | `CurdDemo` | `@DataProxy` 扩展增删改查 |

### 页面与模板

| 菜单名称 | 菜单类型 | 类型值 | 说明 |
|----------|----------|--------|------|
| 链接 | 链接 | `https://www.erupt.xyz` | 内嵌外部页面 |
| 新页面 | 新页签 | `https://github.com/erupts/erupt` | 新标签页打开 |
| 自定义页面 | 模板 | `erupt.html` | 纯静态自定义页面 |
| velocity | 模板 | `velocity.vm` | Velocity 服务端渲染 |
| freemarker | 模板 | `freemarker.ftl` | Freemarker 服务端渲染 |
| thymeleaf | 模板 | `thymeleaf.html` | Thymeleaf 服务端渲染（需引入 thymeleaf 依赖） |

### 博客示例

| 菜单名称 | 菜单类型 | 类型值 |
|----------|----------|--------|
| 博客管理 | 表格 | `Blog` |
| 博客类型 | 树 | `BlogCategory` |
| 博客标签 | 树 | `BlogTag` |
| 图片管理 | 表格 | `Pictures` |
| 图床分类 | 树 | `PicturesCategory` |
| 友情链接 | 表格 | `FriendlyLink` |

### 商城示例

| 菜单名称 | 菜单类型 | 类型值 |
|----------|----------|--------|
| 商品管理 | 表格 | `Goods` |
| 商品分类 | 树 | `GoodsCategory` |
| 优惠券管理 | 表格 | `Coupon` |

## 目录结构

```
erupt-example
├── pom.xml                                  依赖配置（erupt.version 统一管理版本）
├── src/main/java/com/example/demo
│   ├── ExampleApplication.java              启动入口
│   ├── action/                              模板页面数据绑定
│   │   ├── FreemarkerAction.java
│   │   ├── ThymeleafAction.java
│   │   └── VelocityTplAction.java
│   ├── controller/
│   │   └── TestController.java              使用 EruptDao 编写普通接口
│   ├── handler/
│   │   ├── AutoCompleteHandlerImpl.java     自动完成数据源
│   │   └── ComponentDataProxy.java          事件代理示例
│   └── model/
│       ├── Simple.java                      入门示例
│       ├── Article.java                     文章示例
│       ├── TreeView.java                    树视图
│       ├── Component.java                   组件示例
│       ├── CurdDemo.java                    @DataProxy 服务层扩展
│       ├── complex/                         复杂示例（动态下拉、按钮、一对多、弹窗）
│       │   └── fun/                         ComplexDataProxy、OperationHandlerImpl
│       ├── blog/                            博客示例
│       └── mall/                            商城示例
├── src/main/resources
│   ├── application.yml                      应用配置
│   ├── public/                              前端静态资源
│   │   ├── app.js                           前端配置（标题、地图 key 等）
│   │   ├── app.css                          自定义样式
│   │   ├── home.html                        首页
│   │   └── favicon.ico
│   └── tpl/                                 自定义页面与模板引擎示例
│       ├── erupt.html
│       ├── freemarker.ftl
│       ├── thymeleaf.html
│       └── velocity/velocity.vm
└── src/test/java/com/example/demo
    └── ExampleApplicationTests.java         EruptDao 查询示例，可直接运行单个方法
```

## 常见问题

- **图片上传失败** —— 修改 `application.yml` 中的 `erupt.upload-path` 为本机可写目录
- **地图组件不可用** —— 修改 `public/app.js` 中 `eruptSiteConfig.amapKey` 为自己申请的高德 key
- **`HyperModel` 的作用** —— 继承后自动维护创建时间、修改时间、创建人、修改人字段

## 相关链接

- 使用文档：<https://docs.erupt.xyz>
- 快速上手：<https://docs.erupt.xyz/guide/quick-start>
- 模块列表：<https://www.erupt.xyz/#!/module>
- API 文档：<https://javadoc.erupt.xyz>
- 在线体验：<https://demo.erupt.xyz>
