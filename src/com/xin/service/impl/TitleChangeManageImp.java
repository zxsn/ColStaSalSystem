package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xin.dao.ITitleChangeDao;
import com.xin.bean.TitleChange;
import com.xin.service.ITitleChangeManage;
/**
 * 
    * @ClassName: TitleChangeManageImp
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class TitleChangeManageImp implements ITitleChangeManage{
	@Resource
	private ITitleChangeDao iTitleChangeDao;

	@Override
	public void addTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.addTitleChange(TitleChange);
	}

	@Override
	public void deleteTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.deleteTitleChange(TitleChange);
	}

	@Override
	public void modifyTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.modifyTitleChange(TitleChange);
	}

	@Override
	public List<TitleChange> findTitleChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iTitleChangeDao.findTitleChangeByEId(eId);
	}

}
