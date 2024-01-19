package com.zlx.DesignPattern.Build;

/**
 * 创建三角形：1，三条边，
 * 2.任意两边之和大于第三边，任意两边值差小于第三边
 * @author BG270
 */
public class Triangle {
    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getThird() {
        return third;
    }

    private Integer first;
    private Integer second;
    private Integer third;
    public static class Builder {
        public Builder setFirst(Integer first) {
            if (first < 0) {
                throw new IllegalArgumentException("非法");
            }
            this.first = first;
            return this;
        }

        public Builder setSecond(Integer second) {
            if (second < 0) {
                throw new IllegalArgumentException("非法");
            }
            this.second = second;
            return this;
        }

        public Builder setThird(Integer third) {
            if (third < 0) {
                throw new IllegalArgumentException("非法");
            }
            this.third = third;
            return this;
        }

        private Integer first;
        private Integer second;
        private Integer third;

        public Triangle build() {
            if (first + second <= third || first + third <= second || second + third <= first) {
                throw new IllegalArgumentException("not Triangle");
            }
            System.out.println("Triangle");
            return new Triangle(this);
        }

    }

    private Triangle(Builder builder) {
        this.first = builder.first;
        this.second = builder.second;
        this.third = builder.third;
    }


    public static void main(String[] args) {
        Triangle triangle =new Triangle.Builder()
                .setFirst(3)
                .setSecond(4)
                .setThird(5)
                .build();
    }

}
