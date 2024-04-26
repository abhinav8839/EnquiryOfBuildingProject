package Excel;

//Importing all the required packages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
For Writing The Output in the EXCEL FILE;
*/
public class ExcelUtility
{
	/*
	 * This static block is for deleting the exisiting EXCEL Document;
	 */
	static
	{
		File file = new File("./src/ExcelOutput/Output.xlsx");
		while(true)
		{
			if(file.exists())
			{
				file.delete();
			}
			else
			{
				break;
			}
	    }
	}
	
	//writeOutput() method with the string argument to write the output in EXCEL FILE;
	public void writeOutput(String outputs) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();//creating a new WorkBook;
		XSSFSheet sheet = workbook.createSheet("ISHA-OUTPUT");//creating a new sheet named ISHA-OUTPUT;
		Row row = sheet.createRow(sheet.getLastRowNum()+1);//creating a new row;
		row.createCell(sheet.getRow(sheet.getFirstRowNum()).getLastCellNum()+1).setCellValue(outputs);//creating a new column and adding the value;
		
		try 
		{
			FileOutputStream writer = new FileOutputStream(new File("./src/ExcelOutput/Output.xlsx"));//Creation of EXCEL Document;
			workbook.write(writer);//Writing the Output in EXCEL Document;
			writer.close();//closing the resource after use;
		}
		catch (FileNotFoundException e){}
		finally
		{
			workbook.close();//closing the resource after use;
		}
	}
	
}
