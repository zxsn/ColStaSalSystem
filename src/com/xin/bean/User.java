
    /**  
    * @Title: User.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    * @ClassName: User
    * @Description: TODO(用户表)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */
@Entity
@Table(name = "tb_user", schema = "employee")
public class User {
    private Integer id;//用户名
    private String password;//密码
    private Integer userType;//类型，1：管理员 2：普通职工
    
        /**
         * 创建一个新的实例 User.
         *
         */
        
    public User() {
        super();
    }

        
            /**
             * 创建一个新的实例 User.
             *
             * @param id
             * @param password
             * @param userType
             */
            
        public User(Integer id, String password, Integer userType) {
            super();
            this.id = id;
            this.password = password;
            this.userType = userType;
        }

        @Id
            public Integer getId() {
                return id;
            }


            public void setId(Integer id) {
                this.id = id;
            }

            @Column(name = "password", length = 32, nullable = false)
            public String getPassword() {
                return password;
            }


            public void setPassword(String password) {
                this.password = password;
            }

            @Column(name = "userType", nullable = false)
            public Integer getUserType() {
                return userType;
            }


            public void setUserType(Integer userType) {
                this.userType = userType;
                if (userType < 2 && userType >= 0) {
                    this.userType = userType;
                }
            }

}
