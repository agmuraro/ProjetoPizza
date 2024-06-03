package controller;

import view.MenuView;
import java.util.Scanner;

public class MenuController {
    private CadastrarUsuarioController cduser;
    private CadastrarPizzaController cpc;
    private FazerPedidoController fpc;

    private LoginController lguser;
    private MenuView mv;
    private Scanner scanner;
    private int opcaoc;
    private int opcaop;
    private boolean resultadoLogin;

    public MenuController(Scanner scanner) {
        this.scanner = scanner;
        this.mv = new MenuView(scanner);
        this.lguser = new LoginController();

        while (this.opcaoc != 9) {
            this.opcaoc = this.mv.menuCadastro();

            if (this.opcaoc == 1) {
                this.cduser = new CadastrarUsuarioController(scanner);
                cduser.cadastrar();
            } else if (this.opcaoc == 2) {
                lguser.realizarLogin(scanner);
                this.mv.menuPedido();
                this.opcaop = this.mv.menuPedido();
                while (this.opcaop != 9){



                }
            } else if (this.opcaoc == 3) {
                this.fpc = new FazerPedidoController();
            } else if (this.opcaoc == 4) {
                this.cpc = new CadastrarPizzaController();
            } else if (this.opcaoc == 9) {
                this.mv.sair();
            } else {
                this.mv.opcaoInvalida();
            }
        }
    }
}
