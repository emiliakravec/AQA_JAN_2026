package org.prog.session10;

public class Android {
    private String model;
    private String color;

    public Android(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Android android = (Android) o;

        return model.equals(android.model) && color.equals(android.color);
    }

    @Override
    public int hashCode() {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        return model.hashCode() + color.hashCode();
    }
}
