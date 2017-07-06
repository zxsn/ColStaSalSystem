
    /**  
    * @Title: OffInfo.java
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
    * @ClassName: OffInfo
    * @Description: TODO(离职信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "OffInfo", schema = "employee")
public class OffInfo {
    private Integer id;
    private Integer eid; // 职工号
    private Date startDate; // 开始时间
    private Date endDate; // 结束时间
    private String reason; // 原因
    
        /**
         * 创建一个新的实例 OffInfo.
         *
         */
        
    public OffInfo() {
        super();
    }

        
            /**
             * 创建一个新的实例 OffInfo.
             *
             * @param id
             * @param eid
             * @param startDate
             * @param endDate
             * @param reason
             */
            
        public OffInfo(Integer eid, Date startDate, Date endDate, String reason) {
            super();
            this.eid = eid;
            this.startDate = startDate;
            this.endDate = endDate;
            this.reason = reason;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "OffInfo_seq", initialValue = 1, allocationSize = 1)
            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }

            @Column(name = "eid", nullable = false)
            public Integer getEid() {
                return eid;
            }


            public void setEid(Integer eid) {
                this.eid = eid;
            }

            @Column(name = "start_date", nullable = false)
            public Date getStartDate() {
                return startDate;
            }


            public void setStartDate(Date startDate) {
                this.startDate = startDate;
            }

            @Column(name = "end_date", nullable = false)
            public Date getEndDate() {
                return endDate;
            }


            public void setEndDate(Date endDate) {
                this.endDate = endDate;
            }

            @Column(name = "reason")
            public String getReason() {
                return reason;
            }


            public void setReason(String reason) {
                this.reason = reason;
            }
    
}
