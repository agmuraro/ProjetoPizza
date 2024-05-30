package dao;

import model.Pizza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public PizzaDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public void inserirPizza(Pizza pizza){

        try{
            this.query = "INSERT INTO pizzas (sabor, preco) VALUES (?,?)";
            this.ps = this.conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, pizza.getSabor());
            this.ps.setString(2, pizza.getPreco());
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet listarPizzas(){
        try{
            this.query = "SELECT * FROM pizzas";
            this.ps = this.conexao.getConnection().prepareStatement(this.query);
            return this.ps.executeQuery();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
