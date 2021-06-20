package com.example.demo.service;

import com.example.demo.enumPak.Status;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.enumPak.Status.*;

public class StatusService {
    Map<String, Status> statusMap = new HashMap<>();


    public Status getStatus(String statusKey){
        statusMap.put("available", AVAILABLE);
        statusMap.put("pending", PENDING);
        statusMap.put("sold", SOLD);
        return statusMap.get(statusKey);
    }


}
