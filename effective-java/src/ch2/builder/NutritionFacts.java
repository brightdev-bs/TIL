package ch2.builder;

public class NutritionFacts {

    private int servingSize;
    private int serving;
    private int calories;
    private int fat;

    public NutritionFacts(int servingSize, int serving) {
        this(servingSize, serving, 0);
    }

    public NutritionFacts(int servingSize, int serving, int calories) {
        this(servingSize, serving, calories, 0);
    }

    public NutritionFacts(int servingSize, int serving, int calories, int fat) {
        this.servingSize = servingSize;
        this.serving = serving;
        this.calories = calories;
        this.fat = fat;
    }

    public NutritionFacts() {}

    public void setServingSize(int servingSize) {this.servingSize = servingSize;}

    public void setServing(int serving) {this.serving = serving;}

    public void setCalories(int calories) {this.calories = calories;}

    public void setFat(int fat) {this.fat = fat;}
}
