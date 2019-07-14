package com.kv.portal.service.impl;

import com.kv.portal.dto.EmployeeDTO;
import com.kv.portal.model.Employee;
import com.kv.portal.repository.EmployeeRepository;
import com.kv.portal.service.PortalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.kv.portal.utilities.Constants.SORT_BY_NAME;

@Service
@AllArgsConstructor
public class PortalServiceImpl implements PortalService {

    private EmployeeRepository employeeRepository;

    @Override public List<EmployeeDTO> getAllEmployees(String sortBy) {
        if (Objects.isNull(sortBy))
            sortBy = SORT_BY_NAME;
        List<Employee> l = employeeRepository.findAll(Sort.by(Sort.Direction.ASC,sortBy));
        List<EmployeeDTO> retList = new ArrayList<>();
        for (Employee e : l) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(e, employeeDTO);
            retList.add(employeeDTO);
        }
        return retList;
    }

    @Override public EmployeeDTO add(EmployeeDTO employeeDTO) {
        Employee e = new Employee();
        BeanUtils.copyProperties(employeeDTO, e);
        e.setHiredate(new Date());
        Employee e1 = employeeRepository.save(e);
        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        BeanUtils.copyProperties(e1, employeeDTO1);
        return employeeDTO1;
    }
}
