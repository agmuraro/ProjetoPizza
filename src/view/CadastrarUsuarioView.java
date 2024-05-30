package view;

import model.Usuario;
import java.util.Scanner;

public class CadastrarUsuarioView {
    private Scanner scanner;

    public CadastrarUsuarioView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Usuario cadastrar() {
        System.out.println("--- Cadastrar Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Usuario(nome, senha, cpf);
    }
}
