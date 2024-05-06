package controller;

import view.MenuView;

public class MenuController {

    private MenuView mv;
    private int opcao;

    public MenuController(){
        this.mv = new MenuView();

        while(this.opcao != 9) {
            this.opcao = this.mv.menu();

            if(this.opcao == 1){

            }else if(this.opcao == 2){

            }else{
                this.mv.opcaoInvalida();
            }
        }


    }

}
