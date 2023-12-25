package paymentsSystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.service.BankAccountService;
import paymentsSystem.util.JspHelper;

import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class BankAccountServletID extends HttpServlet {

    private static final BankAccountService bankAccountService = BankAccountService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var bankAccountId = Integer.valueOf(req.getParameter("bankAccountId"));
        List<BankAccountDto> bankAccountDto = bankAccountService.findByBankAccountId(bankAccountId);
        req.setAttribute("accounts", bankAccountDto);

        req.getRequestDispatcher(JspHelper.getPath("idBankAccount"))
                .forward(req, resp);

    }
}




