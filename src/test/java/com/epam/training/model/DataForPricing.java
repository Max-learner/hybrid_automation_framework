package com.epam.training.model;

import java.util.Objects;

public class DataForPricing {
    private String machinesAmount;

    public DataForPricing(String machinesAmount){
        this.machinesAmount = machinesAmount;
    }

    public String getMachinesAmount() {
        return machinesAmount;
    }

    public void setMachinesAmount(String machinesAmount) {
        this.machinesAmount = machinesAmount;
    }

    @Override
    public String toString() {
        return "DataForPricing{" +
                "machinesAmount=" + machinesAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof DataForPricing)) {return false;}
        DataForPricing that = (DataForPricing) o;
        return machinesAmount == that.machinesAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(machinesAmount);
    }
}
