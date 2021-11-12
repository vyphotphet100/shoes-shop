package com.group3.shoesshop.controller.admin;

import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.ProductMapper;
import com.group3.shoesshop.dto.ProductDTO;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = "/admin/product/product-list")
    public ModelAndView productList() {
        ModelAndView mav = new ModelAndView("Admin_Page/Pages/Catalog/ProductList/index");

        mav.addObject("products", productService.findAll());

        return mav;
    }

    @Autowired
    private DTOEntityConverter dtoEntityConverter;

    @Autowired
    private ProductMapper productMapper;

    @DeleteMapping(value = "/admin/product/delete")
    public ResponseEntity<ProductDTO> deleteProduct(@RequestParam String code) {
        ProductEntity productEntity = productService.delete(code);
        ProductDTO productDto = dtoEntityConverter.toDTO(productEntity, productMapper);
        return new ResponseEntity<ProductDTO>(productDto, productDto.getHttpStatus());
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

        product.setInStock(true);
        product.setRating(5);
        UserEntity seller = new UserEntity();
        seller.setId(1);
        product.setSeller(seller);
        product = productService.save(product);

        return this.addProductGet(product);
    }

}
