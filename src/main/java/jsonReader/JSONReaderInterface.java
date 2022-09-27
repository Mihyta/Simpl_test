package jsonReader;

import jsonFilesClasses.Departments;
import jsonFilesClasses.WellParameters;
import jsonFilesClasses.Wells;

import java.util.List;

public interface JSONReaderInterface {
    List<Departments> JsonReadDepartments();
    List<WellParameters> JsonReadWellParameters();
    List<Wells> JsonReadWells();
}
