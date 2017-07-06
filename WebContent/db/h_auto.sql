--删除表
drop table employee.AddOrCut cascade constraints;
drop table employee.OffInfo cascade constraints;
drop table employee.departmentChange cascade constraints;
drop table employee.employee cascade constraints;
drop table employee.experiences cascade constraints;
drop table employee.finalBonus cascade constraints;
drop table employee.finalCheck cascade constraints;
drop table employee.leaveSchoolPerson cascade constraints;
drop table employee.manPaylSal_table cascade constraints;
drop table employee.manPosiSal_table cascade constraints;
drop table employee.manSalCha_table cascade constraints;
drop table employee.profPaylSal_table cascade constraints;
drop table employee.profPosiSal_table cascade constraints;
drop table employee.profSalCha_table cascade constraints;
drop table employee.salary cascade constraints;
drop table employee.specialSalaryChange cascade constraints;
drop table employee.specialSalaryRecovery cascade constraints;
drop table employee.start_salary_info cascade constraints;
drop table employee.tb_user cascade constraints;
drop table employee.titleChange cascade constraints;
drop table employee.worPaylSal_table cascade constraints;
drop table employee.worPosiSal_table cascade constraints;
drop table employee.worSalCha_table cascade constraints;
drop table employee.workChange cascade constraints;
--创建对应表
create table employee.AddOrCut (id number(10,0) not null, EId number(10,0), addOrCutDate date, addOrCutReason varchar2(255 char), amount number(10,0), choice number(10,0), primary key (id))
create table employee.OffInfo (id number(10,0) not null, eid number(10,0) not null, end_date timestamp not null, reason varchar2(255 char), start_date timestamp not null, primary key (id))
create table employee.departmentChange (id number(10,0) not null, eId number(10,0) not null, according varchar2(255 char), depChangeDate timestamp, name varchar2(255 char), newDepartment varchar2(255 char), note varchar2(255 char), oldDepartment varchar2(255 char), primary key (id))
create table employee.employee (id number(10,0) not null, birthday timestamp not null, department varchar2(10 char) not null, email varchar2(40 char), gender varchar2(255 char) not null, hire_date timestamp, hire_job varchar2(20 char), hire_title varchar2(30 char), hire_work varchar2(255 char), job_level number(10,0), job_type varchar2(10 char) not null, max_degree varchar2(20 char) not null, max_degree_date timestamp not null, max_education varchar2(20 char) not null, max_education_date timestamp not null, name varchar2(20 char) not null, reach_school_date timestamp, origin varchar2(10 char), start_work_date timestamp, title_level number(10,0), mold varchar2(10 char), uuid varchar2(20 char) not null, work_level number(10,0), primary key (id))
create table employee.experiences (exId number(10,0) not null, eid number(10,0), exRank varchar2(255 char), exYear number(10,0), mold number(10,0), primary key (exId))
create table employee.finalBonus (id number(10,0) not null, eId number(10,0) not null, basis number(10,0), cutReason varchar2(255 char), doubleSalaryType varchar2(255 char), months double precision, year number(10,0), primary key (id))
create table employee.finalCheck (id number(10,0) not null, eId number(10,0) not null, checkResult varchar2(255 char), year number(10,0), primary key (id))
create table employee.leaveSchoolPerson (id number(10,0) not null, eId number(10,0) not null, leaveReason varchar2(255 char), leaveSchoolDate timestamp not null, note varchar2(255 char), salaryState varchar2(255 char), stopDate timestamp not null, primary key (id))
create table employee.manPaylSal_table (id number(10,0) not null, payLevel number(10,0) not null unique, salaryStandard number(10,0) not null, primary key (id))
create table employee.manPosiSal_table (id number(10,0) not null, stage number(10,0) not null unique, position varchar2(10 char) not null, salaryStandard number(10,0) not null, startPayLevel number(10,0) not null, primary key (id))
create table employee.manSalCha_table (id number(10,0) not null, lowBoundOfChangeYear number(10,0) not null, lowBoundOfOfficeYear number(10,0) not null, payLevel number(10,0) not null, positionLevel number(10,0) not null, upperBoundOfChangeYear number(10,0) not null, upperBoundOfOfficeYear number(10,0) not null, primary key (id))
create table employee.profPaylSal_table (id number(10,0) not null, payLevel number(10,0) not null unique, salaryStandard number(10,0) not null, primary key (id))
create table employee.profPosiSal_table (id number(10,0) not null, stage number(10,0) not null unique, position varchar2(10 char) not null, salaryStandard number(10,0) not null, startPayLevel number(10,0) not null, primary key (id))
create table employee.profSalCha_table (id number(10,0) not null, lowBoundOfChangeYear number(10,0) not null, lowBoundOfOfficeYear number(10,0) not null, payLevel number(10,0) not null, positionLevel number(10,0) not null, upperBoundOfChangeYear number(10,0) not null, upperBoundOfOfficeYear number(10,0) not null, primary key (id))
create table employee.salary (sid number(10,0) not null, area_difference number(10,0), education_allowance number(10,0), eid number(10,0), level_salary number(10,0), month_add_allowance number(10,0), only_child_allowance number(10,0), other_allowance number(10,0), phone_allowance number(10,0), position_allowance number(10,0), position_salary number(10,0) not null, remarks varchar2(255 char), special_allowance number(10,0), supplement_salary number(10,0), Time timestamp, totle_salary number(10,0), primary key (sid))
create table employee.specialSalaryChange (id number(10,0) not null, eId number(10,0), amount number(10,0), changeDate timestamp, checkDate timestamp, checkerId number(10,0), operateDate timestamp, operatorId number(10,0), reason varchar2(255 char), primary key (id))
create table employee.specialSalaryRecovery (id number(10,0) not null, eId number(10,0), checkDate timestamp, checkerId number(10,0), operateDate timestamp, operatorId number(10,0), recoveryDate timestamp, recoveryReason varchar2(255 char), primary key (id))
create table employee.start_salary_info (eid number(10,0) not null, breakOffSeniority number(10,0), changeYears number(10,0), hireYears number(10,0), isRaised number(10,0), learnSeniority number(10,0), levelSalary number(10,0), operateDate timestamp, positionLevel number(10,0), positionSalary number(10,0), remarks varchar2(255 char), salaryLevel number(10,0), salarySeries varchar2(255 char), seniorityBeforeWork number(10,0), startSalaryDate timestamp, workYears number(10,0), primary key (eid))
create table employee.tb_user (id number(10,0) not null, password varchar2(32 char) not null, userType number(10,0) not null, primary key (id))
create table employee.titleChange (id number(10,0) not null, eId number(10,0) not null, name varchar2(255 char), newHireTitle varchar2(255 char), newTitleLevel number(10,0), note varchar2(255 char), titleChangeDate date, primary key (id))
create table employee.worPaylSal_table (id number(10,0) not null, payLevel number(10,0) not null unique, salaryStandard number(10,0) not null, primary key (id))
create table employee.worPosiSal_table (id number(10,0) not null, stage number(10,0) not null unique, position varchar2(10 char) not null, salaryStandard number(10,0) not null, startPayLevel number(10,0) not null, primary key (id))
create table employee.worSalCha_table (id number(10,0) not null, lowBoundOfChangeYear number(10,0) not null, lowBoundOfOfficeYear number(10,0) not null, payLevel number(10,0) not null, positionLevel number(10,0) not null, upperBoundOfChangeYear number(10,0) not null, upperBoundOfOfficeYear number(10,0) not null, primary key (id))
create table employee.workChange (id number(10,0) not null, eId number(10,0) not null, name varchar2(50 char) not null, newHireWork varchar2(255 char), newWorkLevel number(10,0), note varchar2(255 char), workChangeDate date, primary key (id))
--插入数据

