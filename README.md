# SpringBatch-DataMigration
SpringBatch数据迁移项目</br>
（1）项目简介：主要解决两库的两个表数据迁移和同步问题，曾经测试过350万数据10分钟内迁移完毕</br>
（2）相关技术：mybatis、springBatch、mysql、quartz</br>
（3）部署说明：本项目为两个数据库，由一个数据库的表向另外一个数据库的表做数据迁移，其中数据库脚本在：/src/main/resources/sql/下面</br>
（4）项目功能：本项目运行在tomcat容器中，主要功能为从spring_batch_left库的user_from表抓取数据，之后批量插入到spring_batch_right库的user_to表，并应用quartz对job进行定时触发（目前设置的定时为每隔一分钟执行一次）</br>