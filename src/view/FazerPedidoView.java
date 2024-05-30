package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class FazerPedidoView {

    public void listarPedidos(ResultSet lista){
        System.out.println("---SABORES DE PIZZA---");

        try{
            while(lista.next()){
                System.out.println("Sabor: " + lista.getString("sabor"));
                System.out.println("Preço: " + lista.getString("preco") + "\n");

            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
