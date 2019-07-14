package com.kv.portal;

import java.util.Date;

public class AbstractEndpointTest {

    protected String createEmployeeJson(String name, Integer salary) {
        Date d  = new Date();
        return String.format("{\"name\": \"karan\",\"salary\":  12456 ,\"hiredate\":  \"\"}");
    }


}
