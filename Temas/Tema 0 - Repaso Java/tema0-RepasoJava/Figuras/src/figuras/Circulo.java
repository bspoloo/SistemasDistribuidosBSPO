package figuras;

public class Circulo implements IFigura{
    private int radio;
    public Circulo(int radio) {
        this.radio = radio;
    }
    public int getRadio() {
        return this.radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }
    @Override
    public int area() {
        return (int) Math.pow(Math.PI * radio, 2);
    }

    @Override
    public int perimetro() {
        return (int) (2*Math.PI * radio);
    }
}
