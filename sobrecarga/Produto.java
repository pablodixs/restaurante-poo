public class Produto {
    public void exibirInformacoes(String nome) {
        System.out.println("Nome: " + nome);
    }
    public void exibirInformacoes(String nome, int codigo) {
        System.out.println("Nome: " + nome + ", Código: " + codigo);
    }
    public void exibirInformacoes(String nome, int codigo, double preco) {
        System.out.println("Nome: " + nome + ", Código: " + codigo + ", Preço: R$ " + preco);
    }
}
