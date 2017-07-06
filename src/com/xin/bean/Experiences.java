
    /**  
    * @Title: Experiences.java
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
    * @ClassName: Experiences
    * @Description: TODO(经历)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "experiences", schema = "employee")
public class Experiences {
    private Integer exId;// 主键，自增
    private Integer eid;// 职工号
    private Integer type;// 经历类型，1为管理，2为专技，3为工人，0为教育
    private Integer exYear;// 经历开始时间
    private String exRank;// 经历级别
    
        /**
         * 创建一个新的实例 Experiences.
         *
         */
        
    public Experiences() {
        super();
        type = 0;
    }

        
            /**
             * 创建一个新的实例 Experiences.
             *
             * @param eid
             * @param type
             * @param exYear
             * @param exRank
             */
            
        public Experiences(Integer eid, Integer type, Integer exYear, String exRank) {
            super();
            this.eid = eid;
            this.type = type;
            this.exYear = exYear;
            this.exRank = exRank;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "experiences_seq", initialValue = 1, allocationSize = 1)
        @Column(name = "exId")
            public Integer getExId() {
                return exId;
            }


            public void setExId(Integer exId) {
                this.exId = exId;
            }

            @Column(name = "eid")
            public Integer getEid() {
                return eid;
            }


            public void setEid(Integer eid) {
                this.eid = eid;
            }

            @Column(name = "mold")
            public Integer getType() {
                return type;
            }


            public void setType(Integer type) {
                this.type = type;
            }

            @Column(name = "exYear")
            public Integer getExYear() {
                return exYear;
            }


            public void setExYear(Integer exYear) {
                this.exYear = exYear;
            }

            @Column(name = "exRank")
            public String getExRank() {
                return exRank;
            }


            public void setExRank(String exRank) {
                this.exRank = exRank;
            }
        
    
    
}
