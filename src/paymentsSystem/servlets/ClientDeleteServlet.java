package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.service.ClientService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.util.List;

import static paymentsSystem.util.PathUtil.CLIENTS;
import static paymentsSystem.util.PathUtil.CLIENTS_DELETE;

@WebServlet(CLIENTS_DELETE)
public class ClientDeleteServlet extends HttpServlet {

    private static final ClientService clientService = ClientService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        var clientId = Integer.valueOf(req.getParameter("clientId"));
        req.setAttribute("clients", clientService.deleteClient(clientId));

        req.getRequestDispatcher(JspHelper.getPath("clients"))
                .forward(req, resp);


    }
}

