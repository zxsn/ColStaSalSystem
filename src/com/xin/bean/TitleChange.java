
    /**  
    * @Title: TitleChange.java
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
    * @ClassName: TitleChange
    * @Description: TODO(职称变动信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "titleChange", schema = "employee")
public class TitleChange {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private String name;// 姓名
    private String newHireTitle; // 新聘任职称
    private Integer newTitleLevel; // 新职称级别
    private Date titleChangeDate;// 职务变动时间
    private String note;// 备注
    
        /**
         * 创建一个新的实例 TitleChange.
         *
         */
        
    public TitleChange() {
        super();
    }

        
            /**
             * 创建一个新的实例 TitleChange.
             *
             * @param id
             * @param eId
             * @param name
             * @param newHireTitle
             * @param newTitleLevel
             * @param titleChangeDate
             * @param note
             */
            
        public TitleChange(Integer id, Integer eId, String name, String newHireTitle,
                           Integer newTitleLevel, Date titleChangeDate, String note) {
            super();
            this.id = id;
            this.eId = eId;
            this.name = name;
            this.newHireTitle = newHireTitle;
            this.newTitleLevel = newTitleLevel;
            this.titleChangeDate = titleChangeDate;
            this.note = note;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "titleChange_seq", initialValue = 1, allocationSize = 1)
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

            @Column(name = "name")
            public String getName() {
                return name;
            }


            public void setName(String name) {
                this.name = name;
            }

            @Column(name = "newHireTitle")
            public String getNewHireTitle() {
                return newHireTitle;
            }


            public void setNewHireTitle(String newHireTitle) {
                this.newHireTitle = newHireTitle;
            }

            @Column(name = "newTitleLevel")
            public Integer getNewTitleLevel() {
                return newTitleLevel;
            }


            public void setNewTitleLevel(Integer newTitleLevel) {
                this.newTitleLevel = newTitleLevel;
            }

            @Column(name = "titleChangeDate")
            public Date getTitleChangeDate() {
                return titleChangeDate;
            }


            public void setTitleChangeDate(Date titleChangeDate) {
                this.titleChangeDate = titleChangeDate;
            }

            @Column(name = "note")
            public String getNote() {
                return note;
            }


            public void setNote(String note) {
                this.note = note;
            }
    
}
