package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import paymentsSystem.dto.UserProfileDto;
import paymentsSystem.service.UserProfileService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;

import static paymentsSystem.util.PathUtil.*;

@WebServlet(LOGIN)
public class LoginServlet extends HttpServlet {


    private final UserProfileService userProfileService = UserProfileService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userProfileService.login(req.getParameter("email"), req.getParameter("password"))
                .ifPresentOrElse(
                        user -> {
                            try {
                                onLoginSuccess(user, req, resp);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> onLoginFail(req, resp)
                );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
         resp.sendRedirect(LOGIN + "?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(UserProfileDto user, HttpServletRequest req, HttpServletResponse resp) throws IOException {
    req.getSession().setAttribute("user", user);
    resp.sendRedirect(MAIN);
    }
}
