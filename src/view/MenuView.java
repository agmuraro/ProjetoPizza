package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(Scanner scanner){
        this.scanner = scanner;
    }

    public int menu(){
        System.out.println("--- PIZZARIA ---");
        System.out.println("É necessário cadastro para fazer um pedido!");
        System.out.println("(1) Cadastrar usuário");
        System.out.println("(2) Entrar");
        System.out.println("(3) Fazer pedido");
        System.out.println("(4) Cadastrar pizza");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void sair(){
        System.out.println("Saindo...");
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida!");
    }
}
