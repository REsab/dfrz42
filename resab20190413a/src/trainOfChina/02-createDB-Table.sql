

--1.ɾ�����ݿ�
  if exists (select *from sysobjects where  name='TrainScheduler')
  drop table TrainScheduler

  if exists (select *from sysobjects where name='TrainInfo')
  drop table TrainInfo

 
--�����ݿ��д�����
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

execute sp_addextendedproperty 'MS_Description','�洢������Ϣ,��K189','user','dbo','table',TrainInfo,'column', TNumber;
execute sp_addextendedproperty 'MS_Description','���վ,�糤ɳ','user','dbo','table',TrainInfo,'column', TFrom;
execute sp_addextendedproperty 'MS_Description','�յ�վ,�籱��','user','dbo','table',TrainInfo,'column', TDest;
execute sp_addextendedproperty 'MS_Description','����㵽�յ�������','user','dbo','table',TrainInfo,'column', TDistance;
execute sp_addextendedproperty 'MS_Description','ʼ��ʱ�� ��19:40','user','dbo','table',TrainInfo,'column', TStartTime;
execute sp_addextendedproperty 'MS_Description','��վʱ��, ��16:00','user','dbo','table',TrainInfo,'column', TEndTime;
execute sp_addextendedproperty 'MS_Description','���о���������','user','dbo','table',TrainInfo,'column', TDDday;
execute sp_addextendedproperty 'MS_Description','�ٶ�,��λΪǧ��/Сʱ','user','dbo','table',TrainInfo,'column', TSpeed;
execute sp_addextendedproperty 'MS_Description','��λƱ��,ÿ10ǧ�׵ķ���','user','dbo','table',TrainInfo,'column', TUnitPrice;

--��Ϣ 15233������ 16��״̬ 1������ sp_addextendedproperty���� 37 [����ʼ�� 0]
--�޷�������ԡ�'dbo.TrainInfo.TUnitPrice' �Ѵ������� 'MS_Description'��         !!!1  ע��������   


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
 add constraint PK_TrainScheduler_SNumber_SDate primary key (SNumber,SDate),    --����
     constraint FK_TrainScheduler_SNumber_2_TrainOfChina_TNumber foreign key(SNumber) references TrainInfo(TNumber);   --���
execute sp_addextendedproperty 'MS_Description','���,����train info ��TNumber','user','dbo','table',TrainScheduler,'column', SNumber;
execute sp_addextendedproperty 'MS_Description','��������,��2013-4-5','user','dbo','table',TrainScheduler,'column', SDate;
execute sp_addextendedproperty 'MS_Description','ֵ���г���','user','dbo','table',TrainScheduler,'column', SConductor;
execute sp_addextendedproperty 'MS_Description','�����۵�Ӳ��Ʊ','user','dbo','table',TrainScheduler,'column', SSeatNumber;
execute sp_addextendedproperty 'MS_Description','�����۵�Ӳ��Ʊ','user','dbo','table',TrainScheduler,'column', SLieNumber;
execute sp_addextendedproperty 'MS_Description','�����۵�����Ʊ','user','dbo','table',TrainScheduler,'column', SVisaNumber;


-----Լ��

alter table TrainInfo
add constraint CK_TrainInfo check (TSpeed<=500 ),
constraint DEFAULT_speed default ('120') for TSpeed,
constraint DEFAULT_TUnitPrice default (0.7) for TUnitPrice,
constraint DEFAULT_TDDday default (1) for TDDday,
constraint CK_TUnitPrice check (TUnitPrice>=0.1 and TUnitPrice<=3 );


