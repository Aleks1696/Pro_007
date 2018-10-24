package jdbc.homework08.task1;

public class QuadE {

    private Integer id;
    private Double a;
    private Double b;
    private Double c;
    private Double d;
    private Double x1;
    private Double x2;

    public QuadE(Integer id, Double a, Double b, Double c, Double d, Double x1, Double x2) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getA() {
        return a;
    }
    public void setA(Double a) {
        this.a = a;
    }
    public Double getB() {
        return b;
    }
    public void setB(Double b) {
        this.b = b;
    }
    public Double getC() {
        return c;
    }
    public void setC(Double c) {
        this.c = c;
    }
    public Double getD() {
        return d;
    }
    public void setD(Double d) {
        this.d = d;
    }
    public Double getX1() {
        return x1;
    }
    public void setX1(Double x1) {
        this.x1 = x1;
    }
    public Double getX2() {
        return x2;
    }
    public void setX2(Double x2) {
        this.x2 = x2;
    }
}
