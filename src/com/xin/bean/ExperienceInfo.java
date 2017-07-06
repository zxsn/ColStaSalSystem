
    /**  
    * @Title: ExperienceInfo.java
    * @Package com.xin.bean
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.bean;


    /**
    * @ClassName: ExperienceInfo
    * @Description: TODO(经历信息)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public class ExperienceInfo {
    private String work;
    private Integer workLevel;
    private Integer time;
    
        /**
         * 创建一个新的实例 ExperienceInfo.
         *
         */
        
    public ExperienceInfo() {
        super();
    }

            /**
             * 创建一个新的实例 ExperienceInfo.
             *
             * @param work
             * @param time
             */
            
        public ExperienceInfo(String work, Integer time) {
            super();
            this.work = work;
            this.time = time;
            if (this.work.equals("正部级")) {
                this.workLevel = 10;
            } else if (this.work.equals("副部级")) {
                this.workLevel = 9;
            } else if (this.work.equals("正厅级")) {
                this.workLevel = 8;
            } else if (this.work.equals("副厅级")) {
                this.workLevel = 7;
            } else if (this.work.equals("正处级")) {
                this.workLevel = 6;
            } else if (this.work.equals("副处级")) {
                this.workLevel = 5;
            } else if (this.work.equals("正科级")) {
                this.workLevel = 4;
            } else if (this.work.equals("副科级")) {
                this.workLevel = 3;
            } else if (this.work.equals("科员")) {
                this.workLevel = 2;
            } else if (this.work.equals("办事员")) {
                this.workLevel = 1;
            } else if (this.work.equals("正高一级")) {
                this.workLevel = 13;
            } else if (this.work.equals("正高二级")) {
                this.workLevel = 12;
            } else if (this.work.equals("正高三级")) {
                this.workLevel = 11;
            } else if (this.work.equals("正高四级")) {
                this.workLevel = 10;
            } else if (this.work.equals("副高五级")) {
                this.workLevel = 9;
            } else if (this.work.equals("副高六级")) {
                this.workLevel = 8;
            } else if (this.work.equals("副高七级")) {
                this.workLevel = 7;
            } else if (this.work.equals("中八级")) {
                this.workLevel = 6;
            } else if (this.work.equals("中九级")) {
                this.workLevel = 5;
            } else if (this.work.equals("中十级")) {
                this.workLevel = 4;
            } else if (this.work.equals("助理十一级")) {
                this.workLevel = 3;
            } else if (this.work.equals("助理十二级")) {
                this.workLevel = 2;
            } else if (this.work.equals("员十三级")) {
                this.workLevel = 1;
            } else if (this.work.equals("技工一级")) {
                this.workLevel = 6;
            } else if (this.work.equals("技工二级")) {
                this.workLevel = 5;
            } else if (this.work.equals("技工三级")) {
                this.workLevel = 4;
            } else if (this.work.equals("技工四级")) {
                this.workLevel = 3;
            } else if (this.work.equals("技工五级")) {
                this.workLevel = 2;
            } else if (this.work.equals("普通工")) {
                this.workLevel = 1;
            }
        }


            public String getwork() {
                return work;
            }


            public void setwork(String work) {
                this.work = work;
            }


            public Integer getworkLevel() {
                return workLevel;
            }


            public void setworkLevel(Integer workLevel) {
                this.workLevel = workLevel;
            }


            public Integer getTime() {
                return time;
            }


            public void setTime(Integer time) {
                this.time = time;
            }
    
}
