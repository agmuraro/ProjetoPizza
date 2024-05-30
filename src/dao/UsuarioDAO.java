package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public UsuarioDAO() {
        this.conexao = Conexao.getInstancia();
    }

    public void inserir(Usuario usuario) {
        try {
            this.query = "INSERT INTO usuario (nome, cpf, senha) VALUES (?,?,?)";
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, usuario.getNome());
            this.ps.setString(2, usuario.getCpf());
            this.ps.setString(3, usuario.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Usuario login(String cpf, String senha) {
        Usuario usuario = null;
        try {
            this.query = "SELECT * FROM usuario WHERE cpf = ? AND senha = ?";
            this.ps = conexao.getConnection().prepareStatement(this.query);
            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usuario;
    }
}

