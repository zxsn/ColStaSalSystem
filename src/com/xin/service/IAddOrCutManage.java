
    /**  
    * @Title: IAddOrCutManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.AddOrCut;

/**
    * @ClassName: IAddOrCutManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IAddOrCutManage {
    public void addAddOrCut(AddOrCut addOrCut);
    public void deleteAddOrCut(AddOrCut addOrCut);
    public void modifyAddOrCut(AddOrCut addOrCut);
    public List<AddOrCut> findAddOrCutByEId(Integer eId);
}
