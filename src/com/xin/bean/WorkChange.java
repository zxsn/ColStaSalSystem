
    /**  
    * @Title: WorkChange.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
    * @ClassName: WorkChange
    * @Description: TODO(职务变动信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "workChange", schema = "employee")
public class WorkChange {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private String name;// 姓名
    private String newHireWork; // 聘任职称
    private Integer newWorkLevel; // 职称级别
    private Date workChangeDate;// 职务变动时间
    private String note;// 备注
    
        /**
         * 创建一个新的实例 WorkChange.
         *
         */
        
    public WorkChange() {
        super();
    }

        
            /**
             * 创建一个新的实例 WorkChange.
             *
             * @param id
             * @param eId
             * @param name
             * @param newHireWork
             * @param newWorkLevel
             * @param workChangeDate
             * @param note
             */
            
        public WorkChange(Integer id, Integer eId, String name, String newHireWork,
                          Integer newWorkLevel, Date workChangeDate, String note) {
            super();
            this.id = id;
            this.eId = eId;
            this.name = name;
            this.newHireWork = newHireWork;
            this.newWorkLevel = newWorkLevel;
            this.workChangeDate = workChangeDate;
            this.note = note;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "workChange_seq", initialValue = 1, allocationSize = 1)
            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }

            @Column(name = "eId", length = 6, nullable = false)
            public Integer geteId() {
                return eId;
            }


            public void seteId(Integer eId) {
                this.eId = eId;
            }

            @Column(name = "name", nullable = false, length = 50)
            public String getName() {
                return name;
            }


            public void setName(String name) {
                this.name = name;
            }

            @Column(name = "newHireWork")
            public String getNewHireWork() {
                return newHireWork;
            }


            public void setNewHireWork(String newHireWork) {
                this.newHireWork = newHireWork;
            }

            @Column(name = "newWorkLevel")
            public Integer getNewWorkLevel() {
                return newWorkLevel;
            }


            public void setNewWorkLevel(Integer newWorkLevel) {
                this.newWorkLevel = newWorkLevel;
            }

            @Column(name = "workChangeDate")
            public Date getWorkChangeDate() {
                return workChangeDate;
            }


            public void setWorkChangeDate(Date workChangeDate) {
                this.workChangeDate = workChangeDate;
            }

            @Column(name = "note")
            public String getNote() {
                return note;
            }


            public void setNote(String note) {
                this.note = note;
            }
    
}
