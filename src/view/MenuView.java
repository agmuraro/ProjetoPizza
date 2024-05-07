package view;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner;

    public MenuView(){
        this.scanner = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("--- PIZZARIA ---");
        System.out.println("É necessário cadastro para fazer um pedido!");
        System.out.println("(1) Cadastrar usuário");
        System.out.println("(2) Entrar");
        System.out.println("(3) Entrar como Admin");
        System.out.println("Opção: ");
        return scanner.nextInt();
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida!");
    }


}
