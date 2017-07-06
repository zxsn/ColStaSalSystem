
    /**  
    * @Title: StartSalaryInfo.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
    * @ClassName: StartSalaryInfo
    * @Description: TODO(起薪信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "start_salary_info", schema = "employee")
public class StartSalaryInfo {
    private Integer eid; // 职工号
    private Date startSalaryDate;// 起薪时间
    private Date operateDate;// 业务处理时间
    private Integer isRaised;// 基本工资是否上调10%   1表示是，0表示否
    private Integer changeYears;// 套改年限
    private Integer breakOffSeniority;// 中断工龄
    private Integer workYears;// 截至2017年6月30日的实际工作年限
    private Integer seniorityBeforeWork;// 工作前工龄
    private Integer learnSeniority;// 大专以上不计工龄年限
    private Integer hireYears; // 任职年限
    private String salarySeries; // 工资系列
    private Integer positionLevel;// 工资岗位级别
    private Integer salaryLevel;// 薪级
    private Integer positionSalary;// 岗位工资
    private Integer levelSalary;// 薪级工资
    private String remarks;// 备注
    
        /**
         * 创建一个新的实例 StartSalaryInfo.
         *
         */
        
    public StartSalaryInfo() {
        super();
    }

        
            /**
             * 创建一个新的实例 StartSalaryInfo.
             *
             * @param eid
             * @param startSalaryDate
             * @param operateDate
             * @param isRaised
             * @param changeYears
             * @param breakOffSeniority
             * @param workYears
             * @param seniorityBeforeWork
             * @param learnSeniority
             * @param hireYears
             * @param salarySeries
             * @param positionLevel
             * @param salaryLevel
             * @param positionSalary
             * @param levelSalary
             * @param remarks
             */
            
        public StartSalaryInfo(Integer eid, Date startSalaryDate, Date operateDate,
                               Integer isRaised, Integer changeYears, Integer breakOffSeniority,
                               Integer workYears, Integer seniorityBeforeWork,
                               Integer learnSeniority, Integer hireYears, String salarySeries,
                               Integer positionLevel, Integer salaryLevel, Integer positionSalary,
                               Integer levelSalary, String remarks) {
            super();
            this.eid = eid;
            this.startSalaryDate = startSalaryDate;
            this.operateDate = operateDate;
            this.isRaised = isRaised;
            this.changeYears = changeYears;
            this.breakOffSeniority = breakOffSeniority;
            this.workYears = workYears;
            this.seniorityBeforeWork = seniorityBeforeWork;
            this.learnSeniority = learnSeniority;
            this.hireYears = hireYears;
            this.salarySeries = salarySeries;
            this.positionLevel = positionLevel;
            this.salaryLevel = salaryLevel;
            this.positionSalary = positionSalary;
            this.levelSalary = levelSalary;
            this.remarks = remarks;
        }

        @Id
        @GeneratedValue
            public Integer getEid() {
                return eid;
            }


            public void setEid(Integer eid) {
                this.eid = eid;
            }

            @Column
            public Date getStartSalaryDate() {
                return startSalaryDate;
            }


            public void setStartSalaryDate(Date startSalaryDate) {
                this.startSalaryDate = startSalaryDate;
            }

            @Temporal(TemporalType.TIMESTAMP)
            @Column
            public Date getOperateDate() {
                return operateDate;
            }


            public void setOperateDate(Date operateDate) {
                this.operateDate = operateDate;
            }

            @Column
            public Integer getIsRaised() {
                return isRaised;
            }


            public void setIsRaised(Integer isRaised) {
                this.isRaised = isRaised;
            }

            @Column
            public Integer getChangeYears() {
                return changeYears;
            }


            public void setChangeYears(Integer changeYears) {
                this.changeYears = changeYears;
            }

            @Column
            public Integer getBreakOffSeniority() {
                return breakOffSeniority;
            }


            public void setBreakOffSeniority(Integer breakOffSeniority) {
                this.breakOffSeniority = breakOffSeniority;
            }

            @Column
            public Integer getWorkYears() {
                return workYears;
            }


            public void setWorkYears(Integer workYears) {
                this.workYears = workYears;
            }

            @Column
            public Integer getSeniorityBeforeWork() {
                return seniorityBeforeWork;
            }


            public void setSeniorityBeforeWork(Integer seniorityBeforeWork) {
                this.seniorityBeforeWork = seniorityBeforeWork;
            }

            @Column
            public Integer getLearnSeniority() {
                return learnSeniority;
            }


            public void setLearnSeniority(Integer learnSeniority) {
                this.learnSeniority = learnSeniority;
            }

            @Column
            public Integer getHireYears() {
                return hireYears;
            }


            public void setHireYears(Integer hireYears) {
                this.hireYears = hireYears;
            }

            @Column
            public String getSalarySeries() {
                return salarySeries;
            }


            public void setSalarySeries(String salarySeries) {
                this.salarySeries = salarySeries;
            }

            @Column
            public Integer getPositionLevel() {
                return positionLevel;
            }


            public void setPositionLevel(Integer positionLevel) {
                this.positionLevel = positionLevel;
            }

            @Column
            public Integer getSalaryLevel() {
                return salaryLevel;
            }


            public void setSalaryLevel(Integer salaryLevel) {
                this.salaryLevel = salaryLevel;
            }

            @Column
            public Integer getPositionSalary() {
                return positionSalary;
            }


            public void setPositionSalary(Integer positionSalary) {
                this.positionSalary = positionSalary;
            }

            @Column
            public Integer getLevelSalary() {
                return levelSalary;
            }


            public void setLevelSalary(Integer levelSalary) {
                this.levelSalary = levelSalary;
            }

            @Column
            public String getRemarks() {
                return remarks;
            }


            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

}
