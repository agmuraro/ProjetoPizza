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
                while (this.opcaop != 9){
                    this.opcaop = this.mv.menuPedido();
                        if (this.opcaop == 1 ){
                            this.opcaop = this.mv.menuEscolha();
                            while(this.opcaop != 9) {
                                mv.confirmaPedido();
                                break;
                            }
                        }
                        else if (this.opcaop == 2){
                            this.fpc = new FazerPedidoController();

                        }
                        else if (this.opcaop == 9){
                            this.mv.sair();
                            break;
                        }
                        if(opcaop == 9){
                            mv.sair();
                            break;
                        }
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
