package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.IAddOrCutDao;
import com.xin.bean.AddOrCut;
import com.xin.service.IAddOrCutManage;
/**
 * 
    * @ClassName: AddOrCutManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class AddOrCutManageImp implements IAddOrCutManage{
	@Resource
	private IAddOrCutDao iAddOrCutDao;

	@Override
	public void addAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.addAddOrCut(addOrCut);
	}

	@Override
	public void deleteAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.deleteAddOrCut(addOrCut);
	}

	@Override
	public void modifyAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.modifyAddOrCut(addOrCut);
	}

	@Override
	public List<AddOrCut>  findAddOrCutByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iAddOrCutDao.findAddOrCutByEId(eId);
	}

}
