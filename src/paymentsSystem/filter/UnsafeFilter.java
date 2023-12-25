package paymentsSystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.UserCreateDto;

import java.io.IOException;

import static paymentsSystem.util.PathUtil.REGISTRATION;

@WebFilter("/admin") public class UnsafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var user = (UserCreateDto)((HttpServletRequest)servletRequest).getSession().getAttribute("user");
        if ((user!= null)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect(REGISTRATION);
        }
    }
}
