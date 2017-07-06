package com.xin.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import com.xin.bean.ExperienceInfo;
import com.xin.service.IManageSalaryManage;
import com.xin.service.IProfSalaryManage;
import com.xin.service.IWorkerSalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class LevelSalaryChange {
    
    
	
        
        /**
         * 创建一个新的实例 LevelSalaryChange.
         *
         */
        
    public LevelSalaryChange() {
        super();
    }

        /**
         * 创建一个新的实例 LevelSalaryChange.
         *
         * @param manageSalaryManage
         * @param profSalaryManage
         * @param workerSalaryManage
         */
        
    public LevelSalaryChange(IManageSalaryManage manageSalaryManage,
                             IProfSalaryManage profSalaryManage,
                             IWorkerSalaryManage workerSalaryManage) {
        super();
        this.manageSalaryManage = manageSalaryManage;
        this.profSalaryManage = profSalaryManage;
        this.workerSalaryManage = workerSalaryManage;
    }

    @Resource
	private IManageSalaryManage manageSalaryManage;

	public IManageSalaryManage getManageSalaryManage() {
		System.out.println("get manageSalaryManage");
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		System.out.println("set manageSalaryManage");
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
	public int getBreakUpYears(ArrayList<Date> array1,
			ArrayList<Date> array2, int arrayNum) {
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
	public int getRealWorkTime(Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum) {
		int realWorkTime = 0;
		realWorkTime = 2006 - (1900 + attendWorkDate.getYear()) + 1
				- getBreakUpYears(array1, array2, arrayNum);
		return realWorkTime;
	}

	// 获取套改年限
	public int getSalaryChangeYears(Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			ArrayList<ExperienceInfo> eduList, int failTime) {
		int salaryChangeTime = 0;
		salaryChangeTime = getRealWorkTime(attendWorkDate, array1, array2,
				arrayNum)
				+ getBeforeWorkTime(eduList)
				+ getStudyInSchoolTime(eduList) - failTime;
		return salaryChangeTime;
	}

	// 获取任职年限
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
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getworkLevel();
						techMinYear1 = techList.get(0).getTime();
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
						if (curLevel > level) {
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
						System.out.println();
						if(manageSalaryManage==null){
							System.out.println("manageSalaryManage null");
						}
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
						if (curLevel1 > level) {
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
						if (curLevel2 > level) {
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						if (curLevel > level) {
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
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						if (curLevel1 > level) {
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						if (curLevel2 > level) {
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
				@SuppressWarnings("unused")
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel > level) {
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel1 > level) {
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel2 > level) {
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
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getworkLevel();
						techMinYear1 = techList.get(0).getTime();
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel < manageSalaryManage.findManPosSalByLevel(
								11 - manageMaxLevel).getStartPayLevel())
							curLevel = manageSalaryManage.findManPosSalByLevel(
									11 - manageMaxLevel).getStartPayLevel();
						if (curLevel > level) {
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel1 < manageSalaryManage
								.findManPosSalByLevel(11 - manageMaxLevel)
								.getStartPayLevel())
							curLevel1 = manageSalaryManage
									.findManPosSalByLevel(11 - manageMaxLevel)
									.getStartPayLevel();
						if (curLevel1 > level) {
							level = curLevel1;
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel2 < manageSalaryManage
								.findManPosSalByLevel(11 - manageSecMaxLevel)
								.getStartPayLevel())
							curLevel2 = manageSalaryManage
									.findManPosSalByLevel(
											11 - manageSecMaxLevel)
									.getStartPayLevel();
						if (curLevel2 > level) {
							level = curLevel2;
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						if (curLevel > level) {
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						if (curLevel1 > level) {
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
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						if (curLevel2 > level) {
							level = curLevel2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}
				level = level + (new Date().getYear() - 2006);
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() - 2006 + 5) > level)
								level = new Date().getYear() - 2006 + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() - 2006 + 7) > level)
								level = new Date().getYear() - 2006 + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() - 2006 + 9) > level)
								level = new Date().getYear() - 2006 + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() - 2006 + 11) > level)
								level = new Date().getYear() - 2006 + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() - 2006 + 14) > level)
								level = new Date().getYear() - 2006 + 14;
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel > level) {
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel1 > level) {
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
											array1, array2, arrayNum, eduList,
											failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							if (curLevel2 > level) {
								level = curLevel2;
							}
							System.out.println("对应薪级：  " + curLevel2);
						}
					}
				}
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear()
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear()
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getwork().equals("专科")) {
							if ((new Date().getYear() - 2006 + 5) > level)
								level = new Date().getYear() - 2006 + 5;
						} else if (eduList.get(i).getwork().equals("本科")) {
							if ((new Date().getYear() - 2006 + 7) > level)
								level = new Date().getYear() - 2006 + 7;
						} else if (eduList.get(i).getwork().equals("双学士")) {
							if ((new Date().getYear() - 2006 + 9) > level)
								level = new Date().getYear() - 2006 + 9;
						} else if (eduList.get(i).getwork().equals("硕士")) {
							if ((new Date().getYear() - 2006 + 11) > level)
								level = new Date().getYear() - 2006 + 11;
						} else if (eduList.get(i).getwork().equals("博士")) {
							if ((new Date().getYear() - 2006 + 14) > level)
								level = new Date().getYear() - 2006 + 14;
						}
					}
				}
			}
		}
		return level;
	}
}