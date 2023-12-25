package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.TypeOperationDto;
import paymentsSystem.service.TypeOperationService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.util.List;

import static paymentsSystem.util.PathUtil.OPERATIONS;

@WebServlet("/operations")
public class TypeOperationServlet extends HttpServlet {

    private static final TypeOperationService operationService = TypeOperationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TypeOperationDto> typeOperation = operationService.findAll();
        req.setAttribute("operations", typeOperation);
        req.getRequestDispatcher(JspHelper.getPath("operations"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
