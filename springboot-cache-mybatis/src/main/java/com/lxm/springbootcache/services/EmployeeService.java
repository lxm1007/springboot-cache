package com.lxm.springbootcache.services;

import com.lxm.springbootcache.bean.Employee;
import com.lxm.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 *
 * 在类上配置CacheConfig cacheNames 则在方法的CachePut 或者Cacheable 或者CacheEvict的value均不用添加value属性
 * 因为Cacheable是在查询之前到缓存中查询，所以添加的key 不能使用#result.的形式
 * CacheEvict 是在执行结果之后添加到缓存 所以可以使用#result.
 * @author 刘孝明
 */
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

    /**
     * beforeInvocation = true 表示清除缓存是在方法执行之前
     * 不管方法是否有错误，都清除缓存
     * @param id
     */
    @CacheEvict(beforeInvocation = true)
    public  void deleteOneEmployee(Integer id){
        System.out.println("我执行删除了");

    }

    /**
     * 组合注解，caching注解是组合注解，目的是为了为复杂的功能添加注解
     * 但是这个注解并不好用，1、虽然可以在通过一个字段查询的结果，按照不同的key放入缓存，但是存在的问题是
     * 该方法将不能加入到缓存，原因是因为该注解使用了cachePut 而cachePut每次都要进行一次查询或者更新
     * 所以 是否使用该注解，将根据业务逻辑考虑，如果业务简单 通过cacheable和cachePut可以解决的话，就不用使用这个组合注解了
     * @param name
     * @return
     */
    @Caching( cacheable = {
             @Cacheable( key="#name")
    },put={
            @CachePut(key = "#result.id"),
            @CachePut(key="#result.email"),
            @CachePut(key = "#result.sex")
    })
    public Employee getEmpByName(String name){
        return employeeMapper.getEmpByName(name);
    }

}
