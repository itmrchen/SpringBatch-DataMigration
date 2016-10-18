# SpringBatch-DataMigration SpringBatch数据迁移项目
- **项目简介：**   
主要解决两库的两个表数据迁移和同步问题（两个表的字段可以不一致，只要知道对应关系及转化规则即可），曾经测试过350万数据10分钟内迁移完毕
- **相关技术：**   
mybatis、springBatch、mysql、quartz、spring、springMVC
- **部署说明：**   
本项目为两个数据库，由一个数据库的表向另外一个数据库的表做数据迁移，其中数据库脚本在：/src/main/resources/sql/下面（其中data_rep中的表要求创建顺序，有依赖）
- **项目功能：**   
1.本项目运行在tomcat容器中，主要功能为从spring_batch_left库的user_from表抓取数据，之后批量插入到spring_batch_right库的user_to表   
2.应用quartz对job进行定时触发（目前设置的定时为每隔一分钟执行一次，目前定时服务已注释掉）    
3.除了定时触发功能，还可以通过项目的index.jsp页面发起批处理job    
4.2016-10-18-将原始的使用Map作为仓库修改为使用数据库来作为仓库，新增了data_rep及下面的表，同时引入相关数据源    
