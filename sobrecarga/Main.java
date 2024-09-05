public class Main {
    public static void main(String[] args) {
        // Questão 1
        FormaGeometrica forma = new FormaGeometrica();

        System.out.println(forma.calculaArea(6));
        System.out.println(forma.calculaArea(6, true));
        System.out.println(forma.calculaArea(51, 10));

        // Questão 2
        Calculadora calculadora = new Calculadora();

        System.out.println();
        System.out.println(calculadora.soma(1, 2));
        System.out.println(calculadora.soma(2.5, 9.2));

        // Questão 3
        Produto produto = new Produto();

        System.out.println();
        produto.exibirInformacoes("PS5");
        produto.exibirInformacoes("iPhone", 5);
        produto.exibirInformacoes("RTX 4090", 12, 4.987);

        // Questão 4
        Contribuinte c1 = new Contribuinte();

        c1.setNome("Matheus");
        c1.setSalarioBruto(3.687);
        c1.calcularImposto();

        System.out.println("Salário líquido de " + c1.getNome() + ": R$ " + c1.getSalarioLiquido());
        System.out.println(c1.toString());

        // Questão 5
        Cachorro doge = new Cachorro();
        Urubu flamengo = new Urubu();

        System.out.println();

        doge.comer();
        doge.andar();
        doge.latir();

        flamengo.andar();
        flamengo.pedePix();
    }
}
