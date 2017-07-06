
    /**  
    * @Title: IFinalBonusManage.java
    * @Package com.xin.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.service;

import java.util.List;

import com.xin.bean.FinalBonus;

/**
    * @ClassName: IFinalBonusManage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public interface IFinalBonusManage {
    public void addFinalBonus(FinalBonus finalBonus);
    public void deleteFinalBonus(FinalBonus finalBonus);
    public void modifyFinalBonus(FinalBonus finalBonus);
    public List<FinalBonus> findFinalBonusByEId(Integer eId);
    public List<FinalBonus> findFinalBonusByDoubleBonusType(String doubleBonusType);
}
