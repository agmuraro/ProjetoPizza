package controller;

import dao.Conexao;
import dao.PizzaDAO;
import model.Pizza;
import view.CadastrarPizzaView;

public class CadastrarPizzaController {
    private CadastrarPizzaView cpv;
    private Pizza pizza;
    private PizzaDAO pDAO;

    public CadastrarPizzaController(){
        this.cpv = new CadastrarPizzaView();
        this.pizza = this.cpv.cadastrarPizza();
        this.pDAO = new PizzaDAO();
        this.pDAO.inserirPizza(this.pizza);


    }

}
