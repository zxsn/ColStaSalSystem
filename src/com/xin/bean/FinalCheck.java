
    /**  
    * @Title: FinalCheck.java
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
    * @ClassName: FinalCheck
    * @Description: TODO(年终考核信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "finalCheck", schema = "employee")
public class FinalCheck {
    private Integer id;// 主键
    private Integer eId;// 职工号
    private Integer year;// 年份
    private String checkResult;// 考核结果 ，0:不通过，1:通过，2:优秀
    
        /**
         * 创建一个新的实例 FinalCheck.
         *
         */
        
    public FinalCheck() {
        super();
    }

        
            /**
             * 创建一个新的实例 FinalCheck.
             *
             * @param id
             * @param eId
             * @param year
             * @param checkResult
             */
            
        public FinalCheck(Integer id, Integer eId, Integer year, String checkResult) {
            super();
            this.id = id;
            this.eId = eId;
            this.year = year;
            this.checkResult = checkResult;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "finalCheck_seq", initialValue = 1, allocationSize = 1)
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

            @Column(name = "checkResult")
            public String getCheckResult() {
                return checkResult;
            }


            public void setCheckResult(String checkResult) {
                this.checkResult = checkResult;
            }

}
