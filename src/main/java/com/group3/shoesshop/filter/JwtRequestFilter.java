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
        if (url.contains("/admin/")) {
            if (userSession == null || !userSession.getRole().getCode().equals(Constant.ROLE_ADMIN)) {
                response.sendRedirect("/logout");
                return;
            }
        } else if (url.contains("/seller/")) {
            if (userSession == null || !userSession.getRole().getCode().equals(Constant.ROLE_SELLER)) {
                response.sendRedirect("/logout");
                return;
            }
        } else if (url.contains("/customer/")) {
            if (userSession == null) {
                if (!url.contains("/customer/my-account/login") &&
                        !url.contains("/customer/my-account/register") &&
                        !url.contains("/customer/my-account/create-seller") &&
                        !url.contains("/customer/product/") &&
                        !url.contains("/customer/information/")){
                    response.sendRedirect("/logout");
                    return;
                }

            }
        }

        filterChain.doFilter(request, response);

    }

}
