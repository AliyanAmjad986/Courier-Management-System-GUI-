package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import database.Database_connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class ReportServices {

	public static void reports() {
	
		try {
			Connection con = null;
			con = Database_connection.dbconnection();
			String reportpath = "resources/reports/EmployeeList.jasper";
			String outputpath = "resources/reports/Emp_List.pdf";
			Map<String, Object> parameters = new HashMap<>();
		
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportpath, parameters, con);
		
			JasperExportManager.exportReportToPdfFile(jasperPrint,outputpath);
			System.out.println("PDF generated successfully!");
		}catch (JRException ex) {
		 System.out.println(ex.getMessage());
		}
		
	}
	public static void customerreport() {
		try {
			Connection con = null;
			con = Database_connection.dbconnection();
			String reportpath = "resources/reports/CustomerReport.jasper";
			String outputpath = "resources/reports/Cust_List.pdf";
			Map<String, Object> parameters = new HashMap<>();
		
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportpath, parameters, con);
		
			JasperExportManager.exportReportToPdfFile(jasperPrint,outputpath);
			System.out.println("PDF generated successfully!");
		}catch (JRException ex) {
		 System.out.println(ex.getMessage());
		}
	}
	public static void summaryreport() {
		try {
			Connection con = null;
			con = Database_connection.dbconnection();
			String reportpath = "resources/reports/Total Report.jasper";
			String outputpath = "resources/reports/Summary_Report.pdf";
			Map<String, Object> parameters = new HashMap<>();
		
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportpath, parameters, con);
		
			JasperExportManager.exportReportToPdfFile(jasperPrint,outputpath);
			System.out.println("PDF generated successfully!");
		}catch (JRException ex) {
		 System.out.println(ex.getMessage());
		}
	}
}
