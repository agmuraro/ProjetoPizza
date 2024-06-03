package controller;

import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import dao.UsuarioDAO;
import view.LoginView;
import java.util.Scanner;

public class LoginController {
    private UsuarioDAO usuarioDAO;
    private LoginView lgview;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void realizarLogin(Scanner scanner) {
        if (lgview == null) {
            lgview = new LoginView(this, scanner);
        }
        lgview.exibirLogin();
    }

    public void autenticarLogin(String email, String senha) {
        AuthenticationResultType resultado = usuarioDAO.autenticarCognito(email, senha);
        System.out.println("Resultado da autenticação: " + resultado);
        if (resultado != null) {
            lgview.loginSucesso();
        } else {
            lgview.loginFalha();
        }
    }
}


