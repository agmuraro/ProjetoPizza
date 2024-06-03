package view;

import model.Usuario;
import java.util.Scanner;

public class CadastrarUsuarioView {
    private Scanner scanner;

    public CadastrarUsuarioView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Usuario cadastrar() {
        System.out.println("\n--- Cadastrar Usuário ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Usuario(senha, email);
    }

    public void sucesso(){
        System.out.println("\nUsuário cadastrado com sucesso.");
    }
    public void falha(){
        System.out.println("\nFalha ao cadastrar.");
    }
}
