package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FazerPedidoView {


    private List<String> pizzas = new ArrayList<>();

    public List<String> fazerPedido(ResultSet lista) {
        System.out.println("\n--- SABORES DE PIZZA ---");
        try {
            int i = 1;
            while (lista.next()) {
                String sabor = lista.getString("sabor");
                String preco = lista.getString("preco");
                pizzas.add(sabor);
                System.out.println(i + ". Sabor: " + sabor + "  Preço:" + preco);
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pizzas;
    }

    public void listarPedidos(ResultSet lista){
        System.out.println("\n---SABORES DE PIZZA---");

        try{
            while(lista.next()){
                System.out.println("Sabor: " + lista.getString("sabor"));
                System.out.println("Preço: " + lista.getString("preco") + "\n");

            }
        }
        catch(SQLException ex){
            ex.printStackTrace();

    }
}}
