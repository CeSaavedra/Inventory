import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Widget implements Comparable<Widget> {
    private int sku;
    private String prodName;
    private double size;
    private Integer quant;
    private Double price;

    public Double getPrice() {
        return price;
    }

    private double value;

    public Widget(int sku,String prodName,double size,Integer quant,Double price){
        this.sku = sku;
        this.prodName = prodName;
        this.size = size;
        this.quant = quant;
        this.price = price;
    }

    public Integer getQuant() {
        return quant;
    }

    @Override
    public int compareTo(Widget other){
        return 0;
    }
    public Integer getSku(){
        return sku;
    }
    public String getProdName(){
        return prodName;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "sku=" + sku +
                ", prodName='" + prodName + '\'' +
                ", size=" + size +
                ", quant=" + quant +
                ", price=" + price +
                '}';
    }
}
