package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.UserCreateDto;
import paymentsSystem.entity.Role;
import paymentsSystem.exception.ValidationException;
import paymentsSystem.service.UserProfileService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.util.List;

import static paymentsSystem.entity.Role.ADMIN;
import static paymentsSystem.entity.Role.USER;
import static paymentsSystem.util.PathUtil.LOGIN;
import static paymentsSystem.util.PathUtil.REGISTRATION;

@WebServlet(REGISTRATION)
public class RegistrationServlet extends HttpServlet {


    private final UserProfileService userProfileService = UserProfileService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("role", List.of(ADMIN, USER));

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var build = UserCreateDto.builder()
                .login(req.getParameter("login"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .createdTime(req.getParameter("date"))
                .build();
        try {
            userProfileService.create(build);
            resp.sendRedirect(LOGIN);
        }catch (ValidationException exception){
            req.setAttribute("errors", exception.getErrors());
            doGet(req, resp);
        }
    }
}
