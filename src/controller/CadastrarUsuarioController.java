package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.CadastrarUsuarioView;
import java.util.Scanner;

public class CadastrarUsuarioController {
    private CadastrarUsuarioView cdview;
    private Usuario usuario;
    private UsuarioDAO uDAO;

    public CadastrarUsuarioController(Scanner scanner) {
        this.cdview = new CadastrarUsuarioView(scanner);
        this.usuario = this.cdview.cadastrar();
        this.uDAO = new UsuarioDAO();
    }
   public void cadastrar(){
        try{
        uDAO.cadastrarUsuarioCognito(this.usuario);
        cdview.sucesso();

   } catch (Exception e) {
            cdview.falha();
        }
    }
}
