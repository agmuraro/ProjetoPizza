package view;

import controller.LoginController;
import model.Usuario;
import java.util.Scanner;

public class LoginView {
    private LoginController lgc;
    private Scanner scanner;

    public LoginView(LoginController lgc, Scanner scanner) {
        this.lgc = lgc;
        this.scanner = scanner;
    }

    public void exibirLogin() {
        System.out.println("-------LOGIN--------");

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = lgc.autenticar(cpf, senha);

        if (usuario != null) {
            System.out.println("Login realizado, " + usuario.getNome());
        } else {
            System.out.println("Erro no login, informações incorretas.");
        }
    }
}
