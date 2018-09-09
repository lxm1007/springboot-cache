package com.lxm.springbootcache.services;

import com.lxm.springbootcache.bean.Employee;
import com.lxm.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable
    public Employee getOneEmployee(Integer id){
        return employeeMapper.getOneEmployeeById(id);
}

    @CachePut(key = "#result.id")
    public Employee updateOneEmp(Employee emp){
        employeeMapper.updateOneEmployee(emp);
        return emp;
    }

    @CacheEvict
    public  void deleteOneEmployee(Integer id){
        employeeMapper.deleteOneEmployee(id);

    }


}
