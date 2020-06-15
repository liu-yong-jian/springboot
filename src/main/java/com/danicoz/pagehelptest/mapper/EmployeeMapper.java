package com.danicoz.pagehelptest.mapper;

import com.danicoz.pagehelptest.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {


    List<Employee> selectEmployees();
}
