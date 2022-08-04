import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String csvFileName = "data.csv";
        List<Employee> list = ParseCSV.parseCSV(columnMapping, csvFileName);
        String json = CsvToJson.listToJson(list);
        String jsonFileName = "data.json";
        CsvToJson.writeString(json, jsonFileName);
        String xmlFileName = "data.xml";
        List<Employee> list2 = XmlToJson.parseXML(xmlFileName);
        String json2 = CsvToJson.listToJson(list2);
        String jsonFilename2 = "data2.json";
        CsvToJson.writeString(json2, jsonFilename2);
    }
}