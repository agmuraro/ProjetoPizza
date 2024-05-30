package view;

import model.Pizza;

import java.util.Scanner;

public class CadastrarPizzaView {
    private Scanner scanner;

    public CadastrarPizzaView() {

        this.scanner = new Scanner(System.in);
    }

    public Pizza cadastrarPizza() {
        System.out.println("--- Cadastrar Pizza ---");
        System.out.print("Sabor: ");
        String sabor = scanner.nextLine();
        System.out.print("Preço: ");
        String preco = scanner.nextLine();

        return new Pizza(sabor,preco);
    }
}
