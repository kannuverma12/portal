package com.kv.portal.service;

import com.kv.portal.dto.EmployeeDTO;

import java.util.List;

public interface PortalService {

    List<EmployeeDTO> getAllEmployees(String sortBy);
    EmployeeDTO add(EmployeeDTO employeeDTO);
}
