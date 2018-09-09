package com.lxm.springbootcache.mapper;

import com.lxm.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    /**
     * 添加员工信息
     * @param emp
     */
    @Insert("insert into employee(name,email,sex,did) values(#{name},#{email},#{sex},#{did})")
    public void addOneEmployee(Employee emp);

    /**
     * 修改员工个人信息
     * @param emp
     */
    @Update("update employee set name = #{name},email=#{email},sex=#{sex},did=#{did} where id=#{id}")
    public void updateOneEmployee(Employee emp);

    /**
     * 删除员工信息
     * @param id
     */
    @Delete("delete from employee where id = #{id}")
    public void deleteOneEmployee(Integer id);

    /**
     * 按照id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from  employee where id = #{id}")
    public Employee getOneEmployeeById(Integer id);


    /**
     * 按照员工名字查询员工
     * @param name
     * @return
     */
    @Select("select * from employee where name=#{name}")
    public Employee getEmpByName(String name);

}
