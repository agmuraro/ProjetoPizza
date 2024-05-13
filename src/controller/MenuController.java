package controller;

import view.MenuView;

public class MenuController {

    private CadastrarUsuarioController cduser;
    private MenuView mv;
    private int opcao;

    public MenuController() {
        this.mv = new MenuView();

        while (this.opcao != 9) {
            this.opcao = this.mv.menu();

            if (this.opcao == 1) {
                this.cduser = new CadastrarUsuarioController();

            } else if (this.opcao == 2) {

            } else if (this.opcao == 9){
                this.mv.sair();
            } else{
                this.mv.opcaoInvalida();
            }


        }

    }
}
