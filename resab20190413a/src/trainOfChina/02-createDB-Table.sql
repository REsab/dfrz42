

--1.删除数据库
  if exists (select *from sysobjects where  name='TrainScheduler')
  drop table TrainScheduler

  if exists (select *from sysobjects where name='TrainInfo')
  drop table TrainInfo

 
--在数据库中创建表
   if exists (select *from sysobjects where name='TrainInfo')
  drop table TrainInfo
 create table TrainInfo(
 TNumber varchar (16)  not  null
,TFrom varchar(20)   not null 
,TDest varchar(20)  not null 
,TDistance int
,TStartTime datetime 
,TEndTime datetime 
,TDDday int 
,TSpeed int  not null 
,TUnitPrice money  not null 
 );

 alter table TrainInfo
 add constraint PK_TrainInfo_TNumber primary key (TNumber);

execute sp_addextendedproperty 'MS_Description','存储车次信息,如K189','user','dbo','table',TrainInfo,'column', TNumber;
execute sp_addextendedproperty 'MS_Description','起点站,如长沙','user','dbo','table',TrainInfo,'column', TFrom;
execute sp_addextendedproperty 'MS_Description','终点站,如北京','user','dbo','table',TrainInfo,'column', TDest;
execute sp_addextendedproperty 'MS_Description','从起点到终点的总里程','user','dbo','table',TrainInfo,'column', TDistance;
execute sp_addextendedproperty 'MS_Description','始发时间 如19:40','user','dbo','table',TrainInfo,'column', TStartTime;
execute sp_addextendedproperty 'MS_Description','到站时间, 如16:00','user','dbo','table',TrainInfo,'column', TEndTime;
execute sp_addextendedproperty 'MS_Description','旅行经过的天数','user','dbo','table',TrainInfo,'column', TDDday;
execute sp_addextendedproperty 'MS_Description','速度,单位为千米/小时','user','dbo','table',TrainInfo,'column', TSpeed;
execute sp_addextendedproperty 'MS_Description','单位票价,每10千米的费用','user','dbo','table',TrainInfo,'column', TUnitPrice;

--消息 15233，级别 16，状态 1，过程 sp_addextendedproperty，行 37 [批起始行 0]
--无法添加属性。'dbo.TrainInfo.TUnitPrice' 已存在属性 'MS_Description'。         !!!1  注释了两次   


--    -------   ---   --          - - - --          - - ------           -   - - ----- --------- 
create table TrainScheduler(
SNumber varchar(16)  not null 
,SDate datetime  not null 
,SConductor varchar (20)  
,SSeatNumber int 
,SLieNumber int 
,SVisaNumber int 

);

 alter table TrainScheduler
 add constraint PK_TrainScheduler_SNumber_SDate primary key (SNumber,SDate),    --主键
     constraint FK_TrainScheduler_SNumber_2_TrainOfChina_TNumber foreign key(SNumber) references TrainInfo(TNumber);   --外键
execute sp_addextendedproperty 'MS_Description','外键,引用train info 的TNumber','user','dbo','table',TrainScheduler,'column', SNumber;
execute sp_addextendedproperty 'MS_Description','发车日期,如2013-4-5','user','dbo','table',TrainScheduler,'column', SDate;
execute sp_addextendedproperty 'MS_Description','值班列车长','user','dbo','table',TrainScheduler,'column', SConductor;
execute sp_addextendedproperty 'MS_Description','可销售的硬座票','user','dbo','table',TrainScheduler,'column', SSeatNumber;
execute sp_addextendedproperty 'MS_Description','可销售的硬卧票','user','dbo','table',TrainScheduler,'column', SLieNumber;
execute sp_addextendedproperty 'MS_Description','可销售的软卧票','user','dbo','table',TrainScheduler,'column', SVisaNumber;


-----约束

alter table TrainInfo
add constraint CK_TrainInfo check (TSpeed<=500 ),
constraint DEFAULT_speed default ('120') for TSpeed,
constraint DEFAULT_TUnitPrice default (0.7) for TUnitPrice,
constraint DEFAULT_TDDday default (1) for TDDday,
constraint CK_TUnitPrice check (TUnitPrice>=0.1 and TUnitPrice<=3 );


