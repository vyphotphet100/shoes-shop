package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.entity.ProductEntity;
import com.group3.shoesshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/customer/product/product-list")
    public ModelAndView productList() {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/ProductPage/index");
        mav.addObject("products", productService.findAll());
        return mav;
    }
    @GetMapping(value = "/customer/product/product-detail")
    public ModelAndView ProductDetail(HttpServletRequest request, @RequestParam String code) {
        if (code == null)
            return null;
        ProductEntity product = productService.findOne(code);
        if (product == null)
            return null;

        ModelAndView mav = new ModelAndView("Customer_Page/Pages/ProductDetailPage/index");
        mav.addObject("product", product);
        return returnModelAndView(request, mav);
    }
}
