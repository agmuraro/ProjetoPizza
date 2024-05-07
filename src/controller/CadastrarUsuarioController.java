package controller;

import dao.Conexao;
import model.Usuario;
import view.CadastrarUsuarioView;

public class CadastrarUsuarioController {

    private CadastrarUsuarioView cdview;;
    private Usuario usuario;

    public CadastrarUsuarioController(){
        this.cdview = new CadastrarUsuarioView();
        this. usuario = this.cdview.cadastrar();

        Conexao.getInstancia();

    }





}



