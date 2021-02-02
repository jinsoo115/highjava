package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class test01 {
	public static void main(String[] args) {
		// workbook 생성
		Workbook xlsxWb = new HSSFWorkbook();
		
		// sheet
		// sheet 생성
		Sheet sheet1 = xlsxWb.createSheet("firstSheet");
		
		// 컬럼 너비 설정
		sheet1.setColumnWidth(0, 10000);
		sheet1.setColumnWidth(9, 10000);
		//----------------------------------------------------------
		
		// Style--------------------------------------------
		// Cell 스타일 생성
		CellStyle cellStyle = xlsxWb.createCellStyle();
		
		// 줄 바꿈
		cellStyle.setWrapText(true);
		
		// Cell 색깔, 무늬 채우기
		cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
		cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
		
		Row row = null;
		Cell cell = null;
		
		Row row1 = sheet1.createRow(1);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(false);
		
		
		// excel 파일 저장
		try {
			File xlsxFile = new File("C:/Users/PC-11/Desktop/test.xlsx");
			FileOutputStream fos = new FileOutputStream(xlsxFile);
			xlsxWb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일생성완료");
		
	}
}
