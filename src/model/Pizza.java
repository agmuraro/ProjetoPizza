package model;

public class Pizza {
    private String sabor;
    private String preco;

    public Pizza(String sabor, String preço) {
        this.sabor = sabor;
        this.preco = preço;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preço) {
        this.preco = preço;
    }
}
