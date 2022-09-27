package logic;

import jsonFilesClasses.Departments;
import jsonFilesClasses.WellParameters;
import jsonFilesClasses.Wells;
import jsonReader.JSONReader;
import jsonReader.JSONReaderInterface;

import java.util.*;
import java.util.stream.Collectors;

public class MainAppCode implements MainAppCodeInterface {
    final JSONReaderInterface jsonReaderInterface = new JSONReader();
    // Задание 1
    @Override
    public void uniqueParameters() {
        List<WellParameters> wellParameters = jsonReaderInterface.JsonReadWellParameters();
        LinkedHashSet<WellParameters> wellParametersLinkedHashSet = new LinkedHashSet<>(wellParameters);
        int i = 0;
        StringBuilder builder = new StringBuilder();
        for (WellParameters s : wellParametersLinkedHashSet) {
            builder.append(++i).append(". ").append(s).append("\n");
        }
        System.out.println("---------Task 1----------");
        System.out.println(builder);
    }
    // Задание 2
    @Override
    public void nameBoreholeAndMinMaxAveParameters(int startWell, int endWell) {
        List<WellParameters> wellParametersList = jsonReaderInterface.JsonReadWellParameters();
        List<Wells> wellsList = jsonReaderInterface.JsonReadWells();
        wellsList= wellsList.stream().filter(
                a -> a.getId() >= startWell && a.getId() <= endWell).collect(Collectors.toList());
        List<WellParameters> listParametersSelectedWells;
        LinkedHashMap<String, ArrayList<Double>> mapParametersSelectedWells;
        TreeMap<String, LinkedHashMap<String, ArrayList<Double>>> mapWellsParams = new TreeMap<>();
        for (Wells well : wellsList) {
            mapParametersSelectedWells = new LinkedHashMap<>();
            listParametersSelectedWells = wellParametersList.stream().filter(
                    a -> a.getWellId() == well.getId()).collect(Collectors.toList());
            for (WellParameters parameter : listParametersSelectedWells) {
                mapParametersSelectedWells.computeIfAbsent(
                        parameter.getParameterName(), v -> new ArrayList<>()).add(parameter.getValue());
            }
            mapWellsParams.put(well.getName(), mapParametersSelectedWells);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (Map.Entry<String, LinkedHashMap<String, ArrayList<Double>>> mapEntry : mapWellsParams.entrySet()) {
            builder.append(mapEntry.getKey()).append("\n");
            int k = 0;
            for (Map.Entry<String, ArrayList<Double>> entry : mapEntry.getValue().entrySet()) {
                Double min = null, max = null, ave = null;
                for (Double doubles : entry.getValue()) {
                    if (min == null) {
                        min = max = ave = doubles;
                    } else {
                        min = Math.min(min, doubles);
                        max = Math.max(max, doubles);
                        ave += doubles;
                    }
                }
                ave /= entry.getValue().size();
                builder.append(String.format("%d. %s: min - %.2f; max - %.2f; ave - %.2f\n", ++k, entry.getKey(), min, max, ave));
            }
            builder.append("\n");
        }
        System.out.println("---------Task 2----------");
        System.out.println(builder);

    }
    //Задание 3
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
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Departments, List<Wells>> entryMap : mapDepartmentsAndWells.entrySet()) {
            builder.append(entryMap.getKey().getName()).append(":");
                for (Wells well : entryMap.getValue()) {
                    builder.append(" ").append(well.getName()).append(",");
                }
                builder.append("\n");
        }
        System.out.println("---------Task 3----------");
        System.out.println(builder);
    }
}
