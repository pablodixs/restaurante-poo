public class Item {
    private String nome;
    private String categoria;
    private double preco;

    public Item(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void getDetalhesItem() {
        System.out.println("Nome do prato: " + this.nome);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Categoria: " + this.categoria);
    }
}
