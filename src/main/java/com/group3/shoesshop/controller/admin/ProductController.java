package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "admin-product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = "/admin/product/product-list")
    public ModelAndView productList(@RequestParam(required = false) String[] keyword) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Catalog/ProductList/index");

        List<ProductEntity> productEntities = null;
        if (keyword == null)
            productEntities = productService.findAll(true);
        else
            productEntities = productService.findAll(keyword[keyword.length-1], true);

        mav.addObject("products", productEntities);

        return mav;
    }

    @DeleteMapping(value = "/admin/product/delete")
    public ResponseEntity<ProductEntity> deleteProduct(@RequestParam String code) {
        ProductEntity productEntity = productService.delete(code).toLaziness();
        return new ResponseEntity<ProductEntity>(productEntity, productEntity.getHttpStatus());
    }

    @GetMapping(value = "/admin/product/edit")
    public ModelAndView editProductGet(@RequestParam String code) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Catalog/EditProduct/index");

        ProductEntity product = productService.findOne(code);
        mav.addObject("product", product);
        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @PutMapping(value = "/admin/product/edit")
    public ModelAndView editProductPut(@ModelAttribute("product") ProductEntity product) {
        productService.update(product);
        return this.editProductGet(product.getCode());
    }


    @GetMapping(value = "/admin/product/add")
    public ModelAndView addProductGet(ProductEntity product) {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Catalog/AddProduct/index");

        if (product == null)
            mav.addObject("product", new ProductEntity());
        else
            mav.addObject("product", product);
        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @PostMapping(value = "/admin/product/add")
    public ModelAndView addProductPost(@ModelAttribute("product") ProductEntity product) {
        //ModelAndView mav = new ModelAndView("Admin_Page/Pages/Catalog/AddProduct/index");
        UserEntity seller = new UserEntity();
        seller.setId(1);
        product.setSeller(seller);

        product.setIsAvailable(true);
        product.setInStock(true);
        product.setRating(5);
        product = productService.save(product);

        return this.addProductGet(product);
    }

}
