package com.xin.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.xin.bean.ManagePaylevelSalary;
import com.xin.bean.ManagePositionSalary;
import com.xin.bean.ManageSalaryChange;
import com.xin.service.IManageSalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ManageTest {
	private Integer level;
	private Integer off;
	private Integer cha;
	private Integer salary;
	private ManageSalaryChange manageSalaryChange;
	private ManagePositionSalary managePositionSalary;
	private ManagePaylevelSalary managePaylevelSalary;
	
	
        
        public IManageSalaryManage getiManageSalaryManage() {
        return iManageSalaryManage;
    }
    public void setiManageSalaryManage(IManageSalaryManage iManageSalaryManage) {
        this.iManageSalaryManage = iManageSalaryManage;
    }
        /**
         * 创建一个新的实例 ManageTest.
         *
         */
        
    public ManageTest() {
        super();
    }
        /**
         * 创建一个新的实例 ManageTest.
         *
         * @param level
         * @param off
         * @param cha
         * @param salary
         * @param manageSalaryChange
         * @param managePositionSalary
         * @param managePaylevelSalary
         * @param iManageSalaryManage
         */
        
    public ManageTest(Integer level, Integer off, Integer cha, Integer salary,
                      ManageSalaryChange manageSalaryChange,
                      ManagePositionSalary managePositionSalary,
                      ManagePaylevelSalary managePaylevelSalary,
                      IManageSalaryManage iManageSalaryManage) {
        super();
        this.level = level;
        this.off = off;
        this.cha = cha;
        this.salary = salary;
        this.manageSalaryChange = manageSalaryChange;
        this.managePositionSalary = managePositionSalary;
        this.managePaylevelSalary = managePaylevelSalary;
        this.iManageSalaryManage = iManageSalaryManage;
    }

    @Resource
	private IManageSalaryManage iManageSalaryManage;
	
	public ManageSalaryChange getManageSalaryChange() {
		return manageSalaryChange;
	}
	public void setManageSalaryChange(ManageSalaryChange manageSalaryChange) {
		this.manageSalaryChange = manageSalaryChange;
	}
	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}
	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}
	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}
	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}

	public IManageSalaryManage getManageSalaryManage() {
		return iManageSalaryManage;
	}
	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.iManageSalaryManage = manageSalaryManage;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getOff() {
		return off;
	}
	public void setOff(Integer off) {
		this.off = off;
	}
	public Integer getCha() {
		return cha;
	}
	public void setCha(Integer cha) {
		this.cha = cha;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public String computeSalary(){
		System.out.println(level);
		iManageSalaryManage.setAllManage(level, off, cha);
		salary=iManageSalaryManage.getSalary();
		
		System.out.println(salary);
		return Action.SUCCESS;
	}
	
	public String addCha(){
		iManageSalaryManage.addManSalCha(manageSalaryChange);
		
		return Action.SUCCESS;
	}
	
	public String addPay(){
		iManageSalaryManage.addManPaySal(managePaylevelSalary);
		
		return Action.SUCCESS;
	}
	
	public String addPos(){
		System.out.println(managePositionSalary.getLevel());
		System.out.println(managePositionSalary.getPosition());
		System.out.println(managePositionSalary.getSalaryStandard());
		System.out.println(managePositionSalary.getStartPayLevel());
		iManageSalaryManage.addManPosSal(managePositionSalary);
		
		return Action.SUCCESS;
	}
}
