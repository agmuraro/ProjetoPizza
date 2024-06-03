package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(Scanner scanner){
        this.scanner = scanner;
    }

    public int menuCadastro(){
        System.out.println("--- PIZZARIA ---");
        System.out.println("É necessário cadastro para fazer um pedido!");
        System.out.println("(1) Cadastrar-se");
        System.out.println("(2) Entrar");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        int opcaoc = scanner.nextInt();
        scanner.nextLine();
        return opcaoc;
    }

    public int menuPedido(){
        System.out.println("--- PIZZARIA ---");
        System.out.println("(1) Fazer pedido");
        System.out.println("(2) Listar pizzas");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        int opcaop = scanner.nextInt();
        scanner.nextLine();
        return opcaop;
    }

    public void sair(){
        System.out.println("Saindo...");
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida!");
    }
}
