package com.group3.shoesshop.controller.seller;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "seller-product")
public class ProductController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/seller/product/product-list")
    public ModelAndView productList(HttpServletRequest request) {
        request.getSession().setAttribute(Constant.USER_SESSION, userService.findOne(2));

        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Catalog/ProductList/index");

        UserEntity userSession = (UserEntity)request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null)
            return null;

        mav.addObject("products", productService.findAllByAvailableAndSellerId(true, userSession.getId()));

        return mav;
    }

    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/seller/product/edit")
    public ModelAndView editProductGet(@RequestParam String code) {
        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Catalog/EditProduct/index");

        ProductEntity product = productService.findOne(code);
        mav.addObject("product", product);
        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @PutMapping(value = "/seller/product/edit")
    public ModelAndView editProductPut(@ModelAttribute("product") ProductEntity product) {
        productService.update(product);
        return this.editProductGet(product.getCode());
    }

    @GetMapping(value = "/seller/product/add")
    public ModelAndView addProductGet(ProductEntity product) {
        ModelAndView mav = new ModelAndView("Seller_Page/Pages/Catalog/AddProduct/index");

        if (product == null)
            mav.addObject("product", new ProductEntity());
        else
            mav.addObject("product", product);
        mav.addObject("brands", brandService.findAll());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @PostMapping(value = "/seller/product/add")
    public ModelAndView addProductPost(@ModelAttribute("product") ProductEntity product, HttpServletRequest request) {
        UserEntity userSession = (UserEntity)request.getSession().getAttribute(Constant.USER_SESSION);
        product.setSeller(userSession);

        product.setIsAvailable(true);
        product.setInStock(true);
        product.setRating(5);
        product = productService.save(product);

        return this.addProductGet(product);
    }
}
