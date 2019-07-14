package com.kv.portal.controller;


import com.kv.portal.dto.EmployeeDTO;
import com.kv.portal.service.PortalService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PortalController {

    private PortalService portalService;

    @RequestMapping(value = "/v1/portal/employees", method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<EmployeeDTO> getAllEmployees(@RequestParam(name = "sortBy", required =
            false) String sortBy){
        List<EmployeeDTO> l = new ArrayList<>();
        l = portalService.getAllEmployees(sortBy);
        return l;
    }

    @RequestMapping(value = "/v1/portal/employee", method = RequestMethod.POST, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody EmployeeDTO add(@RequestBody EmployeeDTO employeeDTO){
        return portalService.add(employeeDTO);
    }

}
