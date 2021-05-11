
<p align="center"><img src="https://www.erupt.xyz/demo/erupt.svg" height="150" alt="logo"/></p>
<h1 align="center"> Erupt Framework &nbsp; 🚀 &nbsp; 框架演示代码 </h1>
<h3 align="center">零前端代码，几行 Java 注解，搞定后台管理系统</h3>
<h3 align="center"><a href="https://erupt.xyz" target="_blank">https://www.erupt.xyz</a></h3>

---

<p align="center">
    <a href="https://www.erupt.xyz" target="_blank"><img src="https://img.shields.io/badge/Erupt-Framework-brightgreen" alt="Erupt Framework"></a>
    <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"><img src="https://img.shields.io/badge/JDK-8+-green.svg" alt="jdk 8+"></a>
    <a href="./LICENSE"><img src="https://img.shields.io/badge/license-Apache%202-blue" alt="license Apache 2.0"></a>
    <a href="https://gitee.com/erupt/erupt"><img src="https://gitee.com/erupt/erupt/badge/star.svg?theme=dark" alt="Gitee star"></a>
    <a href="https://gitee.com/erupt/erupt"><img src="https://gitee.com/erupt/erupt/badge/fork.svg?theme=dark" alt="Gitee fork"></a>
    <a href="https://github.com/erupts/erupt"><img src="https://img.shields.io/github/stars/erupts/erupt?style=social" alt="GitHub stars"></a>
    <a href="https://github.com/erupts/erupt"><img src="https://img.shields.io/github/forks/erupts/erupt?style=social" alt="GitHub forks"></a>
    <a href="https://github.com/erupts/erupt"><img src="https://img.shields.io/github/repo-size/erupts/erupt" alt="size"></a>
</p>

<p align="center">
    <a href="https://github.com/erupts/erupt">Github 仓库</a> &nbsp; | &nbsp; 
    <a href="https://gitee.com/erupt/erupt">Gitee 仓库</a> &nbsp; | &nbsp; 
    <a href="https://www.erupt.xyz" target="_blank">官方网站</a> &nbsp; | &nbsp; 
    <a href="https://www.yuque.com/yuepeng/erupt/bdiq6o" target="_blank">贡献指南</a> &nbsp; | &nbsp; 
    <a href="https://www.erupt.xyz/demo" target="_blank">在线体验</a> &nbsp; | &nbsp; 
    <a href="https://www.yuque.com/yuepeng/erupt" target="_blank"><b>使用文档</b></a>
</p>

<p align="center">
    QQ交流群：<a href="https://jq.qq.com/?_wv=1027&k=MCd4plZ0">821389129 🔥</a>
</p>

### 使用方法：   
1. 前往 src/main/resources/application.yml 修改数据库连接配置
2. 前往 src/main/java/DemoApplication 运行main方法即可（无需sql文件，表结构自动创建）
3. src/main/resources/application.yml 其他配置

默认用户名密码： erupt / erupt


### 将model下的类添加到菜单：

启动成功后，前往系统管理 → 菜单维护 → 新增，将已定义好的演示类添加到菜单中，填写数据如下：
  
| 菜单名称 |  菜单类型  | 类型值（类名） | 描述 |
|  ---- |  ----  | ----  | ----  |
| 入门示例 | 表格 | Simple |  |
| 文章管理 | 表格 | Article |  |
| 树示例 | 树 | TreeView |  |
| 组件示例 | 表格 | Component | 各类组件与事件代理使用方法 |
| 复杂示例 | 表格 | Complex | 动态下拉列表与定义按钮等功能 |
| 按钮权限 | 按钮 | ComplexBtn | 控制 Complex '多行操作'的按钮权限 |
| **服务层逻辑扩展** | 表格 | CURDExtension | @DataProxy（扩展CURD） |
|  ---- |  ----  | ----  | ----  |
| 链接 | 链接 | https://www.erupt.xyz |  |
| 新页面 | 新页签 | https://github.com/erupts/erupt |  |
| 自定义页面 | 模板 | erupt.html | 自定义页面 |
| amis | 模板 | amis.html | 基于百度 amis 开发的自定义页面 |
| velocity | 模板 | velocity.vm |  Velocity服务端渲染的页面 |
| freemarker | 模板 | freemarker.ftl | Freemarker服务端渲染的页面 |
| thymeleaf | 模板 | thymeleaf.html | Thymeleaf服务端渲染的页面（请提前导入thymeleaf jar） |
|  ---- |  ----  | ----  | ----  |
| 博客管理 | 表格 | Blog |  |
| 博客类型 | 树 | BlogCategory |  |
| 博客标签 | 树 | BlogTag |  |
| 友情链接 | 表格 | FriendlyLink |  |
|  ---- |  ----  | ----  | ----  |
| 商品管理 | 表格 | Goods |  |
| 商品分类| 树 | GoodsCategory |  |
| 优惠券管理| 表格 | Coupon |  |

**配置项说明**
> 编码：确保唯一即可，建议是字母


### 常见问题
+ 如果图片上传失败请前往 application.yml 修改 erupt.uploadPath 配置
+ 地图组件无法使用请前往 app.js 修改 eruptSiteConfig.amapKey 的值
+ 继承HyperModel的作用，可帮助管理，创建时间，修改时间，修改人，更新人字段

### 目录说明
```lua
erupt-example
├── src
     ├── main.java -- 源码
           └── com.example.demo -- 包名
                ├── ExampleApplication   -- 入口类
                ├── action -- 自定义页面数据绑定与路由转换器
                ├── dao
                     └──  ArticleRepository  -- 使用对文章对象的增删改查封装，使用方式与Mybatis-Plus大同小异，具体调用详见 ExampleApplicationTests
                ├── handler
                     ├──  AutoCompleteHandlerImpl  -- 自动完成示例
                     ├──  ComponentDataProxy       -- 事件代理代码示例
                     └──  OperationHandlerImpl     -- 操作按钮处理类
                └── model
                     ├──  blog  -- 博客示例包
                     ├──  mall  -- 商城示例包
                     ├──  Article  -- 文章示例
                     ├──  Complex  -- 复杂示例
                     ├──  ComplexOperator  -- 复杂示例按钮表单
                     ├──  Componen -- 组件示例
                     ├──  Simple   -- 基本示例
                     └──  TreeView -- 树视图
     ├── test.java -- 测试包
           └── com.example.demo -- 包名
                └──  ExampleApplicationTests  -- 包含调用 ArticleRepository 演示代码，直接点击运行单个方法即可
     └── resources -- 配置包
           ├── application.yml -- 后台配置
           ├── tpl
                ├── erupt.html -- 自定义页面
                ├── amis.html -- 基于百度amis开发的页面
                └── xxxx.html -- 使用模板引擎渲染
           └── public
                ├── app.css    -- 前端样式
                ├── app.js     -- 前端配置
                └── home.html  -- 首页样式
└── pom.xml -- 依赖配置
```