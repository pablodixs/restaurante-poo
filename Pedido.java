import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> itens;
    private Cliente cliente;
    private double total;
    private String status;

    public Pedido() {

    }

    public Pedido(ArrayList<Item> itens, Cliente cliente, String status) {
        this.itens = itens;
        this.cliente = cliente;
        this.status = status;
    }

    public Pedido(Cliente cliente, String status) {
        this.cliente = cliente;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for(Item item : this.itens) {
            total += item.getPreco();
        }

        this.total = total;
        return total;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
}
