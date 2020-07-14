package CHAPTER1;


public class Apple {
    String color;
    int weight;

    public int getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Apple(String color , int weight){
        this.color= color;
        this.weight=weight;
    }

}
