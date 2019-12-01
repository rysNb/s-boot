package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Employee {
    private Integer id;
    private String src;
    private String name;
    private double salary;
    private Integer age;
    private String department;
    private Department dep;


}
