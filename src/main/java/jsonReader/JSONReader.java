package jsonReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader implements JSONReaderInterface{

    @Override
    public List<Departments> JsonReadDepartments() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Departments> departmentsList = null;
        try {
            departmentsList = objectMapper.readValue(
                    new File("C:\\Users\\asus\\Desktop\\SimplTest\\SimplTest\\src\\main\\resources\\departments.json"),
                    new TypeReference<List<Departments>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return departmentsList;
    }

    @Override
    public List<WellParameters> JsonReadWellParameters() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<WellParameters> wellParametersList = null;
        try {
            wellParametersList = objectMapper.readValue(
                    new File("C:\\Users\\asus\\Desktop\\SimplTest\\SimplTest\\src\\main\\resources\\wellParameters.json"),
                    new TypeReference<List<WellParameters>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wellParametersList;
    }

    @Override
    public List<Wells> JsonReadWells() {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Wells> wells = null;
        try {
            wells = objectMapper.readValue(
                    new File("C:\\Users\\asus\\Desktop\\SimplTest\\SimplTest\\src\\main\\resources\\wells.json"),
                    new TypeReference<List<Wells>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wells;
    }
}
