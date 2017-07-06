
    /**  
    * @Title: AddOrCut.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import java.sql.Date;

/**
    * @ClassName: AddOrCut
    * @Description: TODO(补发补扣信息表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public class AddOrCut {
    private Integer id;// 主键
    private Integer eId;// 职工号

    private Integer choice;// 1:补发,0:补扣
    private Integer amount;// 补发补扣金额
    private String addOrCutReason;// 补发补扣原因
    private Date addOrCutDate;// 补发补扣时间
    
        /**
         * 创建一个新的实例 AddOrCut.
         *
         */
        
    public AddOrCut() {
        super();
    }

        
            /**
             * 创建一个新的实例 AddOrCut.
             *
             * @param id
             * @param eId
             * @param choice
             * @param amount
             * @param addOrCutReason
             * @param addOrCutDate
             */
            
        public AddOrCut(Integer id, Integer eId, Integer choice, Integer amount,
                        String addOrCutReason, Date addOrCutDate) {
            super();
            this.id = id;
            this.eId = eId;
            this.choice = choice;
            this.amount = amount;
            this.addOrCutReason = addOrCutReason;
            this.addOrCutDate = addOrCutDate;
        }


            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }


            public Integer geteId() {
                return eId;
            }


            public void seteId(Integer eId) {
                this.eId = eId;
            }


            public Integer getChoice() {
                return choice;
            }


            public void setChoice(Integer choice) {
                this.choice = choice;
            }


            public Integer getAmount() {
                return amount;
            }


            public void setAmount(Integer amount) {
                this.amount = amount;
            }


            public String getAddOrCutReason() {
                return addOrCutReason;
            }


            public void setAddOrCutReason(String addOrCutReason) {
                this.addOrCutReason = addOrCutReason;
            }


            public Date getAddOrCutDate() {
                return addOrCutDate;
            }


            public void setAddOrCutDate(Date addOrCutDate) {
                this.addOrCutDate = addOrCutDate;
            }
    
}
