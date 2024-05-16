package com.example.day4.Controller;

import com.example.day4.DTO.ProductDTO;
import com.example.day4.Entity.ProductEntity;
import com.example.day4.Repository.ProductRepository;
import com.example.day4.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(){

        return "main";
    }
    @GetMapping("/input")
    public String input(){

        return "input";
    }

    @PostMapping("/save")
    public String product_save(@RequestParam("image") MultipartFile file, ProductDTO productDTO) throws IOException {
        String fname = file.getOriginalFilename();
        file.transferTo(new File("C:\\이젠디지털12\\springboot\\day4\\src\\main\\resources\\static\\img\\" +fname));
        int amount = productDTO.getAmount();
        int price = productDTO.getPrice();
        int total = amount * price;
        productDTO.setTotal(total);
        productDTO.setPicture(fname);

        ProductEntity productEntity = productDTO.entity();

        productService.insert(productEntity);

        return  "redirect:/input";
    }

    @GetMapping("/output")
    public String output(Model model,@RequestParam(defaultValue = "0",value = "page") int page){
        Page<ProductEntity> listPage = productService.select(page);
        int totalPage = listPage.getTotalPages();
        int nowpage = listPage.getPageable().getPageNumber()+1;//현재페이지//
        model.addAttribute("nowpage",nowpage);
        model.addAttribute("list",listPage.getContent());
        model.addAttribute("totalPage",totalPage);

        return  "output";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("snumber") long snumber){
        productService.delete(snumber);
        return "redirect:/output";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("snumber")long snumber, Model model) throws IOException {
        ProductEntity productEntity = productService.selectOne(snumber);
        model.addAttribute("list",productEntity);

        return  "modify";
    }

    @PostMapping("/update")
    public  String update(ProductDTO productDTO,@RequestParam("image") MultipartFile file) throws IOException {
        String fname = file.getOriginalFilename();
        file.transferTo(new File("C:\\이젠디지털12\\springboot\\day4\\src\\main\\resources\\static\\img\\" +fname));
        int amount = productDTO.getAmount();
        int price = productDTO.getPrice();
        int total = amount * price;
        productDTO.setTotal(total);
        productDTO.setPicture(fname);
        ProductEntity productEntity = productDTO.entity();
        productService.insert(productEntity);
        return "redirect:/output";
    }


}
