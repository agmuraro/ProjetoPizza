package controller;

import view.MenuView;
import java.util.Scanner;

public class MenuController {
    private CadastrarUsuarioController cduser;
    private LoginController lguser;
    private MenuView mv;
    private Scanner scanner;
    private int opcao;

    public MenuController(Scanner scanner) {
        this.scanner = scanner;
        this.mv = new MenuView(scanner);
        this.lguser = new LoginController();

        while (this.opcao != 9) {
            this.opcao = this.mv.menu();

            if (this.opcao == 1) {
                this.cduser = new CadastrarUsuarioController(scanner);
            } else if (this.opcao == 2) {
                lguser.realizarLogin(scanner);
            } else if (this.opcao == 9) {
                this.mv.sair();
            } else {
                this.mv.opcaoInvalida();
            }
        }
    }
}
