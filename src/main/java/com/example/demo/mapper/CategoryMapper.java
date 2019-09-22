package com.example.demo.mapper;

import com.example.demo.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


//使用注解@Mapper 表示这是一个Mybatis Mapper接口。

//修改CategoryMapper，增加CRUD方法的支持。 其实就是调用不同的SQL语句。

//# 如何获取获取前端表单数据.

// 前端获取后端使用EL表达式 ${}
// 后端获取前端 #{}

@Mapper
@Component
public interface CategoryMapper {

    @Select("select * from category_")
    List<Category> findAll();

    @Insert("insert into category_ (name) value (#{name})")
    public int save(Category category);

    @Delete("delete from category_ where id= #{id}")
    public void delete(int id);

    @Select("select * from category_ where id= #{id}")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id}")
    public int update(Category category);

}
