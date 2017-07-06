
    /**  
    * @Title: WorkerSalaryChange.java
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
    * @ClassName: WorkerSalaryChange
    * @Description: TODO(工人薪级工资套改表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "worSalCha_table", schema = "employee")
public class WorkerSalaryChange {
    private int id;// 主键
    private Integer positionLevel;// 岗位级别
    private Integer lowBoundOfOfficeYear;// 任职年限下界
    private Integer upperBoundOfOfficeYear;// 任职年限上界
    private Integer lowBoundOfChangeYear;// 套改年限下界
    private Integer upperBoundOfChangeYear;// 套改年限上界
    private Integer payLevel;// 薪级
    
        /**
         * 创建一个新的实例 WorkerSalaryChange.
         *
         */
        
    public WorkerSalaryChange() {
        super();
    }

        
            /**
             * 创建一个新的实例 WorkerSalaryChange.
             *
             * @param id
             * @param positionLevel
             * @param lowBoundOfOfficeYear
             * @param upperBoundOfOfficeYear
             * @param lowBoundOfChangeYear
             * @param upperBoundOfChangeYear
             * @param payLevel
             */
            
        public WorkerSalaryChange(int id, Integer positionLevel, Integer lowBoundOfOfficeYear,
                                  Integer upperBoundOfOfficeYear, Integer lowBoundOfChangeYear,
                                  Integer upperBoundOfChangeYear, Integer payLevel) {
            super();
            this.id = id;
            this.positionLevel = positionLevel;
            this.lowBoundOfOfficeYear = lowBoundOfOfficeYear;
            this.upperBoundOfOfficeYear = upperBoundOfOfficeYear;
            this.lowBoundOfChangeYear = lowBoundOfChangeYear;
            this.upperBoundOfChangeYear = upperBoundOfChangeYear;
            this.payLevel = payLevel;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "worSalCha_table_seq", initialValue = 1, allocationSize = 1)
            public int getId() {
                return id;
            }


            public void setId(int id) {
                this.id = id;
            }

            @Column(name = "positionLevel", length = 5, nullable = false, unique = false)
            public Integer getPositionLevel() {
                return positionLevel;
            }


            public void setPositionLevel(Integer positionLevel) {
                this.positionLevel = positionLevel;
            }

            @Column(name = "lowBoundOfOfficeYear", length = 5, nullable = false, unique = false)
            public Integer getLowBoundOfOfficeYear() {
                return lowBoundOfOfficeYear;
            }


            public void setLowBoundOfOfficeYear(Integer lowBoundOfOfficeYear) {
                this.lowBoundOfOfficeYear = lowBoundOfOfficeYear;
            }

            @Column(name = "upperBoundOfOfficeYear", length = 5, nullable = false, unique = false)
            public Integer getUpperBoundOfOfficeYear() {
                return upperBoundOfOfficeYear;
            }


            public void setUpperBoundOfOfficeYear(Integer upperBoundOfOfficeYear) {
                this.upperBoundOfOfficeYear = upperBoundOfOfficeYear;
            }

            @Column(name = "lowBoundOfChangeYear", length = 5, nullable = false, unique = false)
            public Integer getLowBoundOfChangeYear() {
                return lowBoundOfChangeYear;
            }


            public void setLowBoundOfChangeYear(Integer lowBoundOfChangeYear) {
                this.lowBoundOfChangeYear = lowBoundOfChangeYear;
            }

            @Column(name = "upperBoundOfChangeYear", length = 5, nullable = false, unique = false)
            public Integer getUpperBoundOfChangeYear() {
                return upperBoundOfChangeYear;
            }


            public void setUpperBoundOfChangeYear(Integer upperBoundOfChangeYear) {
                this.upperBoundOfChangeYear = upperBoundOfChangeYear;
            }

            @Column(name = "payLevel", length = 5, nullable = false, unique = false)
            public Integer getPayLevel() {
                return payLevel;
            }


            public void setPayLevel(Integer payLevel) {
                this.payLevel = payLevel;
            }

}
