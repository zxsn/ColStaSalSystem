
    /**  
    * @Title: AutoSalary.java
    * @Package com.xin.action
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 追鑫少年
    * @date 2017年6月1日
    * @version V1.0  
    */
    
package com.xin.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xin.bean.Employee;
import com.xin.bean.Salary;
import com.xin.bean.StartSalaryInfo;
import com.xin.exception.ExcelException;
import com.xin.other.ComputeSalarySingleton;
import com.xin.other.SalaryExport;
import com.xin.service.IEmployeeManage;
import com.xin.service.ISalaryManage;
import com.xin.service.IStartSalaryInfoManage;
import com.xin.util.ExcelUtil;

/**
    * @ClassName: AutoSalary
    * @Description: TODO(工资自动生成)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
    */

public class AutoSalary {
    private List<SalaryExport> newSalaryList; 
    private ComputeSalarySingleton computeSalarySingleton=ComputeSalarySingleton.getInstance();
    
    
    public ISalaryManage getiSalaryManage() {
        return iSalaryManage;
    }


    public void setiSalaryManage(ISalaryManage iSalaryManage) {
        this.iSalaryManage = iSalaryManage;
    }


    public IEmployeeManage getiEmployeeManage() {
        return iEmployeeManage;
    }


    public void setiEmployeeManage(IEmployeeManage iEmployeeManage) {
        this.iEmployeeManage = iEmployeeManage;
    }


    public IStartSalaryInfoManage getiStartSalaryInfoManage() {
        return iStartSalaryInfoManage;
    }


    public void setiStartSalaryInfoManage(IStartSalaryInfoManage iStartSalaryInfoManage) {
        this.iStartSalaryInfoManage = iStartSalaryInfoManage;
    }


        /**
         * 创建一个新的实例 AutoSalary.
         *
         */
        
    public AutoSalary() {
        super();
    }

    
            /**
             * 创建一个新的实例 AutoSalary.
             *
             * @param newSalaryList
             * @param computeSalarySingleton
             * @param iSalaryManage
             * @param iEmployeeManage
             * @param iStartSalaryInfoManage
             */
            
        public AutoSalary(List<SalaryExport> newSalaryList,
                          ComputeSalarySingleton computeSalarySingleton,
                          ISalaryManage iSalaryManage, IEmployeeManage iEmployeeManage,
                          IStartSalaryInfoManage iStartSalaryInfoManage) {
            super();
            this.newSalaryList = newSalaryList;
            this.computeSalarySingleton = computeSalarySingleton;
            this.iSalaryManage = iSalaryManage;
            this.iEmployeeManage = iEmployeeManage;
            this.iStartSalaryInfoManage = iStartSalaryInfoManage;
        }

    @Resource
    private ISalaryManage iSalaryManage;
    
    @Resource
    private IEmployeeManage iEmployeeManage;
    
    @Resource
    private IStartSalaryInfoManage iStartSalaryInfoManage;

    public void initSalaryList(){       
        newSalaryList=new ArrayList<SalaryExport>();
        List<StartSalaryInfo> list = iStartSalaryInfoManage.getAllStartSalaryInfo();
        
        for(int i=0;i<list.size();i++){
            StartSalaryInfo startSalaryInfo=list.get(i);
            
            Salary salary =new Salary(startSalaryInfo.getEid(),startSalaryInfo.getPositionSalary(),startSalaryInfo.getLevelSalary());
            computeSalarySingleton.setSalary(salary);
            iSalaryManage.addSalary(salary);
            
            Employee employee=iEmployeeManage.findEmployeeById(startSalaryInfo.getEid());
            if(employee==null){
                System.out.println("cao");
                System.out.println(startSalaryInfo.getEid());
            }
            SalaryExport salaryExport=new SalaryExport(startSalaryInfo.getEid(), employee.getName(), employee.getDepartment(), salary.getPositionSalary(), salary.getLevelSalary(), salary.getTotleSalary(), salary.getTime());
            newSalaryList.add(salaryExport);
        }
    }
    
    public String computeSalary(){
        initSalaryList();
        
        ActionContext.getContext().getSession().put("newSalaryList", newSalaryList);
        return Action.SUCCESS;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String exportSalary() throws ExcelException{
        LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
        
        fieldMap.put("eid", "职工号");
        fieldMap.put("name", "姓名");
        fieldMap.put("department", "单位");
        fieldMap.put("positionSalary", "岗位工资");
        fieldMap.put("levelSalary", "级别工资");
        fieldMap.put("salary", "月薪");
        fieldMap.put("date", "发放日期");
         
        String sheetName="Sheet1";
        HttpServletResponse response = ServletActionContext.getResponse();
        
        initSalaryList();
        ExcelUtil.listToExcel(newSalaryList, fieldMap, sheetName, response);
        
        return Action.SUCCESS;
    }

    public List<SalaryExport> getNewSalaryList() {
        return newSalaryList;
    }

    public void setNewSalaryList(List<SalaryExport> newSalaryList) {
        this.newSalaryList = newSalaryList;
    }

    public ISalaryManage getISalaryManage() {
        return iSalaryManage;
    }

    public void setISalaryManage(ISalaryManage iSalaryManage) {
        this.iSalaryManage = iSalaryManage;
    }

    public IStartSalaryInfoManage getIStartSalaryInfoManage() {
        return iStartSalaryInfoManage;
    }

    public void setIStartSalaryInfoManage(
            IStartSalaryInfoManage iStartSalaryInfoManage) {
        this.iStartSalaryInfoManage = iStartSalaryInfoManage;
    }   
}
