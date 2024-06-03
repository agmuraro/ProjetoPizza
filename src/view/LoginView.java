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

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        lgc.autenticarLogin(email, senha);

    }
    public void loginSucesso(){
        System.out.println("Login realizado com sucesso.");
    }public void loginFalha(){
        System.out.println("Falha ao realizar login, usuário não encontrado.");
    }
}
