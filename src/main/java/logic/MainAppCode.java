import jsonFilesClasses.Departments;
import jsonFilesClasses.WellParameters;
import jsonFilesClasses.Wells;
import jsonReader.JSONReader;
import jsonReader.JSONReaderInterface;

import java.util.*;
import java.util.stream.Collectors;

public class MainAppCode implements MainAppCodeInterface {
    final JSONReaderInterface jsonReaderInterface = new JSONReader();
    @Override
    public void uniqueParameters() {
        List<WellParameters> wellParameters = jsonReaderInterface.JsonReadWellParameters();
        LinkedHashSet<WellParameters> wellParametersLinkedHashSet = new LinkedHashSet<>(wellParameters);
        System.out.println("---------Task 1----------");
        wellParametersLinkedHashSet.forEach(System.out::println);
    }

    @Override
    public void nameBoreholeAndMinMaxAveParameters(int startWell, int endWell) {
        List<WellParameters> wellParametersList = jsonReaderInterface.JsonReadWellParameters();
        List<Wells> wellsList = jsonReaderInterface.JsonReadWells();

        wellsList= wellsList.stream().filter(x -> x.getId() >= startWell && x.getId() <= endWell).collect(Collectors.toList());
        List<WellParameters> listParamsForCurrentWell;
        LinkedHashMap<String, ArrayList<Double>> mapParamsForCurrentWell;
        TreeMap<String, LinkedHashMap<String, ArrayList<Double>>> mapWellsParams = new TreeMap<>();
        for (Wells well : wellsList) {
            mapParamsForCurrentWell = new LinkedHashMap<>();
            listParamsForCurrentWell = wellParametersList.stream().filter(x -> x.getWellId() == well.getId()).collect(Collectors.toList());
            for (WellParameters parameter : listParamsForCurrentWell) {
                mapParamsForCurrentWell.computeIfAbsent(parameter.getParameterName(), v -> new ArrayList<>()).add(parameter.getValue());
            }
            mapWellsParams.put(well.getName(), mapParamsForCurrentWell);
        }
        System.out.println("---------Task 2----------");
        mapWellsParams.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Override
    public void BoreholeToDeposit() {
        List<Departments> departmentsList = jsonReaderInterface.JsonReadDepartments();
        List<Wells> wellsList = jsonReaderInterface.JsonReadWells();


        Map<Departments, List<Wells>> mapDepartmentsAndWells = new LinkedHashMap<>();
        for (Departments department : departmentsList) {
            mapDepartmentsAndWells.put(department, new ArrayList<Wells>());
        }
        Departments departmentsWithoutCords = new Departments();
        departmentsWithoutCords.setName("Скважины без координат");
        mapDepartmentsAndWells.put(departmentsWithoutCords, new ArrayList<Wells>());
        Departments wellsOutsideDepartments = new Departments();
        wellsOutsideDepartments.setName("Скважины вне месторождений");
        mapDepartmentsAndWells.put(wellsOutsideDepartments, new ArrayList<Wells>());

        for (Wells well : wellsList) {
            if (well.getX() == 0 || well.getY() == 0) {
                mapDepartmentsAndWells.get(departmentsWithoutCords).add(well);
            } else {
                boolean inWhoListAdd = false;
                for (Departments department : departmentsList) {
                    if (Math.sqrt(Math.pow(department.getX() - well.getX(), 2) + Math.pow(department.getY() - well.getY(), 2)) <= department.getRadius()) {
                        mapDepartmentsAndWells.get(department).add(well);
                        inWhoListAdd = true;
                    }
                }
                if (!inWhoListAdd) {
                    mapDepartmentsAndWells.get(wellsOutsideDepartments).add(well);
                }
            }
        }
        System.out.println("---------Task 3----------");
        mapDepartmentsAndWells.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
