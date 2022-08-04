import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class ParseCSV {
    static List<Employee> parseCSV(String[] columnMapping, String csvFileName) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            List<Employee> list = csv.parse();
            list.forEach(System.out::println);
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}