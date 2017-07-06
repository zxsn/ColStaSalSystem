package com.xin.other;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
import com.xin.bean.Salary;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(工资计算公式)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class ComputeSalarySingleton {
	private static final ComputeSalarySingleton computeSalarySingleton = new ComputeSalarySingleton();  
	
	private Integer positionSalary;//岗位工资
	private Integer levelSalary;//薪级工资
	
	private Integer areaDifference;//地区差
	private Integer positionAllowance;//岗位津贴
	private Integer educationAllowance;///教护补贴
	private Double specialPositionParas,specialLevelParas;//特殊津贴加权
	private Integer onlyChildAllowance;//独生子女
	private Double otherPositionParas,otherLevelParas;//其它补贴加权
	private Double phonePositionParam,phoneLevelParam;//电话补贴加权
	//private Integer monthAddAllowance;//月增资额
	//private Integer supplementSalary;//补发工资
	 
	private ComputeSalarySingleton(){
		 areaDifference=30;
		 positionAllowance=40;
		 educationAllowance=50;
		 specialPositionParas=(double) 0.1;
		 specialLevelParas=(double) 0.2;
		 onlyChildAllowance=100;
		 otherPositionParas=(double) 0.1;
		 otherLevelParas=(double) 0.3;
		 phonePositionParam=(double) 0.2;
		 phoneLevelParam=(double) 0.3;
	 }
	 
	 synchronized public static ComputeSalarySingleton getInstance(){
		 return computeSalarySingleton;
	 }
	
	 public void setSalary(Salary salary){
		 System.out.println("start");
		 positionSalary=salary.getPositionSalary();
		 levelSalary=salary.getLevelSalary();
		 
		 System.out.println(salary.getEid());
		 System.out.println(positionSalary);
		 System.out.println(levelSalary);
		 System.out.println(getInstance().getAreaDifference());
		 
		 salary.setAreaDifference(areaDifference);
		 salary.setPositionAllowance(positionAllowance);
		 salary.setEducationAllowance(educationAllowance);
		 salary.setSpecialAllowance((int)(specialPositionParas*positionSalary+specialLevelParas*levelSalary));
		 salary.setOnlyChildAllowance(onlyChildAllowance);
		 salary.setOtherAllowance((int)(otherPositionParas*positionSalary+otherLevelParas*levelSalary));
		 salary.setPhoneAllowance((int)(phonePositionParam*positionSalary+phoneLevelParam*levelSalary));
		 salary.setTotleSalary();
	 }

	public Integer getPositionSalary() {
		return positionSalary;
	}

	public void setPositionSalary(Integer positionSalary) {
		System.out.println("设置岗位工资");
		System.out.println(positionSalary);	
		this.positionSalary = positionSalary;
	}

	public Integer getLevelSalary() {
		return levelSalary;
	}

	public void setLevelSalary(Integer levelSalary) {
		this.levelSalary = levelSalary;
	}

	public Integer getAreaDifference() {
		return areaDifference;
	}

	public void setAreaDifference(Integer areaDifference) {
		System.out.println("设置地区差");
		System.out.println(areaDifference);	
		this.areaDifference = areaDifference;
	}

	public Integer getPositionAllowance() {
		return positionAllowance;
	}

	public void setPositionAllowance(Integer positionAllowance) {
		this.positionAllowance = positionAllowance;
	}

	public Integer getEducationAllowance() {
		return educationAllowance;
	}

	public void setEducationAllowance(Integer educationAllowance) {
		this.educationAllowance = educationAllowance;
	}

	public Double getSpecialPositionParas() {
		return specialPositionParas;
	}

	public void setSpecialPositionParas(Double specialPositionParas) {
		this.specialPositionParas = specialPositionParas;
	}

	public Double getSpecialLevelParas() {
		return specialLevelParas;
	}

	public void setSpecialLevelParas(Double specialLevelParas) {
		this.specialLevelParas = specialLevelParas;
	}

	public Integer getOnlyChildAllowance() {
		return onlyChildAllowance;
	}

	public void setOnlyChildAllowance(Integer onlyChildAllowance) {
		this.onlyChildAllowance = onlyChildAllowance;
	}

	public Double getOtherPositionParas() {
		return otherPositionParas;
	}

	public void setOtherPositionParas(Double otherPositionParas) {
		this.otherPositionParas = otherPositionParas;
	}

	public Double getOtherLevelParas() {
		return otherLevelParas;
	}

	public void setOtherLevelParas(Double otherLevelParas) {
		this.otherLevelParas = otherLevelParas;
	}

	public Double getPhonePositionParam() {
		return phonePositionParam;
	}

	public void setPhonePositionParam(Double phonePositionParam) {
		this.phonePositionParam = phonePositionParam;
	}

	public Double getPhoneLevelParam() {
		return phoneLevelParam;
	}

	public void setPhoneLevelParam(Double phoneLevelParam) {
		this.phoneLevelParam = phoneLevelParam;
	}
}
