package com.epam.training.model;

import java.util.Objects;

public class VirtualMachineData {
    private String machinesAmount;
    private String operatingSystem;
    private String provisioningModel;
    private String machineSeries;
    private String machineType;
    private String gpuType;
    private String numberOfGPUs;
    private String localSSDs;
    private String dataCenterLocation;
    private String committedUsageTerm;

    public VirtualMachineData(String machinesAmount,
                              String operatingSystem,
                              String provisioningModel,
                              String machineSeries,
                              String machineType,
                              String gpuType,
                              String numberOfGPUs,
                              String localSSDs,
                              String dataCenterLocation,
                              String committedUsageTerm
    ) {
        this.machinesAmount = machinesAmount;
        this.operatingSystem = operatingSystem;
        this.provisioningModel = provisioningModel;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSDs = localSSDs;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsageTerm = committedUsageTerm;
    }

    public VirtualMachineData(String machinesAmount){

        this.machinesAmount = machinesAmount;
    }

    public VirtualMachineData(){
    }

    public String getMachinesAmount() {
        return machinesAmount;
    }

    public void setMachinesAmount(String machinesAmount) {
        this.machinesAmount = machinesAmount;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSDs() {
        return localSSDs;
    }

    public void setLocalSSDs(String localSSDs) {
        this.localSSDs = localSSDs;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommittedUsageTerm() {
        return committedUsageTerm;
    }

    public void setCommittedUsageTerm(String committedUsageTerm) {
        this.committedUsageTerm = committedUsageTerm;
    }

    @Override
    public String toString() {
        return "VirtualMachineData{" +
                "machinesAmount='" + machinesAmount + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSDs='" + localSSDs + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsageTerm='" + committedUsageTerm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof VirtualMachineData)) {return false;}

        VirtualMachineData VMfromUI = (VirtualMachineData) o;

        return (dataCenterLocation.contains(VMfromUI.dataCenterLocation) ||
                    VMfromUI.dataCenterLocation.contains(dataCenterLocation))
                &&
                (committedUsageTerm.contains(VMfromUI.committedUsageTerm) ||
                    VMfromUI.committedUsageTerm.contains(committedUsageTerm)   )
                &&
                (provisioningModel.contains(VMfromUI.provisioningModel) ||
                    VMfromUI.provisioningModel.contains(provisioningModel))
                &&
                (machineType.contains(VMfromUI.machineType) ||
                        VMfromUI.machineType.contains(machineType))
                &&
                (localSSDs.contains(VMfromUI.localSSDs) ||
                        VMfromUI.localSSDs.contains(localSSDs));

    }

    @Override
    public int hashCode() {
        return Objects.hash(machineType) + Objects.hash(dataCenterLocation) + Objects.hash(localSSDs);
    }
}
