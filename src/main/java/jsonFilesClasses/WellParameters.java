package jsonFilesClasses;

import java.util.Objects;

public class WellParameters {

    @Override
    public String toString() {
        return parameterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WellParameters)) return false;
        WellParameters that = (WellParameters) o;
        return parameterName.equals(that.parameterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterName);
    }

    public int getWellId() {
        return wellId;
    }

    public void setWellId(int wellId) {
        this.wellId = wellId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private int wellId;
    private String parameterName;
    private double value;

}
