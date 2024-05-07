package dao;

import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public UsuarioDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public void inserir(Usuario usuario){
        try{
            this.query = "INSERT INTO usuario (nome, cpf) VALUES (?,?)";
            this.ps = this.conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, usuario.getNome());
            this.ps.setString(2, usuario.getCpf());
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
