
    /**  
    * @Title: ProfessionalPaylevelSalary.java
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
    * @ClassName: ProfessionalPaylevelSalary
    * @Description: TODO(专业技术人员薪级工资表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "profPaylSal_table", schema = "employee")
public class ProfessionalPaylevelSalary {
    private int id;// 主键
    private Integer payLevel;// 薪级
    private Integer salaryStandard;// 工资标准
    
        /**
         * 创建一个新的实例 ProfessionalPaylevelSalary.
         *
         */
        
    public ProfessionalPaylevelSalary() {
        super();
    }

        
            /**
             * 创建一个新的实例 ProfessionalPaylevelSalary.
             *
             * @param id
             * @param payLevel
             * @param salaryStandard
             */
            
        public ProfessionalPaylevelSalary(int id, Integer payLevel, Integer salaryStandard) {
            super();
            this.id = id;
            this.payLevel = payLevel;
            this.salaryStandard = salaryStandard;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "profPaylSal_table_seq", initialValue = 1, allocationSize = 1)
            public int getId() {
                return id;
            }


            public void setId(int id) {
                this.id = id;
            }

            @Column(name = "payLevel", length = 5, nullable = false, unique = true)
            public Integer getPayLevel() {
                return payLevel;
            }


            public void setPayLevel(Integer payLevel) {
                this.payLevel = payLevel;
            }

            @Column(name = "salaryStandard", length = 10, nullable = false, unique = false)
            public Integer getSalaryStandard() {
                return salaryStandard;
            }


            public void setSalaryStandard(Integer salaryStandard) {
                this.salaryStandard = salaryStandard;
            }
    
}
