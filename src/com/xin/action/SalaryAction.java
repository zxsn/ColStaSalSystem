package com.xin.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.xin.bean.Salary;
import com.xin.service.IEmployeeManage;
import com.xin.service.ISalaryManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class SalaryAction {

	private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Resource
	private ISalaryManage salaryManage;

	public ISalaryManage getSalaryManage() {
		return salaryManage;
	}

	public void setSalaryManage(ISalaryManage salaryManage) {
		this.salaryManage = salaryManage;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	@Resource
	private IEmployeeManage employeeManage;

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public String addSalary() {
	
		System.out.println("-------salaryAction.addSalary--------"
				+ salary.getEid());
		
		if (salary.getEid() == null)
			return "fail";
		
		
		if (isValid(salary.getEid())) {
			if (employeeManage.findEmployeeById(salary.getEid()) != null) {
				salaryManage.addSalary(salary);
				return "success";
			}
		}
		return "fail";
	}

	public String modifySalary() {
		System.out.println("-------salaryAction.modifySalary--------"
				+ salary.getEid());
		if (salary.getEid() == null)
			return "fail";
		if (isValid(salary.getEid())) {
			if (employeeManage.findEmployeeById(salary.getEid()) != null) {
				salaryManage.modifySalary(salary);
				return "success";
			}
		}
		return "fail";
	}

	public String deleteSalary() {
		System.out.println("-------salaryAction.deleteSalary--------"
				+ salary.getEid());
		if (salary.getEid() == null)
			return "fail";
		if (isValid(salary.getEid())) {
			if (employeeManage.findEmployeeById(salary.getEid()) != null) {
				salaryManage.deleteSalary(salary);
				return "success";
			}
		}
		return "fail";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getSalaryInfo() {
		System.out.println("-------salaryAction.getSalaryInfo--------"
				+ salary.getEid());
		if (salary.getEid() == null)
			return "fail";
		if (isValid(salary.getEid())
				&& employeeManage.findEmployeeById(salary.getEid()) != null) {
			Integer eid = salary.getEid();
			salary = salaryManage.findSalaryById(eid);
			List<Salary> lst = new ArrayList<Salary>();
			lst.add(salary);
			Map session = ActionContext.getContext().getSession();
			session.put("eSalaryInfo", lst);
			return "success";
		}
		return "fail";
	}

	public String exportSalaryInfo()
	{
		System.out.println("-------salaryAction.exportSalaryInfo--------" + salary.getEid());
		if (salary.getEid() == null)
			return "fail";
		if (isValid(salary.getEid()) && employeeManage.findEmployeeById(salary.getEid()) != null) 
		{
			Integer eid = salary.getEid();
			salary = salaryManage.findSalaryById(eid);
			List<Salary> lst = new ArrayList<Salary>();
			lst.add(salary);
			String []tableHeader={"职工号","岗位工资","薪级工资","地区差","岗位津贴","教护补贴","特殊津贴","独生子女补贴","其它补贴","电话补贴","月增资额","补发工资","本月总工资","备注"};
			short cellNumber = (short)tableHeader.length;
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCell cell = null;
			HSSFRow row = null;
			HSSFCellStyle style_header = workbook.createCellStyle();
			style_header.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style_data = workbook.createCellStyle();
			style_data.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont();
			HSSFSheet sheet = workbook.createSheet("sheet1");
			HSSFHeader header = sheet.getHeader();
			
			try {
				if (lst.size() < 1) {
					header.setCenter("查无资料");
				}
				else {
					header.setCenter("Salary");
					row = sheet.createRow(0);
					row.setHeight((short)400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);
						cell.setCellValue(tableHeader[k]);
						sheet.setColumnWidth(k, 8000);
						font.setColor(HSSFFont.COLOR_NORMAL);
						font.setFontHeight((short)350);
						style_data.setFont(font);
						cell.setCellStyle(style_data);
					}
					for (int i = 0; i < lst.size(); i++)
					{
						salary = lst.get(i);
						row = sheet.createRow((short)(i+1));
						row.setHeight((short)400);
						
						cell = row.createCell(0);
						cell.setCellValue(salary.getEid());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(1);
						cell.setCellValue(salary.getPositionSalary());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(2);
						cell.setCellValue(salary.getLevelSalary());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(3);
						cell.setCellValue(salary.getAreaDifference());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(4);
						cell.setCellValue(salary.getPositionAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(5);
						cell.setCellValue(salary.getEducationAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(6);
						cell.setCellValue(salary.getSpecialAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(7);
						cell.setCellValue(salary.getOnlyChildAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(8);
						cell.setCellValue(salary.getOtherAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(9);
						cell.setCellValue(salary.getPhoneAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(10);
						cell.setCellValue(salary.getMonthAddAllowance());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(11);
						cell.setCellValue(salary.getSupplementSalary());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(12);
						cell.setCellValue(salary.getTotleSalary());
						cell.setCellStyle(style_header);
						
						cell = row.createCell(13);
						cell.setCellValue(salary.getRemarks());
						cell.setCellStyle(style_header);
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			HttpServletResponse response = null;//创建一个HttpServletResponse对象
			OutputStream out = null;//创建一个输出流对象
			try {
				response = ServletActionContext.getResponse();//初始化HttpServletResponse对象
				out = response.getOutputStream();//
		        response.setHeader("Content-disposition","attachment; filename="+"salary.xls");//filename是下载的xls的名，建议最好用英文
		        response.setContentType("application/msexcel;charset=UTF-8");//设置类型
		        response.setHeader("Pragma","No-cache");//设置头
		        response.setHeader("Cache-Control","no-cache");//设置头
		        response.setDateHeader("Expires", 0);//设置日期头
		        workbook.write(out);
		        out.flush();
				workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try{					
					if(out!=null){
						out.close();
					}					
				}catch(IOException e){
					e.printStackTrace();
				}				
			}
			return null;
		}
		return "fail";
	}
}