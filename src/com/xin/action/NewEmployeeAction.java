package com.xin.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xin.bean.Employee;
import com.xin.bean.ExperienceInfo;
import com.xin.bean.Experiences;
import com.xin.bean.OffInfo;
import com.xin.bean.StartSalaryInfo;
import com.xin.service.IEmployeeManage;
import com.xin.service.IExperiencesManage;
import com.xin.service.IManageSalaryManage;
import com.xin.service.IOffInfoManage;
import com.xin.service.IProfSalaryManage;
import com.xin.service.IStartSalaryInfoManage;
import com.xin.service.IWorkerSalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class NewEmployeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartSalaryInfo startSalaryInfo;

	public StartSalaryInfo getStartSalaryInfo() {
		return startSalaryInfo;
	}

	public void setStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		this.startSalaryInfo = startSalaryInfo;
	}

	// 参加工作时间
	private String startWorkYear;

	public String getStartWorkYear() {
		return startWorkYear;
	}

	public void setStartWorkYear(String startWorkYear) {
		this.startWorkYear = startWorkYear;
	}

	// 考核不成功的次数
	private int failTime;

	public int getFailTime() {
		return failTime;
	}

	public void setFailTime(int failTime) {
		this.failTime = failTime;
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private int i;
	private int j;
	private int k;
	private int l;
	private int m;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	@Resource
	private IStartSalaryInfoManage startSalaryInfoManage;

	public IStartSalaryInfoManage getStartSalaryInfoManage() {
		return startSalaryInfoManage;
	}

	public void setStartSalaryInfoManage(
			IStartSalaryInfoManage startSalaryInfoManage) {
		this.startSalaryInfoManage = startSalaryInfoManage;
	}

	@Resource
	private IEmployeeManage employeeManage;

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	@Resource
	private IManageSalaryManage manageSalaryManage;

	public IManageSalaryManage getManageSalaryManage() {
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.manageSalaryManage = manageSalaryManage;
	}

	@Resource
	private IProfSalaryManage profSalaryManage;

	public IProfSalaryManage getProfSalaryManage() {
		return profSalaryManage;
	}

	public void setProfSalaryManage(IProfSalaryManage profSalaryManage) {
		this.profSalaryManage = profSalaryManage;
	}

	@Resource
	private IWorkerSalaryManage workerSalaryManage;

	public IWorkerSalaryManage getWorkerSalaryManage() {
		return workerSalaryManage;
	}

	public void setWorkerSalaryManage(IWorkerSalaryManage workerSalaryManage) {
		this.workerSalaryManage = workerSalaryManage;
	}

	@Resource
	private IExperiencesManage experiencesManage;

	public IExperiencesManage getExperiencesManage() {
		return experiencesManage;
	}

	public void setExperiencesManage(IExperiencesManage experiencesManage) {
		this.experiencesManage = experiencesManage;
	}

	@Resource
	private IOffInfoManage offInfoManage;	
	
	public IOffInfoManage getOffInfoManage() {
		return offInfoManage;
	}

	public void setOffInfoManage(IOffInfoManage offInfoManage) {
		this.offInfoManage = offInfoManage;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	// 字符串到日期格式转化函数，输入字符串，返回日期
	public Date strToDate(String str) {
		String[] divideStr = str.split("-");
		if (divideStr.length == 3) {
			int year = Integer.parseInt(divideStr[0].trim());
			int month = Integer.parseInt(divideStr[1].trim());
			int day = Integer.parseInt(divideStr[2].trim());
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day);
			return calendar.getTime();
		}
		return null;
	}

	// 获取两个日期之间的时间差（四舍五入，精确到月），输入两个日期，输出中断工龄
	@SuppressWarnings("deprecation")
	public int dateDif(Date d1, Date d2) {
		int yearDif = d2.getYear() - d1.getYear();
		int monthDif = d2.getMonth() - d1.getMonth();
		int dayDif = d2.getDay() - d1.getDay();

		if (monthDif < 0) {
			yearDif = yearDif - 1;
			monthDif = 12 + monthDif;
		}
		if (dayDif < 0) {
			monthDif = monthDif - 1;
			dayDif = 30 + dayDif;
		}

		System.out.println("起始时间:" + d1);
		System.out.println("恢复时间:" + d2);
		System.out.println("中断时间" + yearDif + "年" + monthDif + "月");
		if ((monthDif == 6 && dayDif > 0) || monthDif > 6) {
			return yearDif + 1;
		} else {
			return yearDif;
		}
	}

	// 获取管理系列任职时间
	public int getManageOfficeTime(int mLevel, int manageMinYear,
			ArrayList<ExperienceInfo> techList) {
		int minTechYear = 2006;
		int techLength = techList.size();

		if (mLevel == 7) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getworkLevel() >= 10
						&& techList.get(i).getworkLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 6) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getworkLevel() >= 10
						&& techList.get(i).getworkLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		} else if (mLevel == 5) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getworkLevel() >= 7
						&& techList.get(i).getworkLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 4) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getworkLevel() >= 4
						&& techList.get(i).getworkLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 3) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getworkLevel() >= 4
						&& techList.get(i).getworkLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		}

		int minYear = (manageMinYear < minTechYear) ? manageMinYear
				: minTechYear;

		return (2006 - minYear + 1);
	}

	// 获取专技系列任职年限
	public int getTechOfficeTime(int tLevel, int techMinYear,
			ArrayList<ExperienceInfo> manageList) {
		int minManageYear = 2006;
		int manageLength = manageList.size();

		if (tLevel <= 13 && tLevel >= 10) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getworkLevel() >= 6
						&& manageList.get(i).getworkLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 9 && tLevel >= 7) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getworkLevel() >= 5
						&& manageList.get(i).getworkLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 6 && tLevel >= 4) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getworkLevel() >= 3
						&& manageList.get(i).getworkLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		}

		int minYear = (techMinYear < minManageYear) ? techMinYear
				: minManageYear;

		return (2006 - minYear + 1);
	}

	// 获取中断工龄
	public int getBreakUpYears(ArrayList<Date> array1, ArrayList<Date> array2,
			int arrayNum) {
		int breakUpYears = 0;
		for (int i = 0; i < arrayNum; i++)
			breakUpYears = breakUpYears + dateDif(array1.get(i), array2.get(i));
		System.out.println("中断工龄：" + breakUpYears);
		return breakUpYears;
	}

	// 获取工作前工龄
	public int getBeforeWorkTime(ArrayList<ExperienceInfo> eduList) {
		int beforeWorkTime = 0;
		int eduLength = eduList.size();
		for (int i = 0; i < eduLength; i++) {
			if (eduList.get(i).getwork().equals("博士")) {
				beforeWorkTime = 5;
			} else if (eduList.get(i).getwork().equals("硕士")) {
				if (beforeWorkTime == 0)
					beforeWorkTime = 2;
			}
		}
		return beforeWorkTime;
	}

	// 获取不计算工龄的在校学习时间
	public int getStudyInSchoolTime(ArrayList<ExperienceInfo> eduList) {
		int studyInSchoolTime = 0;
		int eduLength = eduList.size();
		for (int i = 0; i < eduLength; i++) {
			if (eduList.get(i).getwork().equals("本科")) {
				studyInSchoolTime = 4;
			} else if (eduList.get(i).getwork().equals("专科")) {
				if (studyInSchoolTime == 0)
					studyInSchoolTime = 3;
			}
		}
		return studyInSchoolTime;
	}

	// 获取实际工作年限
	@SuppressWarnings("deprecation")
	public int getRealWorkTime(Date attendWorkDate, ArrayList<Date> array1,
			ArrayList<Date> array2, int arrayNum) {
		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);
		if (attendWorkDate.after(baseWorkDate))
			return 0;

		int realWorkTime = 0;
		realWorkTime = 2006 - (1900 + attendWorkDate.getYear()) + 1
				- getBreakUpYears(array1, array2, arrayNum);
		return realWorkTime;
	}

	// 获取套改年限
	public int getSalaryChangeYears(Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			ArrayList<ExperienceInfo> eduList, int failTime) {
		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);
		if (attendWorkDate.after(baseWorkDate))
			return 0;

		int salaryChangeTime = 0;

		salaryChangeTime = getRealWorkTime(attendWorkDate, array1, array2,
				arrayNum)
				+ getBeforeWorkTime(eduList)
				+ getStudyInSchoolTime(eduList) - failTime;
		return salaryChangeTime;
	}

	// 获取任职年限
	@SuppressWarnings("unused")
	public int getOfficeTime(ArrayList<ExperienceInfo> manageList,
			ArrayList<ExperienceInfo> techList,
			ArrayList<ExperienceInfo> eduList, Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			int failTime, ArrayList<ExperienceInfo> worList) {

		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);

		int officeTime = 0;
		int level = 0;
		int wageMax = 0;

		if (worList.size() == 0) {
			if (attendWorkDate.before(baseWorkDate)) {
				// 管理系第一大，第二大
				int manageMaxLevel = 0;
				int manageMinYear1 = 2006;
				int manageSecMaxLevel = 0;
				int manageMinYear2 = 2006;

				// 专技系第一大，第二大
				int techMaxLevel = 0;
				int techMinYear1 = 2006;
				int techSecMaxLevel = 0;
				int techMinYear2 = 2006;

				int manageLength = manageList.size();
				if (manageLength == 0) {
				} else if (manageLength == 1) {
					if (manageList.get(0).getTime() <= 2006) {
						manageMaxLevel = manageList.get(0).getworkLevel();
						manageMinYear1 = manageList.get(0).getTime();
					} else {
						System.out.println("管理系列倒推");
						int posLevel = manageList.get(0).getworkLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				} else {
					for (int i = 0; i < manageLength - 1; i++) {
						for (int j = i + 1; j < manageLength; j++) {
							if (manageList.get(i).getworkLevel() < manageList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = manageList
										.get(i);
								manageList.set(i, manageList.get(j));
								manageList.set(j, tempExperienceInfo);
							}
						}
					}
					int count1 = 0;
					for (int i = 0; i < manageLength; i++) {
						if (manageList.get(i).getTime() <= 2006) {
							if (count1 == 0) {
								manageMaxLevel = manageList.get(i)
										.getworkLevel();
								manageMinYear1 = manageList.get(i).getTime();
								count1++;
							} else if (count1 == 1) {
								manageSecMaxLevel = manageList.get(i)
										.getworkLevel();
								manageMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (count1 == 0) {
						System.out.println("管理系列倒推");
						for (int i = 0; i < manageLength - 1; i++) {
							for (int j = i + 1; j < manageLength; j++) {
								if (manageList.get(i).getTime() > manageList
										.get(j).getTime()) {
									ExperienceInfo tempExperienceInfo = manageList
											.get(i);
									manageList.set(i, manageList.get(j));
									manageList.set(j, tempExperienceInfo);
								}
							}
						}
						int posLevel = manageList.get(0).getworkLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				}

				int eduMax = 0;
				for (int i = 0; i < eduList.size(); i++) {
					if (eduList.get(i).getwork().equals("博士")) {
						eduMax = 4;
						break;
					} else if (eduList.get(i).getwork().equals("硕士")) {
						if (eduMax < 3) {
							eduMax = 3;
						}
					} else if (eduList.get(i).getwork().equals("本科")) {
						if (eduMax < 2) {
							eduMax = 2;
						}
					} else if (eduList.get(i).getwork().equals("专科")) {
						if (eduMax < 1) {
							eduMax = 1;
						}
					}
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getworkLevel();
						techMinYear1 = techList.get(0).getTime();
					} else {
						System.out.println("专技系列倒推");
						int payLevel = techList.get(0).getworkLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				} else {
					for (int i = 0; i < techLength - 1; i++) {
						for (int j = i + 1; j < techLength; j++) {
							if (techList.get(i).getworkLevel() < techList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = techList
										.get(i);
								techList.set(i, techList.get(j));
								techList.set(j, tempExperienceInfo);
							}
						}
					}
					int count2 = 0;
					for (int i = 0; i < techLength; i++) {
						if (techList.get(i).getTime() <= 2006) {
							if (count2 == 0) {
								techMaxLevel = techList.get(i).getworkLevel();
								techMinYear1 = techList.get(i).getTime();
								count2++;
							} else if (count2 == 1) {
								techSecMaxLevel = techList.get(i)
										.getworkLevel();
								techMinYear2 = techList.get(i).getTime();
								break;
							}
						}
					}

					if (count2 == 0) {
						System.out.println("专技系列倒推");
						for (int i = 0; i < techLength - 1; i++) {
							for (int j = i + 1; j < techLength; j++) {
								if (techList.get(i).getTime() > techList.get(j)
										.getTime()) {
									ExperienceInfo tempExperienceInfo = techList
											.get(i);
									techList.set(i, techList.get(j));
									techList.set(j, tempExperienceInfo);
								}
							}
						}
						int payLevel = techList.get(0).getworkLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				}

				if (manageMaxLevel == 0) {
					;
				} else {
					if (manageSecMaxLevel == 0) {
						System.out.println("管理系列：");
						int curOfficeTime = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < manageSalaryManage.findManPosSalByLevel(
								11 - manageMaxLevel).getStartPayLevel())
							curLevel = manageSalaryManage.findManPosSalByLevel(
									11 - manageMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
							officeTime = curOfficeTime;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel;
							officeTime = curOfficeTime;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("管理系列1：");
						int officeTime1 = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < manageSalaryManage
								.findManPosSalByLevel(11 - manageMaxLevel)
								.getStartPayLevel())
							curLevel1 = manageSalaryManage
									.findManPosSalByLevel(11 - manageMaxLevel)
									.getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
							officeTime = officeTime1;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel1;
							officeTime = officeTime1;
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("管理系列2：");
						int officeTime2 = getManageOfficeTime(
								manageSecMaxLevel, manageMinYear2, techList);
						System.out.println("职务等级：  " + manageSecMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel2 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = manageSalaryManage.getPayLevel(
									11 - manageSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < manageSalaryManage
								.findManPosSalByLevel(11 - manageSecMaxLevel)
								.getStartPayLevel())
							curLevel2 = manageSalaryManage
									.findManPosSalByLevel(
											11 - manageSecMaxLevel)
									.getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
							officeTime = officeTime2;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							officeTime = officeTime2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}

				if (techMaxLevel == 0) {
					;
				} else {
					if (techSecMaxLevel == 0) {
						System.out.println("专技系列：");
						int curOfficeTime = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = profSalaryManage.getPayLevel(
									techMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
							officeTime = curOfficeTime;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel;
							officeTime = curOfficeTime;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("专技系列1：");
						int officeTime1 = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (profSalaryManage == null) {
							System.out.println("ProfSalaryManage is null!");
						}
						System.out.println(techMaxLevel);
						System.out.println(officeTime1);
						System.out.println(getSalaryChangeYears(attendWorkDate,
								array1, array2, arrayNum, eduList, failTime));
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = profSalaryManage.getPayLevel(
									techMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
							officeTime = officeTime1;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel1;
							officeTime = officeTime1;
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("专技系列2：");
						int officeTime2 = getTechOfficeTime(techMaxLevel,
								techMinYear2, manageList);
						System.out.println("职务等级：  " + techSecMaxLevel);
						System.out.println("任职年限：  " + officeTime2);
						int curLevel2 = 0;

						if (profSalaryManage.getPayLevel(
								techSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = profSalaryManage.getPayLevel(
									techSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
							officeTime = officeTime2;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							officeTime = officeTime2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}
			}
		} else {
			if (attendWorkDate.before(baseWorkDate)) {
				int worMaxLevel = 0;
				int worMinYear1 = 2006;
				int worSecMaxLevel = 0;
				int worMinYear2 = 2006;

				int worLength = worList.size();

				if (worLength == 1) {
					if (worList.get(0).getTime() <= 2006) {
						worMaxLevel = worList.get(0).getworkLevel();
						worMinYear1 = worList.get(0).getTime();
					}
				} else {
					for (int i = 0; i < worLength - 1; i++) {
						for (int j = i + 1; j < worLength; j++) {
							if (worList.get(i).getworkLevel() < worList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = worList
										.get(i);
								worList.set(i, worList.get(j));
								worList.set(j, tempExperienceInfo);
							}
						}
					}
					int count = 0;
					for (int i = 0; i < worLength; i++) {
						if (worList.get(i).getTime() <= 2006) {
							if (count == 0) {
								worMaxLevel = worList.get(i).getworkLevel();
								worMinYear1 = worList.get(i).getTime();
								count++;
							} else if (count == 1) {
								worSecMaxLevel = worList.get(i)
										.getworkLevel();
								worMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (worMaxLevel == 0) {
						;
					} else {
						if (worSecMaxLevel == 0) {
							System.out.println("工人系列：");
							int curOfficeTime = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + curOfficeTime);
							int curLevel = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel = workerSalaryManage.getPayLevel(
										worMaxLevel,
										curOfficeTime,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel > level) {
								level = curLevel;
								officeTime = curOfficeTime;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard();
								level = curLevel;
								officeTime = curOfficeTime;
							}
							System.out.println("对应薪级：  " + curLevel);
						} else {
							System.out.println("工人系列1：");
							int officeTime1 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime1);
							int curLevel1 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel1 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime1,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel1 > level) {
								level = curLevel1;
								officeTime = officeTime1;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard();
								level = curLevel1;
								officeTime = officeTime1;
							}
							System.out.println("对应薪级：  " + curLevel1);

							System.out.println("工人系列2：");
							int officeTime2 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime2);
							int curLevel2 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel2 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime2,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel2 > level) {
								level = curLevel2;
								officeTime = officeTime2;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard();
								level = curLevel2;
								officeTime = officeTime2;
							}
							System.out.println("对应薪级：  " + curLevel2);
						}
					}
				}
			}
		}
		return officeTime;
	}

	// 获取薪级
	@SuppressWarnings({ "deprecation", "unused" })
	public int getSalaryLevel(ArrayList<ExperienceInfo> manageList,
			ArrayList<ExperienceInfo> techList,
			ArrayList<ExperienceInfo> eduList, Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			int failTime, ArrayList<ExperienceInfo> worList) {
		int level = 0;
		int wageMax = 0;

		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);

		if (worList.size() == 0) {
			if (attendWorkDate.before(baseWorkDate)) {
				// 管理系第一大，第二大
				int manageMaxLevel = 0;
				int manageMinYear1 = 2006;
				int manageSecMaxLevel = 0;
				int manageMinYear2 = 2006;

				// 专技系第一大，第二大
				int techMaxLevel = 0;
				int techMinYear1 = 2006;
				int techSecMaxLevel = 0;
				int techMinYear2 = 2006;

				int manageLength = manageList.size();
				if (manageLength == 0) {
				} else if (manageLength == 1) {
					if (manageList.get(0).getTime() <= 2006) {
						manageMaxLevel = manageList.get(0).getworkLevel();
						manageMinYear1 = manageList.get(0).getTime();
					} else {
						System.out.println("管理系列倒推");
						int posLevel = manageList.get(0).getworkLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				} else {
					for (int i = 0; i < manageLength - 1; i++) {
						for (int j = i + 1; j < manageLength; j++) {
							if (manageList.get(i).getworkLevel() < manageList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = manageList
										.get(i);
								manageList.set(i, manageList.get(j));
								manageList.set(j, tempExperienceInfo);
							}
						}
					}
					int count1 = 0;
					for (int i = 0; i < manageLength; i++) {
						if (manageList.get(i).getTime() <= 2006) {
							if (count1 == 0) {
								manageMaxLevel = manageList.get(i)
										.getworkLevel();
								manageMinYear1 = manageList.get(i).getTime();
								count1++;
							} else if (count1 == 1) {
								manageSecMaxLevel = manageList.get(i)
										.getworkLevel();
								manageMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (count1 == 0) {
						System.out.println("管理系列倒推");
						for (int i = 0; i < manageLength - 1; i++) {
							for (int j = i + 1; j < manageLength; j++) {
								if (manageList.get(i).getTime() > manageList
										.get(j).getTime()) {
									ExperienceInfo tempExperienceInfo = manageList
											.get(i);
									manageList.set(i, manageList.get(j));
									manageList.set(j, tempExperienceInfo);
								}
							}
						}
						int posLevel = manageList.get(0).getworkLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				}

				int eduMax = 0;
				for (int i = 0; i < eduList.size(); i++) {
					if (eduList.get(i).getwork().equals("博士")) {
						eduMax = 4;
						break;
					} else if (eduList.get(i).getwork().equals("硕士")) {
						if (eduMax < 3) {
							eduMax = 3;
						}
					} else if (eduList.get(i).getwork().equals("本科")) {
						if (eduMax < 2) {
							eduMax = 2;
						}
					} else if (eduList.get(i).getwork().equals("专科")) {
						if (eduMax < 1) {
							eduMax = 1;
						}
					}
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getworkLevel();
						techMinYear1 = techList.get(0).getTime();
					} else {
						System.out.println("专技系列倒推");
						int payLevel = techList.get(0).getworkLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				} else {
					for (int i = 0; i < techLength - 1; i++) {
						for (int j = i + 1; j < techLength; j++) {
							if (techList.get(i).getworkLevel() < techList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = techList
										.get(i);
								techList.set(i, techList.get(j));
								techList.set(j, tempExperienceInfo);
							}
						}
					}
					int count2 = 0;
					for (int i = 0; i < techLength; i++) {
						if (techList.get(i).getTime() <= 2006) {
							if (count2 == 0) {
								techMaxLevel = techList.get(i).getworkLevel();
								techMinYear1 = techList.get(i).getTime();
								count2++;
							} else if (count2 == 1) {
								techSecMaxLevel = techList.get(i)
										.getworkLevel();
								techMinYear2 = techList.get(i).getTime();
								break;
							}
						}
					}

					if (count2 == 0) {
						System.out.println("专技系列倒推");
						for (int i = 0; i < techLength - 1; i++) {
							for (int j = i + 1; j < techLength; j++) {
								if (techList.get(i).getTime() > techList.get(j)
										.getTime()) {
									ExperienceInfo tempExperienceInfo = techList
											.get(i);
									techList.set(i, techList.get(j));
									techList.set(j, tempExperienceInfo);
								}
							}
						}
						int payLevel = techList.get(0).getworkLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				}

				if (manageMaxLevel == 0) {
					;
				} else {
					if (manageSecMaxLevel == 0) {
						System.out.println("管理系列：");
						int curOfficeTime = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < manageSalaryManage.findManPosSalByLevel(
								11 - manageMaxLevel).getStartPayLevel())
							curLevel = manageSalaryManage.findManPosSalByLevel(
									11 - manageMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("管理系列1：");
						int officeTime1 = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < manageSalaryManage
								.findManPosSalByLevel(11 - manageMaxLevel)
								.getStartPayLevel())
							curLevel1 = manageSalaryManage
									.findManPosSalByLevel(11 - manageMaxLevel)
									.getStartPayLevel();
						System.out.println("level=" + level);
						/*if (curLevel1 > level) {
							level = curLevel1;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel1;
						}
						System.out.println("level=" + level);
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("管理系列2：");
						int officeTime2 = getManageOfficeTime(
								manageSecMaxLevel, manageMinYear2, techList);
						System.out.println("职务等级：  " + manageSecMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel2 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = manageSalaryManage.getPayLevel(
									11 - manageSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < manageSalaryManage
								.findManPosSalByLevel(11 - manageSecMaxLevel)
								.getStartPayLevel())
							curLevel2 = manageSalaryManage
									.findManPosSalByLevel(
											11 - manageSecMaxLevel)
									.getStartPayLevel();
						System.out.println("level=" + level);
						/*if (curLevel2 > level) {
							level = curLevel2;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard();
							level = curLevel2;
						}
						System.out.println("level=" + level);
						System.out.println("对应薪级：  " + curLevel2);
					}
				}

				if (techMaxLevel == 0) {
					;
				} else {
					if (techSecMaxLevel == 0) {
						System.out.println("专技系列：");
						int curOfficeTime = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = profSalaryManage.getPayLevel(
									techMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("专技系列1：");
						int officeTime1 = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = profSalaryManage.getPayLevel(
									techMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel1;
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("专技系列2：");
						int officeTime2 = getTechOfficeTime(techMaxLevel,
								techMinYear2, manageList);
						System.out.println("职务等级：  " + techSecMaxLevel);
						System.out.println("任职年限：  " + officeTime2);
						int curLevel2 = 0;
						if (profSalaryManage.getPayLevel(
								techSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = profSalaryManage.getPayLevel(
									techSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard();
							level = curLevel2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}
				level = level + (new Date().getYear() + 1900 - 2006);
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() + 1900 - 2006 + 5) > level)
								level = new Date().getYear() + 1900 - 2006 + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() + 1900 - 2006 + 7) > level)
								level = new Date().getYear() + 1900 - 2006 + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() + 1900 - 2006 + 9) > level)
								level = new Date().getYear() + 1900 - 2006 + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() + 1900 - 2006 + 11) > level)
								level = new Date().getYear() + 1900 - 2006 + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() + 1900 - 2006 + 14) > level)
								level = new Date().getYear() + 1900 - 2006 + 14;
						}
					}
				}
			}
		} else {
			if (attendWorkDate.before(baseWorkDate)) {
				int worMaxLevel = 0;
				int worMinYear1 = 2006;
				int worSecMaxLevel = 0;
				int worMinYear2 = 2006;

				int worLength = worList.size();

				if (worLength == 1) {
					if (worList.get(0).getTime() <= 2006) {
						worMaxLevel = worList.get(0).getworkLevel();
						worMinYear1 = worList.get(0).getTime();
					}
				} else {
					for (int i = 0; i < worLength - 1; i++) {
						for (int j = i + 1; j < worLength; j++) {
							if (worList.get(i).getworkLevel() < worList
									.get(j).getworkLevel()) {
								ExperienceInfo tempExperienceInfo = worList
										.get(i);
								worList.set(i, worList.get(j));
								worList.set(j, tempExperienceInfo);
							}
						}
					}
					int count = 0;
					for (int i = 0; i < worLength; i++) {
						if (worList.get(i).getTime() <= 2006) {
							if (count == 0) {
								worMaxLevel = worList.get(i).getworkLevel();
								worMinYear1 = worList.get(i).getTime();
								count++;
							} else if (count == 1) {
								worSecMaxLevel = worList.get(i)
										.getworkLevel();
								worMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (worMaxLevel == 0) {
						;
					} else {
						if (worSecMaxLevel == 0) {
							System.out.println("工人系列：");
							int curOfficeTime = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + curOfficeTime);
							int curLevel = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel = workerSalaryManage.getPayLevel(
										worMaxLevel,
										curOfficeTime,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel > level) {
								level = curLevel;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard();
								level = curLevel;
							}
							System.out.println("对应薪级：  " + curLevel);
						} else {
							System.out.println("工人系列1：");
							int officeTime1 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime1);
							int curLevel1 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel1 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime1,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel1 > level) {
								level = curLevel1;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard();
								level = curLevel1;
							}
							System.out.println("对应薪级：  " + curLevel1);

							System.out.println("工人系列2：");
							int officeTime2 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime2);
							int curLevel2 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel2 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime2,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel2 > level) {
								level = curLevel2;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard();
								level = curLevel2;
							}
							System.out.println("对应薪级：  " + curLevel2);
						}
					}
				}
				level = level + (new Date().getYear() + 1900 - 2006);
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() + 1900 - 2006 + 5) > level)
								level = new Date().getYear() + 1900 - 2006 + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() + 1900 - 2006 + 7) > level)
								level = new Date().getYear() + 1900 - 2006 + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() + 1900 - 2006 + 9) > level)
								level = new Date().getYear() + 1900 - 2006 + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() + 1900 - 2006 + 11) > level)
								level = new Date().getYear() + 1900 - 2006 + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() + 1900 - 2006 + 14) > level)
								level = new Date().getYear() + 1900 - 2006 + 14;
						}
					}
				}
			}
		}
		if (level == 0)
			level = 1;
		System.out.println("Final Level=" + level);
		return level;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String importStaff() {
		System.out.println("-------startSalaryInfoAction.importStaff--------"
				+ startSalaryInfo.getEid());
		if (isValid(startSalaryInfo.getEid())) {
			if (employeeManage.findEmployeeById(startSalaryInfo.getEid()) != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				startSalaryInfo.setOperateDate(new Date());

				Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
				String baseDateStr = "2006-07-01";
				baseWorkDate = strToDate(baseDateStr);
				
				Date attendWorkDate = strToDate(startWorkYear);

				ArrayList<Date> array1 = new ArrayList<Date>(), array2 = new ArrayList<Date>();
				ArrayList<ExperienceInfo> manageList = new ArrayList<ExperienceInfo>(), techList = new ArrayList<ExperienceInfo>(), eduList = new ArrayList<ExperienceInfo>(), worList = new ArrayList<ExperienceInfo>();

				System.out.println("管理i:" + i);
				System.out.println("专技j:" + j);
				System.out.println("教育k:" + k);
				System.out.println("中断l:" + l);
				System.out.println("工人m:" + m);

				for (int count = 0; count < i; count++) {
					System.out.println(request.getParameter("manExperience"
							+ count));
					System.out.println(request.getParameter("manWorkDate"
							+ count));
					manageList.add(new ExperienceInfo(request
							.getParameter("manExperience" + count), Integer
							.parseInt(request.getParameter("manWorkDate"
									+ count))));
					experiencesManage.addExperiences(new Experiences(
							startSalaryInfo.getEid(), 1,
							Integer.parseInt(request.getParameter("manWorkDate"
									+ count)),
							request.getParameter("manExperience" + count)));
				}

				for (int count = 0; count < j; count++) {
					System.out.println(request.getParameter("proExperience"
							+ count));
					System.out.println(request.getParameter("proWorkDate"
							+ count));
					techList.add(new ExperienceInfo(request
							.getParameter("proExperience" + count), Integer
							.parseInt(request.getParameter("proWorkDate"
									+ count))));
					experiencesManage.addExperiences(new Experiences(
							startSalaryInfo.getEid(), 2,
							Integer.parseInt(request.getParameter("proWorkDate"
									+ count)),
							request.getParameter("proExperience" + count)));
				}

				for (int count = 0; count < k; count++) {
					System.out.println(request.getParameter("eduExperience"
							+ count));
					System.out.println(request.getParameter("eduWorkDate"
							+ count));
					eduList.add(new ExperienceInfo(request
							.getParameter("eduExperience" + count), Integer
							.parseInt(request.getParameter("eduWorkDate"
									+ count))));
					experiencesManage.addExperiences(new Experiences(
							startSalaryInfo.getEid(), 0,
							Integer.parseInt(request.getParameter("eduWorkDate"
									+ count)),
							request.getParameter("eduExperience" + count)));
				}

				for (int count = 0; count < m; count++) {
					System.out.println(request.getParameter("workerExperience"
							+ count));
					System.out.println(request.getParameter("workerWorkDate"
							+ count));
					worList.add(new ExperienceInfo(request
							.getParameter("workerExperience" + count), Integer
							.parseInt(request.getParameter("workerWorkDate"
									+ count))));
					experiencesManage.addExperiences(new Experiences(
							startSalaryInfo.getEid(), 3,
							Integer.parseInt(request
									.getParameter("workerWorkDate" + count)),
							request.getParameter("workerExperience" + count)));
				}

				for (int count = 0; count < l; count++) {
					Date sDate = strToDate(request.getParameter("breakStartDate" + count));
					Date eDate = strToDate(request.getParameter("breakEndDate" + count));
					if (eDate.before(baseWorkDate)) {
						array1.add(sDate);
						array2.add(eDate);
					}
					else {
						if (sDate.before(baseWorkDate)) {
							array1.add(sDate);
							array2.add(baseWorkDate);
						}
					}
					offInfoManage.addOffInfo(new OffInfo(startSalaryInfo.getEid(), strToDate(request.getParameter("breakStartDate" + count)), strToDate(request.getParameter("breakEndDate" + count)), "不详"));
				}

				startSalaryInfo.setBreakOffSeniority(getBreakUpYears(array1,
						array2, l));// 获取中断工龄

				startSalaryInfo.setWorkYears(getRealWorkTime(attendWorkDate,
						array1, array2, l));// 获取实际工作年限

				startSalaryInfo
						.setSeniorityBeforeWork(getBeforeWorkTime(eduList));// 获取工作前工龄

				startSalaryInfo
						.setLearnSeniority(getStudyInSchoolTime(eduList));// 获取大专以上不计工龄年限

				startSalaryInfo.setChangeYears(getSalaryChangeYears(
						attendWorkDate, array1, array2, l, eduList, failTime));// 获取套改年限
				System.out
						.println("套改年限：  " + startSalaryInfo.getChangeYears());

				startSalaryInfo.setHireYears(getOfficeTime(manageList,
						techList, eduList, attendWorkDate, array1, array2, l,
						failTime, worList));// 获取任职年限
				System.out.println("任职年限：  " + startSalaryInfo.getHireYears());

				startSalaryInfo.setSalaryLevel(getSalaryLevel(manageList,
						techList, eduList, attendWorkDate, array1, array2, l,
						failTime, worList));// 获取薪级
				System.out.println("薪级：  " + startSalaryInfo.getSalaryLevel());

				if (startSalaryInfo.getSalarySeries().equals("管理")) {
					startSalaryInfo.setPositionSalary(manageSalaryManage
							.findManPosSalByLevel(
									startSalaryInfo.getPositionLevel())
							.getSalaryStandard());
					startSalaryInfo.setLevelSalary(manageSalaryManage
							.findManPaySalByPayLevel(
									startSalaryInfo.getSalaryLevel())
							.getSalaryStandard());
				} else if (startSalaryInfo.getSalarySeries().equals("专技")) {
					startSalaryInfo.setPositionSalary(profSalaryManage
							.findProfPosSalByLevel(
									startSalaryInfo.getPositionLevel())
							.getSalaryStandard());
					startSalaryInfo.setLevelSalary(profSalaryManage
							.findProfPaySalByPayLevel(
									startSalaryInfo.getSalaryLevel())
							.getSalaryStandard());
				} else if (startSalaryInfo.getSalarySeries().equals("工人")) {
					startSalaryInfo.setPositionSalary(workerSalaryManage
							.findWorkerPosSalByLevel(
									startSalaryInfo.getPositionLevel())
							.getSalaryStandard());
					startSalaryInfo.setLevelSalary(workerSalaryManage
							.findWorkerPaySalByPayLevel(
									startSalaryInfo.getSalaryLevel())
							.getSalaryStandard());
				}

				Map session = ActionContext.getContext().getSession();
				session.put("ssInfo", startSalaryInfo);
				session.put("sYear", startWorkYear);
				session.put("fTime", failTime + "");
				session.put("mList", manageList);
				session.put("tList", techList);
				session.put("wList", worList);
				session.put("eList", eduList);
				session.put("salaryInfo", "增添成功");
				return "success";
			}
			else {
				ActionContext.getContext().getSession().put("salaryInfo", "职工号不存在！");
				return "daiqixin";
			}
		}
		ActionContext.getContext().getSession().put("salaryInfo", "职工号非法！");
		return "daiqixin";
	}

	public String addSalaryInfo() {
		System.out.println("-------startSalaryInfoAction.importStaff--------"
				+ startSalaryInfo.getEid());
		startSalaryInfo.setOperateDate(new Date());
		startSalaryInfoManage.addStartSalaryInfo(startSalaryInfo);
		ActionContext.getContext().getSession().put("salaryInfo", "增加成功！");
		return "success";
	}
}
