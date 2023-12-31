package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.service.BankAccountService;
import paymentsSystem.service.ClientService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static paymentsSystem.util.PathUtil.CLIENTS;

@WebServlet(CLIENTS)
public class ClientServlet extends HttpServlet {

    private static final ClientService clientService = ClientService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<ClientDto> clientDtos = clientService.findAll();
        req.setAttribute("clients", clientDtos);
//        req.getSession().setAttribute("clientMap", clientDtos.stream()
//                .collect(Collectors.toMap(ClientDto::getClientId, ClientDto::getInfo)));

        req.getRequestDispatcher(JspHelper.getPath("clients"))
                .forward(req, resp);


    }
}

