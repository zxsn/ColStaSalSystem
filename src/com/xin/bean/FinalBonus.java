
    /**  
    * @Title: FinalBonus.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
    * @ClassName: FinalBonus
    * @Description: TODO(年终一次性奖金信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "finalBonus", schema = "employee")
public class FinalBonus {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private Integer year;// 年份
    private String doubleSalaryType;// 发放双薪类型 0:不发 1:部分发 2:全额发放
    private Double months;// 实际发放月数
    private String cutReason;// 部分双薪原因
    private Integer basis; // 发放双薪基数
    
        /**
         * 创建一个新的实例 FinalBonus.
         *
         */
        
    public FinalBonus() {
        super();
    }

        
            /**
             * 创建一个新的实例 FinalBonus.
             *
             * @param id
             * @param eId
             * @param year
             * @param doubleSalaryType
             * @param months
             * @param cutReason
             * @param basis
             */
            
        public FinalBonus(Integer id, Integer eId, Integer year, String doubleSalaryType,
                          Double months, String cutReason, Integer basis) {
            super();
            this.id = id;
            this.eId = eId;
            this.year = year;
            this.doubleSalaryType = doubleSalaryType;
            this.months = months;
            this.cutReason = cutReason;
            this.basis = basis;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "finalBonus_seq", initialValue = 1, allocationSize = 1)
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

            @Column(name = "year")
            public Integer getYear() {
                return year;
            }


            public void setYear(Integer year) {
                this.year = year;
            }

            @Column(name = "doubleSalaryType")
            public String getDoubleSalaryType() {
                return doubleSalaryType;
            }


            public void setDoubleSalaryType(String doubleSalaryType) {
                this.doubleSalaryType = doubleSalaryType;
            }

            @Column(name = "months")
            public Double getMonths() {
                return months;
            }


            public void setMonths(Double months) {
                this.months = months;
            }

            @Column(name = "cutReason")
            public String getCutReason() {
                return cutReason;
            }


            public void setCutReason(String cutReason) {
                this.cutReason = cutReason;
            }

            @Column(name = "basis")
            public Integer getBasis() {
                return basis;
            }


            public void setBasis(Integer basis) {
                this.basis = basis;
            }
    
}
