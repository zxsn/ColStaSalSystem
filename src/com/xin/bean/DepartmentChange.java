
    /**  
    * @Title: DepartmentChange.java
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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
    * @ClassName: DepartmentChange
    * @Description: TODO(单位变动信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "departmentChange", schema = "employee")
public class DepartmentChange {
    private Integer id;// 主键
    private Integer eId;// 职工号,6位数字
    private String name;// 姓名
    private String oldDepartment;// 原单位
    private String newDepartment;// 新单位
    private Date depChangeDate;// 单位变动时间
    private String according;// 变更依据
    private String note;// 备注
    
        /**
         * 创建一个新的实例 DepartmentChange.
         *
         */
        
    public DepartmentChange() {
        super();
    }

        
            /**
             * 创建一个新的实例 DepartmentChange.
             *
             * @param id
             * @param eId
             * @param name
             * @param oldDepartment
             * @param newDepartment
             * @param depChangeDate
             * @param according
             * @param note
             */
            
        public DepartmentChange(Integer id, Integer eId, String name, String oldDepartment,
                                String newDepartment, Date depChangeDate, String according,
                                String note) {
            super();
            this.id = id;
            this.eId = eId;
            this.name = name;
            this.oldDepartment = oldDepartment;
            this.newDepartment = newDepartment;
            this.depChangeDate = depChangeDate;
            this.according = according;
            this.note = note;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "departmentChange_seq", initialValue = 1, allocationSize = 1)

            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }


            public Integer geteId() {
                return eId;
            }

            @Column(name = "eId", length = 6, nullable = false)
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

            @Column(name = "oldDepartment")
            public String getOldDepartment() {
                return oldDepartment;
            }


            public void setOldDepartment(String oldDepartment) {
                this.oldDepartment = oldDepartment;
            }

            @Column(name = "newDepartment")
            public String getNewDepartment() {
                return newDepartment;
            }


            public void setNewDepartment(String newDepartment) {
                this.newDepartment = newDepartment;
            }

            @Column(name = "depChangeDate")
            public Date getDepChangeDate() {
                return depChangeDate;
            }


            public void setDepChangeDate(Date depChangeDate) {
                this.depChangeDate = depChangeDate;
            }

            @Column(name = "according")
            public String getAccording() {
                return according;
            }


            public void setAccording(String according) {
                this.according = according;
            }

            @Column(name = "note")
            public String getNote() {
                return note;
            }


            public void setNote(String note) {
                this.note = note;
            }
    
}
