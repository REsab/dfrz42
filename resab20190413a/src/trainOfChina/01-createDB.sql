
 --IF (EXISTS(SELECT * FROM sysdatabases WHERE dbid=db_ID('TrainOfChina')))
	-- drop database TrainOfChina;
--2.����һ�����ݿ�
 
create database TrainOfChina   on (           
 
name='TrainOfChina1',		--Ϊ�β���ͬ����					     --�������ļ����߼�����
filename='F:\SQL SERVER\DB\TrainOfChina.mdf',		  --�������ļ���ʵ�ʱ���·��
size=15MB,											   --���ļ��ĳ�ʼ��С
 filegrowth=10MB  ,									 --�����ļ�ÿ������10M
maxsize=300MB										--�������
)
 
log on   (											 --������־�ļ���ѡ��
 
name='TrainOfChina',								  --��־�ļ����߼�����
 
filename='F:\SQL SERVER\DB\TrainOfChina.ldf',          --��־�ļ���ʵ�ʱ���·��
 
maxsize=5mb,											 --��־�ļ��ĳ�ʼ��С
 
filegrowth=10%											 --����Ĭ��ֵ���Զ�������5mb
 
)
 
  