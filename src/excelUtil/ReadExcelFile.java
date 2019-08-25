package excelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	XSSFWorkbook wb;
	 XSSFSheet sheet;
	 
	 public ReadExcelFile(String excelPath)
	 {
				 try{
				 File src = new File(excelPath);
				 FileInputStream fis = new FileInputStream(src);
				 wb = new XSSFWorkbook(fis);
				 }catch(Exception e) {
				 System.out.println(e.getMessage());
				 }
	 }
	  
	 public String getData(String sheetName, int row, int column)
	 {
	 sheet = wb.getSheet(sheetName);
	 String data = sheet.getRow(row).getCell(column).getStringCellValue();
	 return data;
	 }
	  
	 public int getRowCount(int sheetIndex)
	 {
	 int row = wb.getSheetAt(sheetIndex).getLastRowNum();
	 row = row + 1;
	 return row;
	 }
	 
//	 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		FileUtils.copyFile(srcFile, new File("D:\\StockAccountingVasu\\StockAccounting\\ScreenShots\\"+" "+Description+FunctionLibrary.generateDate()+".png"));
//		excel.setData(TCModule, j, 5, "FAIL");
//		ModuleStatus="false";
//		test.log(LogStatus.FAIL, Description);
//		break;
	//store the data
	 
		public void setData(String sheetname,int row,int column,String Status) throws Throwable
		{	 
			Sheet sh=wb.getSheet(sheetname);
			Row rownum=sh.getRow(row);
			Cell cell=rownum.createCell(column);
			cell.setCellValue(Status);
			if(Status.equalsIgnoreCase("PASS"))
			{
				//create cell Style
				CellStyle style=wb.createCellStyle();
				//create font
				Font font=wb.createFont();
				//set color
				font.setColor(IndexedColors.GREEN.getIndex());
				//set bold
				font.setBold(true);
				// set font
				style.setFont(font);
				// set cell style
				rownum.getCell(column).setCellStyle(style);
			}else
				if(Status.equalsIgnoreCase("FAIL"))
				{
					//create cell Style
					CellStyle style=wb.createCellStyle();
					//create font
					Font font=wb.createFont();
					font.setColor(IndexedColors.RED.getIndex());
					//set bold
					font.setBold(true);
					// set font
					style.setFont(font);
					// set cell style
					rownum.getCell(column).setCellStyle(style);
				}else
					if(Status.equalsIgnoreCase("Not Executed"))
					{
						//create cell Style
						CellStyle style=wb.createCellStyle();
						//create font
						Font font=wb.createFont();
						font.setColor(IndexedColors.BLUE.getIndex());
						//set bold
						font.setBold(true);
						// set font
						style.setFont(font);
						// set cell style
						rownum.getCell(column).setCellStyle(style);
					}
			FileOutputStream fos=new FileOutputStream("D:\\StockAccountingVasu\\StockAccounting\\TestOutPut\\OutPutSheet.xlsx");
			wb.write(fos);
			fos.close();
}
}