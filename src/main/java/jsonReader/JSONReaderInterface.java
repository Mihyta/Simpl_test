package jsonReader;

import jsonFilesClasses.Departments;
import jsonFilesClasses.WellParameters;
import jsonFilesClasses.Wells;

import java.util.List;

public interface JSONReaderInterface {
    List<Departments> jsonReadDepartments();
    List<WellParameters> jsonReadWellParameters();
    List<Wells> jsonReadWells();
}
