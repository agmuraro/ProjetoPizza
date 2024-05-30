package controller;

import dao.PizzaDAO;
import view.FazerPedidoView;

public class FazerPedidoController {
    private FazerPedidoView fpv;
    private PizzaDAO pDAO;

    public FazerPedidoController(){
        this.fpv = new FazerPedidoView();
        this.pDAO = new PizzaDAO();
        fpv.listarPedidos(this.pDAO.listarPizzas());
    }
}
