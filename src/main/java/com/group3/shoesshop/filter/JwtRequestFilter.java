package com.group3.shoesshop.filter;

import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.dto.UserDTO;
import com.group3.shoesshop.entity.UserEntity;
import com.group3.shoesshop.repository.UserRepository;
import com.group3.shoesshop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        UsernamePasswordAuthenticationToken authentication = null;
        UserEntity userSession = MyUtils.getUserFromSession(request);
        if (userSession != null) {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            authentication = new UsernamePasswordAuthenticationToken(userSession, null,
                    authorities);
        }

        if (authentication != null) {
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else
            SecurityContextHolder.getContext().setAuthentication(null);

        // authorization
        String url = request.getRequestURI();
        if (!checkAuthority(userSession, url)) {
            response.sendRedirect("/before-logout?message=Please login to do this action.");
            return;
        }

        filterChain.doFilter(request, response);

    }

    private Boolean checkAuthority(UserEntity userEntity, String url) {
        if (url.startsWith("/admin/")) {
            if (userEntity == null ||
                    (!userEntity.getRole().getCode().equals(Constant.ROLE_ADMIN) &&
                    !userEntity.getRole().getCode().equals(Constant.ROLE_ADMIN1) &&
                    !userEntity.getRole().getCode().equals(Constant.ROLE_ADMIN2) &&
                    !userEntity.getRole().getCode().equals(Constant.ROLE_ADMIN3)))
                return false;

            // check product authority
            if (url.startsWith("/admin/product")) {
                if (!userEntity.getMyAuthorities().contains("PRODUCT_MANAGING"))
                    return false;
            }

            // check customer authority
            else if (url.startsWith("/admin/customer")) {
                if (!userEntity.getMyAuthorities().contains("CUSTOMER_MANAGING"))
                    return false;
            }

            // check seller authority
            else if (url.startsWith("/admin/seller")) {
                if (!userEntity.getMyAuthorities().contains("SELLER_MANAGING"))
                    return false;
            }

        } else if (url.startsWith("/seller/")) {
            if (userEntity == null || !userEntity.getRole().getCode().equals(Constant.ROLE_SELLER))
                return false;
        } else if (url.startsWith("/customer/")) {
            if (userEntity == null) {
                if (!url.startsWith("/customer/my-account/login") &&
                        !url.startsWith("/customer/my-account/register") &&
                        !url.startsWith("/customer/my-account/create-seller") &&
                        !url.startsWith("/customer/product/") &&
                        !url.startsWith("/customer/information/"))
                    return false;

            }
        }

        return true;
    }

}
