<p align="center"><img src="./erupt-web/src/main/resources/public/erupt.svg" height="150" alt="logo"/></p>
<h1 align="center"> Erupt 项目演示代码 </h1>

---

[码云仓库](https://gitee.com/erupt/erupt) &nbsp; | &nbsp; [github仓库](https://github.com/erupts/erupt) &nbsp; | &nbsp; 
[项目官网](https://www.erupt.xyz) &nbsp; | &nbsp; [使用文档](https://www.yuque.com/yuepeng/erupt) &nbsp; | &nbsp; 
[JavaDoc](https://apidoc.gitee.com/erupt/erupt/) &nbsp; | &nbsp; [环境搭建](https://www.yuque.com/yuepeng/erupt/tpq1l9) &nbsp; | &nbsp; 
[代码演示](https://www.erupt.xyz/#!/contrast) &nbsp; | &nbsp; [在线体验](https://www.erupt.xyz/demo)

使用方法：   
1. 前往 src/main/resources/application.yml 修改数据库连接配置
2. 前往 src/main/java/DemoApplication 运行main方法即可


目录说明
```lua
erupt-example
├── src.main
     ├── java -- 代码包
           └── com.example.demo
                ├── DemoApplication   -- 入口类
                └── model
                     ├──  DemoHyper   -- 复杂的示例
                     ├──  DemoSimple  -- 简单的示例
                     ├──  DemoTree    -- 树视图示例
                     └──  OperationHandlerImpl -- 按钮操作方法实现
     └── resources -- 配置包
           ├── application.yml -- 后台配置
           └── public
                ├── app.css    -- 前端样式
                ├── app.js     -- 前端配置
                └── home.html  -- 首页样式
└── pom.xml -- 依赖配置
```