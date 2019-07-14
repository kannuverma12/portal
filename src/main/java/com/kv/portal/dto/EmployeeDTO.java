package com.kv.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {

    @JsonProperty("name")
    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    @JsonProperty("salary")
    private Integer salary;

    @JsonProperty("hiredate")
    private Date hiredate;


}
