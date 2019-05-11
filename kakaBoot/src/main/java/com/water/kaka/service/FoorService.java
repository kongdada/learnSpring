package com.water.kaka.service;

public interface FoorService {
    void insertRecord();
    void insertRecordThenRollBack();
    void invokeInsertThenRollBack();
}
