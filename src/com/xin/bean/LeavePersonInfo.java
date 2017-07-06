
    /**  
    * @Title: LeavePersonInfo.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import java.util.Date;

/**
    * @ClassName: LeavePersonInfo
    * @Description: TODO(离职人员信息)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public class LeavePersonInfo {
    private String name;
    private String gender;
    private Integer eId;
    private String department;
    private Date leaveDate;
    private String reason;
    private String state;
    private Date stopDate;
    private String note;
    
        /**
         * 创建一个新的实例 LeavePersonInfo.
         *
         */
        
    public LeavePersonInfo() {
        name = null;
        gender = null;
        eId = null;
        department = null;
        leaveDate = null;
        reason = null;
        state = null;
        stopDate = null;
        note = null;
    }

        
            /**
             * 创建一个新的实例 LeavePersonInfo.
             *
             * @param name
             * @param gender
             * @param eId
             * @param department
             * @param leaveDate
             * @param reason
             * @param state
             * @param stopDate
             * @param note
             */
            
        public LeavePersonInfo(String name, String gender, Integer eId, String department,
                               Date leaveDate, String reason, String state, Date stopDate,
                               String note) {
            super();
            this.name = name;
            this.gender = gender;
            this.eId = eId;
            this.department = department;
            this.leaveDate = leaveDate;
            this.reason = reason;
            this.state = state;
            this.stopDate = stopDate;
            this.note = note;
        }


            public String getName() {
                return name;
            }


            public void setName(String name) {
                this.name = name;
            }


            public String getGender() {
                return gender;
            }


            public void setGender(String gender) {
                this.gender = gender;
            }


            public Integer geteId() {
                return eId;
            }


            public void seteId(Integer eId) {
                this.eId = eId;
            }


            public String getDepartment() {
                return department;
            }


            public void setDepartment(String department) {
                this.department = department;
            }


            public Date getLeaveDate() {
                return leaveDate;
            }


            public void setLeaveDate(Date leaveDate) {
                this.leaveDate = leaveDate;
            }


            public String getReason() {
                return reason;
            }


            public void setReason(String reason) {
                this.reason = reason;
            }


            public String getState() {
                return state;
            }


            public void setState(String state) {
                this.state = state;
            }


            public Date getStopDate() {
                return stopDate;
            }


            public void setStopDate(Date stopDate) {
                this.stopDate = stopDate;
            }


            public String getNote() {
                return note;
            }


            public void setNote(String note) {
                this.note = note;
            }
    
}
