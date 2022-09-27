package jsonReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonFilesClasses.Departments;
import jsonFilesClasses.WellParameters;
import jsonFilesClasses.Wells;
import logic.MainAppCode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader implements JSONReaderInterface {
    //Чтение данных из JSON файлов
    @Override
    public List<Departments> jsonReadDepartments() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Departments> departmentsList = null;
        try {
            departmentsList = objectMapper.readValue(
                    new File(MainAppCode.FILES_PATH + "/departments.json"),
                    new TypeReference<List<Departments>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return departmentsList;
    }

    @Override
    public List<WellParameters> jsonReadWellParameters() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<WellParameters> wellParametersList = null;
        try {
            wellParametersList = objectMapper.readValue(
                    new File(MainAppCode.FILES_PATH + "/wellParameters.json"),
                    new TypeReference<List<WellParameters>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wellParametersList;
    }

    @Override
    public List<Wells> jsonReadWells() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Wells> wells = null;
        try {
            wells = objectMapper.readValue(
                    new File(MainAppCode.FILES_PATH + "/wells.json"),
                    new TypeReference<List<Wells>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wells;
    }
}
