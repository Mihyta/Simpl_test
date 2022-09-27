package jsonReader;
import jsonFiles.Departments;

import java.util.List;

public interface JSONReaderInterface {
    List<Departments> JsonReadDepartments();
    List<WellParameters> JsonReadWellParameters();
    List<Wells> JsonReadWells();
}
