
    /**  
    * @Title: WorkerPositionSalary.java
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
    * @ClassName: WorkerPositionSalary
    * @Description: TODO(工人岗位工资表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "worPosiSal_table", schema = "employee")
public class WorkerPositionSalary {
    private int id;// 主键
    private String position;// 岗位
    private Integer level;// 级数
    private Integer salaryStandard;// 工资标准
    private Integer startPayLevel;// 起点薪级
    
        /**
         * 创建一个新的实例 WorkerPositionSalary.
         *
         */
        
    public WorkerPositionSalary() {
        super();
    }

        
            /**
             * 创建一个新的实例 WorkerPositionSalary.
             *
             * @param id
             * @param position
             * @param level
             * @param salaryStandard
             * @param startPayLevel
             */
            
        public WorkerPositionSalary(int id, String position, Integer level, Integer salaryStandard,
                                    Integer startPayLevel) {
            super();
            this.id = id;
            this.position = position;
            this.level = level;
            this.salaryStandard = salaryStandard;
            this.startPayLevel = startPayLevel;
        }

        @Id
        @GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "worPosiSal_table_seq", initialValue = 1, allocationSize = 1)
            public int getId() {
                return id;
            }


            public void setId(int id) {
                this.id = id;
            }

            @Column(name = "position", length = 10, nullable = false, unique = false)
            public String getPosition() {
                return position;
            }


            public void setPosition(String position) {
                this.position = position;
            }

            @Column(name = "stage", length = 5, nullable = false, unique = true)
            public Integer getLevel() {
                return level;
            }


            public void setLevel(Integer level) {
                this.level = level;
            }

            @Column(name = "salaryStandard", length = 10, nullable = false, unique = false)
            public Integer getSalaryStandard() {
                return salaryStandard;
            }


            public void setSalaryStandard(Integer salaryStandard) {
                this.salaryStandard = salaryStandard;
            }

            @Column(name = "startPayLevel", length = 5, nullable = false, unique = false)
            public Integer getStartPayLevel() {
                return startPayLevel;
            }


            public void setStartPayLevel(Integer startPayLevel) {
                this.startPayLevel = startPayLevel;
            }
    
}
