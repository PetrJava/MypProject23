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

@WebServlet("/clients")
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


//        var bankAccountId = Integer.valueOf(req.getParameter("bankAccountId"));
//        List<BankAccountDto> bankAccountDtos = bankAccountService.getFindByBankAccountId(bankAccountId);
//        req.setAttribute("accounts",bankAccountDtos);
//

//        try (var printWriter = resp.getWriter()) {
//            printWriter.write("<h1>Список клиентов</h1>");
//            printWriter.write("<ul>");
//
//            clientService.findAll().forEach(ClientDto ->
//                    printWriter.write("""
//                            <li>
//                            <a href="/accounts?bankAccountId=%d">%d - %s</a>
//                            </li>""".formatted(ClientDto.getClientId(), ClientDto.getClientId(), ClientDto.getInfo()))
//            );
//            printWriter.write("</ul>");
//        }
    }
}

