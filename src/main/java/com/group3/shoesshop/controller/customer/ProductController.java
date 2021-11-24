package com.group3.shoesshop.controller.customer;

import com.group3.shoesshop.controller.common.BaseController;
import com.group3.shoesshop.converter.dto_entity.DTOEntityConverter;
import com.group3.shoesshop.converter.dto_entity.mapper.OrderItemMapper;
import com.group3.shoesshop.converter.dto_entity.mapper.UserMapper;
import com.group3.shoesshop.dto.OrderItemDTO;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.*;
import com.group3.shoesshop.service.IBrandService;
import com.group3.shoesshop.service.ICategoryService;
import com.group3.shoesshop.service.IProductService;
import com.group3.shoesshop.service.IUserService;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private DTOEntityConverter converter;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/customer/product/product-list")
    public ModelAndView productList(HttpServletRequest request,
                                    @RequestParam(required = false) String[] categoryCode,
                                    @RequestParam(required = false) String[] brandCode,
                                    @RequestParam(required = true) Integer[] limit,
                                    @RequestParam(required = false) Integer[] price,
                                    @RequestParam(required = false) Integer[] size) {
        ModelAndView mav = new ModelAndView("Customer_Page/Pages/ProductPage/index");
        List<ProductEntity> productEntities = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, limit[limit.length-1]);

        if (categoryCode != null && brandCode != null)
            productEntities = productService.findAllByCategoryCodeAndBrandCodeWithPageable(categoryCode[categoryCode.length-1], brandCode[brandCode.length-1], pageable);
        else if (categoryCode != null && brandCode == null)
            productEntities = productService.findAllByCategoryCodeWithPageable(categoryCode[categoryCode.length-1], pageable);
        else if (categoryCode == null && brandCode == null)
            productEntities = productService.findAllWithPageable(pageable);

        // filter
        if (price != null){
            Integer tmpPrice = price[price.length-1];
            if (tmpPrice == 1)
                productEntities = productService.filterByPrice(productEntities, 50, 200);
            else if (tmpPrice == 2)
                productEntities = productService.filterByPrice(productEntities, 200, 500);
            else if (tmpPrice == 3)
                productEntities = productService.filterByPrice(productEntities, 500, 9999999);
        }

        if (size != null) {
            Integer tmpSize = size[size.length-1];
            if (tmpSize == 1)
                productEntities = productService.filterBySize(productEntities, 38, 40);
            else if (tmpSize == 2)
                productEntities = productService.filterBySize(productEntities, 40, 42);
            else if (tmpSize == 3)
                productEntities = productService.filterBySize(productEntities, 38, 999);
        }

        mav.addObject("products", productEntities);
        return returnModelAndView(request, mav);
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

    @PostMapping(value = "/customer/product/add-product-to-cart")
    public ResponseEntity<UserDTO> addToCart(HttpServletRequest request, @RequestBody OrderItemEntity orderItemEntity) {
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession == null) {
            UserEntity resEntity = userService.exceptionObject(new UserEntity(), "You need to log in to do this action.");
            UserDTO userDto = converter.toDTO(resEntity, userMapper);
            return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
        }

        if (orderItemEntity == null || orderItemEntity.getListRequest().size() != 2)
            return null;

        UserEntity userEntity = userService.addProductToCart(userSession.getId(), (String) orderItemEntity.getListRequest().get(0), (Integer) orderItemEntity.getListRequest().get(1));
        UserDTO userDto = converter.toDTO(userEntity, userMapper);
        return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
    }
}
