package paymentsSystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.UserCreateDto;
import paymentsSystem.dto.UserProfileDto;
import paymentsSystem.entity.Role;
import paymentsSystem.entity.RoleEntity;
import paymentsSystem.util.PathUtil;

import java.io.IOException;
import java.util.Set;

import static paymentsSystem.entity.Role.ADMIN;
import static paymentsSystem.util.PathUtil.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(uri) || isUserLogged(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            var prevPage = ((HttpServletRequest) servletRequest).getHeader("referer");
            ((HttpServletResponse) servletResponse).sendRedirect(prevPage != null ? prevPage : LOGIN);
        }
    }

    private boolean isUserLogged(ServletRequest request) {
        var user = (UserProfileDto) ((HttpServletRequest) request).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }


}
