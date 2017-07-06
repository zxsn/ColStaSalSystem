
    /**  
    * @Title: SpecialSalaryRecovery.java
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
    * @ClassName: SpecialSalaryRecovery
    * @Description: TODO(工资恢复信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "specialSalaryRecovery", schema = "employee")
public class SpecialSalaryRecovery {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private Date recoveryDate;// 恢复时间
    private Integer checkerId;// 审核员id
    private Date checkDate;// 审核时间
    private Integer operatorId;// 操作员id
    private Date operateDate;// 操作时间
    private String recoveryReason;// 恢复原因
    
        /**
         * 创建一个新的实例 SpecialSalaryRecovery.
         *
         */
        
    public SpecialSalaryRecovery() {
        super();
    }

        
            /**
             * 创建一个新的实例 SpecialSalaryRecovery.
             *
             * @param id
             * @param eId
             * @param recoveryDate
             * @param checkerId
             * @param checkDate
             * @param operatorId
             * @param operateDate
             * @param recoveryReason
             */
            
        public SpecialSalaryRecovery(Integer id, Integer eId, Date recoveryDate, Integer checkerId,
                                     Date checkDate, Integer operatorId, Date operateDate,
                                     String recoveryReason) {
            super();
            this.id = id;
            this.eId = eId;
            this.recoveryDate = recoveryDate;
            this.checkerId = checkerId;
            this.checkDate = checkDate;
            this.operatorId = operatorId;
            this.operateDate = operateDate;
            this.recoveryReason = recoveryReason;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "specialSalaryRecovery_seq", initialValue = 1, allocationSize = 1)
            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }

            @Column(name = "eId")
            public Integer geteId() {
                return eId;
            }


            public void seteId(Integer eId) {
                this.eId = eId;
            }

            @Column(name = "recoveryDate")
            public Date getRecoveryDate() {
                return recoveryDate;
            }


            public void setRecoveryDate(Date recoveryDate) {
                this.recoveryDate = recoveryDate;
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

            @Column(name = "recoveryReason")
            public String getRecoveryReason() {
                return recoveryReason;
            }


            public void setRecoveryReason(String recoveryReason) {
                this.recoveryReason = recoveryReason;
            }
    
}
