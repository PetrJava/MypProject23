package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dao.UserProfileDao;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.service.BankAccountService;
import paymentsSystem.service.ClientService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/accounts")
public class BankAccountServlet extends HttpServlet {

    private static final BankAccountService bankAccountService = BankAccountService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        var bankAccountId = Integer.valueOf(req.getParameter("bankAccountId"));
//        req.setAttribute("accounts", bankAccountService.getFindByBankAccountId(bankAccountId));
        var bankAccountId = Integer.valueOf(req.getParameter("bankAccountId"));
        List<BankAccountDto> bankAccountDtos = bankAccountService.getFindByBankAccountId(bankAccountId);
        req.setAttribute("accounts", bankAccountDtos);

        req.getRequestDispatcher(JspHelper.getPath("bankAccount"))
                .forward(req, resp);

//        req.getRequestDispatcher(UserProfileDao.getInstance());

//        try (var printWriter = resp.getWriter()) {
//            printWriter.write("<h1>Банковский счет клиента</h1>");
//            printWriter.write("<ul>");
//            bankAccountService.getFindByBankAccountId(bankAccountId).forEach(bankAccountDto -> {
//                printWriter.write("""
//                        <li>
//                        Id-%d  Balance: %s $    -   Created Time: %s
//                        </li>""".formatted(bankAccountDto.getBankAccountId(), bankAccountDto.getBankAccountBalance(), bankAccountDto.getCreatedTime()));
//            });
//            printWriter.write("</ul>");
//        }
    }
}



