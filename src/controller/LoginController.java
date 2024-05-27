package controller;

import dao.UsuarioDAO;
import model.Usuario;
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

    public Usuario autenticar(String cpf, String senha) {
        return usuarioDAO.login(cpf, senha);
    }
}
