public class FormaGeometrica {
    public double calculaArea(int base, int altura) {
        return base * altura;
    }

    public double calculaArea(double raio, boolean isCircle) {
        return Math.PI * (raio * raio);
    }

    public double calculaArea(double lado) {
        return lado * lado;
    }
}
