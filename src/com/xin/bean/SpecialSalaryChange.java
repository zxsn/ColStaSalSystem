
    /**  
    * @Title: SpecialSalaryChange.java
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
    * @ClassName: SpecialSalaryChange
    * @Description: TODO(工资变动信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "specialSalaryChange", schema = "employee")
public class SpecialSalaryChange {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private Date changeDate;// 扣减生效时间
    private Integer checkerId;// 审核员id
    private Date checkDate;// 审核时间
    private Integer operatorId;// 操作员id
    private Date operateDate;// 操作时间
    private Integer amount;// 工资金额增减，负数为减少
    private String reason;// 扣减原因
    
        /**
         * 创建一个新的实例 SpecialSalaryChange.
         *
         */
        
    public SpecialSalaryChange() {
        super();
    }

        
            /**
             * 创建一个新的实例 SpecialSalaryChange.
             *
             * @param id
             * @param eId
             * @param changeDate
             * @param checkerId
             * @param checkDate
             * @param operatorId
             * @param operateDate
             * @param amount
             * @param reason
             */
            
        public SpecialSalaryChange(Integer id, Integer eId, Date changeDate, Integer checkerId,
                                   Date checkDate, Integer operatorId, Date operateDate,
                                   Integer amount, String reason) {
            super();
            this.id = id;
            this.eId = eId;
            this.changeDate = changeDate;
            this.checkerId = checkerId;
            this.checkDate = checkDate;
            this.operatorId = operatorId;
            this.operateDate = operateDate;
            this.amount = amount;
            this.reason = reason;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "specialSalaryChange_seq", initialValue = 1, allocationSize = 1)
            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }

            @Column(name = "eId", length = 6)
            public Integer geteId() {
                return eId;
            }


            public void seteId(Integer eId) {
                this.eId = eId;
            }

            @Column(name = "changeDate")
            public Date getChangeDate() {
                return changeDate;
            }


            public void setChangeDate(Date changeDate) {
                this.changeDate = changeDate;
            }

            @Column(name = "checkerId")
            public Integer getCheckerId() {
                return checkerId;
            }


            public void setCheckerId(Integer checkerId) {
                this.checkerId = checkerId;
            }

            @Column(name = "checkDate")
            public Date getCheckDate() {
                return checkDate;
            }


            public void setCheckDate(Date checkDate) {
                this.checkDate = checkDate;
            }

            @Column(name = "operatorId")
            public Integer getOperatorId() {
                return operatorId;
            }


            public void setOperatorId(Integer operatorId) {
                this.operatorId = operatorId;
            }

            @Column(name = "operateDate")
            public Date getOperateDate() {
                return operateDate;
            }


            public void setOperateDate(Date operateDate) {
                this.operateDate = operateDate;
            }

            @Column(name = "amount")
            public Integer getAmount() {
                return amount;
            }


            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            @Column(name = "reason")
            public String getReason() {
                return reason;
            }


            public void setReason(String reason) {
                this.reason = reason;
            }

}
