package controller;

import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import dao.UsuarioDAO;
import model.Usuario;
import view.LoginView;
import view.MenuView;

import java.util.Scanner;

public class LoginController {
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioL;
    private LoginView lgview;
    private AuthenticationResultType resultadoAut;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void realizarLogin(Scanner scanner) {
        if (lgview == null) {
            lgview = new LoginView(this, scanner);
        }
        Usuario usuarioL = lgview.exibirLogin();
        autenticarLogin(usuarioL.getEmail(),usuarioL.getSenha());
    }

    public void autenticarLogin(String email, String senha) {
        this.resultadoAut = usuarioDAO.autenticarCognito(email, senha);
        if (this.resultadoAut != null) {
            lgview.loginSucesso();
        } else {
            lgview.loginFalha();
        }
    }
}


