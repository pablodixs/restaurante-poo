public class Contribuinte {
    private String nome;
    private double salarioBruto;

    private double salarioLiquido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public double calcularImposto() {
        if(salarioBruto < 1.903) {
            return 0;
        } else if(salarioBruto > 1.903 && salarioBruto < 2.826) {
            double deducao = salarioBruto * 0.075;

            this.salarioLiquido = salarioBruto - deducao;

            return deducao;
        } else if(salarioBruto > 2.826 && salarioBruto < 3.751) {
            double deducao = salarioBruto * 0.15;

            this.salarioLiquido = salarioBruto - deducao;

            return deducao;
        } else if(salarioBruto > 3.751 && salarioBruto < 4.664) {
            double deducao = salarioBruto * 0.225;

            this.salarioLiquido = salarioBruto - deducao;

            return deducao;
        } else {
            double deducao = salarioBruto * 0.275;

            this.salarioLiquido = salarioBruto - deducao;

            return deducao;
        }
    }

    public String toString() {
        return "Nome: " +
                this.nome
                + " | Salário Bruto: R$ "
                + this.salarioBruto
                + " | Salário líquido: R$ "
                + this.salarioLiquido;
    }
}
