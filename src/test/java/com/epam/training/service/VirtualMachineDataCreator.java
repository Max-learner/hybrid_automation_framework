package com.epam.training.service;

import com.epam.training.model.VirtualMachineData;
import com.epam.training.page.CalculationResultsPage;

public class VirtualMachineDataCreator {

    public static final String TESTDATA_MACHINES_AMOUNT = "testdata.machines.amount";
    private static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    private static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioning.model";
    private static final String TESTDATA_MACHINE_SERIES = "testdata.machine.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    private static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    private static final String TESTDATA_GPU_NUMBER = "testdata.gpu.amount";
    private static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    private static final String TESTDATA_DATA_CENTER_LOCATION = "testdata.datacenter.location";
    private static final String TESTDATA_COMMITED_USAGE_TERM = "testdata.commited.usage";

    public static VirtualMachineData withAllRequiredData(){
        return new VirtualMachineData(
                TestDataReader.getTestData(TESTDATA_MACHINES_AMOUNT),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_MACHINE_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_GPU_NUMBER),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATA_CENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITED_USAGE_TERM));
    }

    public static VirtualMachineData getVirtualMachineDataFromResults() {

        CalculationResultsPage calculationResultsPage = new CalculationResultsPage();
        VirtualMachineData virtualMachineDataFromCalculator = new VirtualMachineData();

        virtualMachineDataFromCalculator.setDataCenterLocation(calculationResultsPage.getDataCenterLocation());
        virtualMachineDataFromCalculator.setCommittedUsageTerm(calculationResultsPage.getCommitedUsageTerm());
        virtualMachineDataFromCalculator.setProvisioningModel(calculationResultsPage.getProvisioningModel());
        virtualMachineDataFromCalculator.setMachineType(calculationResultsPage.getMachineType());
        virtualMachineDataFromCalculator.setLocalSSDs(calculationResultsPage.getLocalSSD());

        return virtualMachineDataFromCalculator;
    }
}

