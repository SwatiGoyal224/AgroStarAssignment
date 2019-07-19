package Assignment.Assignment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


/**
 * The Class ObjectRepoReader.
 */
public class ObjectRepoReader {

	
    FileInputStream file;
   // LoggerManager log;

    /**
     * Instantiates a new object repo reader.
     *
     * @param fileName the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    
    public ObjectRepoReader() throws IOException {
        file = new FileInputStream(new File("/Users/sgoyal/Documents/AgroStar/AgroStarAssignment/Assignment/src/main/resources/ObjectRepo/ObejctRepo.xls"));
    }

    /**
     * Generate or.
     *
     * @param orSheetName the or sheet name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @SuppressWarnings({"unused", "resource"})
    public Map<String, Map<String, String>> generateOR()
            throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook(file);

        // Get first/desired sheet from the workbook
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        int nRowCount = sheet.getLastRowNum();
        Row header1 = sheet.getRow(0);

        int nColumnCount = header1.getLastCellNum();

        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        for (int j = 1; j <= nRowCount; j++) {

            try {

                String cell = sheet.getRow(j).getCell(0).getStringCellValue()
                        .trim();

                String proType = sheet.getRow(j).getCell(1)
                        .getStringCellValue().trim();

                String ProValue = sheet.getRow(j).getCell(2)
                        .getStringCellValue().trim();

                Map<String, String> map2 = new HashMap<String, String>();

                if (cell != null) {
                    if (proType != null) {
                        map2.put(sheet.getRow(0).getCell(1)
                                .getStringCellValue(), proType);
                    } else {
                        map2.put(sheet.getRow(0).getCell(1)
                                .getStringCellValue(), "");
                    }
                    if (ProValue != null) {

                        map2.put(sheet.getRow(0).getCell(2)
                                .getStringCellValue(), ProValue);
                    } else {
                        map2.put(sheet.getRow(0).getCell(2)
                                .getStringCellValue(), "");
                    }
                    map.put(cell, map2);
                }
            } catch (Exception e) {
                 System.out.println(e);
            }

        }
        return map;
    }
}
