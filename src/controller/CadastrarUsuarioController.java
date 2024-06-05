package controller;

import com.amazonaws.services.cognitoidp.model.AWSCognitoIdentityProviderException;
import dao.UsuarioDAO;
import model.Usuario;
import view.CadastrarUsuarioView;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Scanner;

public class CadastrarUsuarioController {
    private CadastrarUsuarioView cdview;
    private Usuario usuario;
    private UsuarioDAO uDAO;

    public CadastrarUsuarioController(Scanner scanner) {
        this.cdview = new CadastrarUsuarioView(scanner);
        this.usuario = normalizeUsuario(this.cdview.cadastrar());
        this.uDAO = new UsuarioDAO();
    }

    public void cadastrar() {
        try {
            uDAO.cadastrarUsuarioCognito(this.usuario);
            uDAO.inserirUsuario(this.usuario);
            cdview.sucesso();
        } catch (AWSCognitoIdentityProviderException e) {
            cdview.falha();
        }
    }
    private Usuario normalizeUsuario(Usuario usuario) {
        String email = Normalizer.normalize(usuario.getEmail(), Normalizer.Form.NFKC);
        String senha = Normalizer.normalize(usuario.getSenha(), Normalizer.Form.NFKC);
        return new Usuario(senha, email);
    }

}
