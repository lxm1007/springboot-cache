package com.lxm.springbootcache.mapper;

import com.lxm.springbootcache.bean.Dept;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptMapper {


    /**
     * 添加部门信息
     * @param dpet
     */
    @Insert("insert into dept(deptname) values(#{deptname})")
    public void addOneDept(Dept dpet);

    /**
     * 删除部门信息
     * @param id
     */
    @Delete("delete from  dept where id = #{id}")
    public void deleteOneDept(Integer id);

    /**
     * 修改部门信息
     * @param dept
     */
    @Update("update dept set deptname = #{deptname} where id = #{id}")
    public void updateOneDept(Dept dept);

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @Select("select * from  dept where id = #{id}")
    public Dept getDeptById(Integer id);




}
