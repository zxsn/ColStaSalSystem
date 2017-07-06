
    /**  
    * @Title: IFinalCheckManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.FinalCheck;

/**
    * @ClassName: IFinalCheckManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IFinalCheckManage {
    public void addFinalCheck(FinalCheck finalCheck);
    public void deleteFinalCheck(FinalCheck finalCheck);
    public void modifyFinalCheck(FinalCheck finalCheck);
    public List<FinalCheck> findFinalCheckByEId(Integer eId);
    public List<FinalCheck> findFinalChecksByResult(String result);
}
