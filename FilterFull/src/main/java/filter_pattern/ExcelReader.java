package filter_pattern;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public List<Anime> generateAnime() {
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream(new File("src/lib/AnimeList.xlsx"));
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            List<Anime> animeList = new ArrayList<Anime>();

            // Iterate through rows and columns
            for (Row row : sheet) {
                int i = 0;
                String title = null, studio = null, date = null, type = null;
                List<String> genre = new ArrayList<String>();
                for (Cell cell : row) {
                    if(!cell.getStringCellValue().isEmpty()) {
                        if(i == 0) {
                            title = cell.getStringCellValue();
                        } else if(i==1) {
                            studio = cell.getStringCellValue();
                        } else if(i==2) {
                            date = cell.getStringCellValue();
                        } else if(i==3) {
                            type = cell.getStringCellValue();
                        } else {
                            genre.add(cell.getStringCellValue());
                        }
                    }
                    i++;
                }
                Anime ani = new Anime(title, studio, date, type, genre);
                animeList.add(ani);
            }
            // Close the file input stream
            fis.close();
            workbook.close();
            return animeList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

