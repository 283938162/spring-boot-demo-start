package com.example.demo.controller;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//方法一
//JPA(Java Persistence API)是Sun官方提出的Java持久化规范，用来方便大家操作数据库。
//真正干活的可能是Hibernate,TopLink等等实现了JPA规范的不同厂商,默认是Hibernate。

//@Controller
//public class CategoryController {
//    // @Autowired注解 通过@Autowired把接口或者类自动注入到SpringBoot容器中
//    @Autowired
//    CategoryDAO categoryDAO;
//
//    @RequestMapping("/listCategory")
//    public String listCategory(Model model) throws Exception{
//        List<Category> cs = categoryDAO.findAll();
//        model.addAttribute("cs",cs);
//        return "listCategory";
//    }
//}


//方法二
//使用mybatis注解
@Controller
public class CategoryController {
    // @Autowired注解 通过@Autowired把接口或者类自动注入到SpringBoot容器中
    // 这个单存使用Autowird 会报注入异常.
//    两种修改方法
//    (1) 可以使用   @Resource替代@Autowired
//    (2) 在接口添加@Component注释即可

    @Autowired
    CategoryMapper categoryMapper;

//    经典风格
//   为CategoryController添加： 增加、删除、获取、修改映射

//    @RequestMapping("/addCategory")
//    public String listCategory(Category c) throws Exception {
//        categoryMapper.save(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/deleteCategory")
//    public String deleteCategory(Category c) throws Exception {
//        categoryMapper.delete(c.getId());
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/updateCategory")
//    public String updateCategory(Category c) throws Exception {
//        categoryMapper.update(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/editCategory")
//    public String listCategory(int id,Model m) throws Exception {
//        Category c= categoryMapper.get(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }
//
//    //修改查询映射
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m, @RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
//        PageHelper.startPage(start,size,"id asc");
//        List<Category> cs = categoryMapper.findAll();
//        PageInfo<Category> page = new PageInfo<>(cs);
//        m.addAttribute("page",page);
//        return "listCategory";
//    }


//  Restful风格

    //修改查询映射
    @GetMapping("/categories")
    public String listCategory(Model m, @RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id asc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page",page);
        return "listCategory";
    }

    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        categoryMapper.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        categoryMapper.delete(c.getId());
        return "redirect:/categories";
    }

    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:/categories";
    }

//    @PathVarible 用于接收 映射 url 中占位符的值， 如  @PutMapping("/categories/{id}") 中的 id
//    不写的话 系统认不出这是一个请求URL中的模板变量
//    写的意思 就是告诉系统 将请求URL中的模板变量映射到功能处理方法的参数上
//    不绑定下的异常：java.lang.IllegalStateException: Optional int parameter 'id' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
    @GetMapping("/categories/{id}")
    public String listCategory(@PathVariable("id")int id,Model m) throws Exception {
        Category c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }


}








