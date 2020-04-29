
 --IF (EXISTS(SELECT * FROM sysdatabases WHERE dbid=db_ID('TrainOfChina')))
	-- drop database TrainOfChina;
--2.创建一个数据库
 
create database TrainOfChina   on (           
 
name='TrainOfChina1',		--为何不能同表名					     --主数据文件的逻辑名称
filename='F:\SQL SERVER\DB\TrainOfChina.mdf',		  --主数据文件的实际保存路径
size=15MB,											   --主文件的初始大小
 filegrowth=10MB  ,									 --数据文件每次增长10M
maxsize=300MB										--最大容量
)
 
log on   (											 --配置日志文件的选项
 
name='TrainOfChina',								  --日志文件的逻辑名称
 
filename='F:\SQL SERVER\DB\TrainOfChina.ldf',          --日志文件的实际保存路径
 
maxsize=5mb,											 --日志文件的初始大小
 
filegrowth=10%											 --超过默认值后自动再扩容5mb
 
)
 
  