package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.dto.PaymentActionDto;
import paymentsSystem.service.PaymentActionService;
import paymentsSystem.util.JspHelper;
import paymentsSystem.util.PathUtil;

import java.io.IOException;
import java.util.List;

import static paymentsSystem.util.PathUtil.ACTIONS;

@WebServlet(ACTIONS)
public class PaymentActionServlet extends HttpServlet {

    private static final PaymentActionService paymentActionService = PaymentActionService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<PaymentActionDto> paymentActionDto = paymentActionService.findAll();
        req.setAttribute("actions", paymentActionDto);
//        req.getSession().setAttribute("clientMap", clientDtos.stream()
//                .collect(Collectors.toMap(ClientDto::getClientId, ClientDto::getInfo)));

        req.getRequestDispatcher(JspHelper.getPath("clients"))
                .forward(req, resp);


    }
}
