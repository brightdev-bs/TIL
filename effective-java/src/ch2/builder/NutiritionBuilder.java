package ch2.builder;

public class NutiritionBuilder {

    // 필수 값
    private final int servingSize;
    private final int servings;

    // 선택 값
    private final int calories;
    private final int fat;

    public static class Builder {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = fat;
            return this;
        }

        public NutiritionBuilder build() {
            return new NutiritionBuilder(this);
        }
    }

    private NutiritionBuilder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }
}
