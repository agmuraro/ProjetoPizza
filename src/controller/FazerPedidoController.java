package controller;

import dao.PizzaDAO;
import view.FazerPedidoView;

import java.util.List;

public class FazerPedidoController {
    private FazerPedidoView fpv;
    private PizzaDAO pDAO;
    private List<String> pizzas;

    public FazerPedidoController() {
        this.fpv = new FazerPedidoView();
        this.pDAO = new PizzaDAO();
        this.pizzas = fpv.fazerPedido(this.pDAO.listarPizzas());
    }

    public List<String> getPizzas() {
        return pizzas;
    }
}
