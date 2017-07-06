
    /**  
    * @Title: LeaveSchoolPerson.java
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
    * @ClassName: LeaveSchoolPerson
    * @Description: TODO(离校人员信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "leaveSchoolPerson", schema = "employee")
public class LeaveSchoolPerson {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private Date leaveSchoolDate;// 离校时间
    private String leaveReason;// 离校原因
    private String salaryState;// 工资状态 在职,停职,取消工资关系
    private Date stopDate;// 停发时间
    private String note;// 备注
    
        /**
         * 创建一个新的实例 LeaveSchoolPerson.
         *
         */
        
    public LeaveSchoolPerson() {
        super();
    }

        
            /**
             * 创建一个新的实例 LeaveSchoolPerson.
             *
             * @param id
             * @param eId
             * @param leaveSchoolDate
             * @param leaveReason
             * @param salaryState
             * @param stopDate
             * @param note
             */
            
        public LeaveSchoolPerson(Integer id, Integer eId, Date leaveSchoolDate, String leaveReason,
                                 String salaryState, Date stopDate, String note) {
            super();
            this.id = id;
            this.eId = eId;
            this.leaveSchoolDate = leaveSchoolDate;
            this.leaveReason = leaveReason;
            this.salaryState = salaryState;
            this.stopDate = stopDate;
            this.note = note;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "leaveSchoolPerson_seq", initialValue = 1, allocationSize = 1)
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

            @Column(name = "leaveSchoolDate", nullable = false)
            public Date getLeaveSchoolDate() {
                return leaveSchoolDate;
            }


            public void setLeaveSchoolDate(Date leaveSchoolDate) {
                this.leaveSchoolDate = leaveSchoolDate;
            }

            @Column(name = "leaveReason")
            public String getLeaveReason() {
                return leaveReason;
            }


            public void setLeaveReason(String leaveReason) {
                this.leaveReason = leaveReason;
            }

            @Column(name = "salaryState")
            public String getSalaryState() {
                return salaryState;
            }


            public void setSalaryState(String salaryState) {
                this.salaryState = salaryState;
            }

            @Column(name = "stopDate", nullable = false)
            public Date getStopDate() {
                return stopDate;
            }


            public void setStopDate(Date stopDate) {
                this.stopDate = stopDate;
            }

            @Column(name = "note")
            public String getNote() {
                return note;
            }


            public void setNote(String note) {
                this.note = note;
            }
    
}
