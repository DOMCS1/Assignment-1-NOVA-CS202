package SignUp.Assignment3;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    private String filename = "SignUp/Assignment3/Restaurant2.xls";
    private List<List<Cell>> sheetData = new ArrayList();
    private FileInputStream fis;


    public ExcelReader() throws IOException
    {
        try{
<<<<<<< HEAD
            File file = new File("src/SignUp/Assignment3/Restaurant2.xls");
=======
<<<<<<< HEAD
            File file = new File("src/SignUp/Assignment3/Restaurant2.xls");
=======
            File file = new File("C:\\Users\\praty\\IdeaProjects\\login\\src\\SignUp\\Assignment3\\Restaurant2.xls");
>>>>>>> d0f82d39270e260a359e0e605ff6bdde18b6008b
>>>>>>> 78b240e048604f4d4df5ef672119d5b91468172f

            fis = new FileInputStream(file);

            //
            // Create an excel workbook from the file system.
            //
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.

            //
            HSSFSheet sheet = workbook.getSheetAt(0);


            //
            // When we have a sheet object in hand we can iterator on
            // each sheet's rows and on each row's cells. We store the
            // data read on an ArrayList so that we can printed the
            // content of the excel to the console.
            //

            Iterator rows = sheet.rowIterator();
            HSSFRow row = (HSSFRow) rows.next();


            while (rows.hasNext()) {
                row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                HSSFCell cell = (HSSFCell) cells.next();

                List<Cell> data = new ArrayList<>();
                while (cells.hasNext()) {
                    cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
//                    Restaurant data = new Restaurant();
//                    HSSFCell cell = (HSSFCell) cells.next();
//                    data.setName(cell.getStringCellValue());
//                    cell = (HSSFCell) cells.next();
//                    data.setLongitude(cell.getNumericCellValue());
//                    cell = (HSSFCell) cells.next();
//                    data.setLatitude(cell.getNumericCellValue());
//                    cell = (HSSFCell) cells.next();
//                    data.setAddress(cell.getStringCellValue());
//                    cell = (HSSFCell) cells.next();
//                    data.setPhone(cell.getStringCellValue());
//                    cell = (HSSFCell) cells.next();
//                    //data.setLogo();




            }
        } catch (IOException e) {
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    public List getList() {
        return sheetData;
    }

    private static void showExcelData(List sheetData) {
        //
        // Iterates the data and print it out to the console.
        //
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cell.getRichStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
