package view;

import model.Usuario;

import java.util.Scanner;

public class CadastrarUsuarioView {

    private Scanner scanner;

    public CadastrarUsuarioView(){

        this.scanner = new Scanner(System.in);
    }

    public Usuario cadastrar(){
        System.out.println("--- Cadastrar Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        return new Usuario(nome, cpf);
    }

}
