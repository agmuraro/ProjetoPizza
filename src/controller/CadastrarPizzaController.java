package controller;

import dao.PizzaDAO;
import model.Pizza;
import view.CadastrarPizzaView;

import java.text.Normalizer;

public class CadastrarPizzaController {
    private CadastrarPizzaView cpv;
    private Pizza pizza;
    private PizzaDAO pDAO;

    public CadastrarPizzaController() {
        this.cpv = new CadastrarPizzaView();
        this.pizza = normalizePizza(this.cpv.cadastrarPizza());
        this.pDAO = new PizzaDAO();
        this.pDAO.inserirPizza(this.pizza);
    }

    private Pizza normalizePizza(Pizza pizza) {
        String sabor = Normalizer.normalize(pizza.getSabor(), Normalizer.Form.NFKC);
        String preco = Normalizer.normalize(pizza.getPreco(), Normalizer.Form.NFKC);
        return new Pizza(sabor, preco);
    }
}
