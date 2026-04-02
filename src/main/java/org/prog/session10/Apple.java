package org.prog.session10;

public class Apple {
    private String model;
    private String color;

    public Apple(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        if (model == null || color == null ||
        apple.model == null || apple.color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        return model.equals(apple.model) && color.equals(apple.color);
    }

    @Override
    public int hashCode() {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        return model.hashCode() + color.hashCode();
    }
}