package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.CadastrarUsuarioView;

public class CadastrarUsuarioController {

    private CadastrarUsuarioView cdview;;
    private Usuario usuario;
    private UsuarioDAO uDAO;

    public CadastrarUsuarioController(){
        this.cdview = new CadastrarUsuarioView();
        this. usuario = this.cdview.cadastrar();
        this.uDAO = new UsuarioDAO();
        this.uDAO.inserir(this.usuario);

    }





}



