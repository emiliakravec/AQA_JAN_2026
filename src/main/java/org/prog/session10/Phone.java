package org.prog.session10;

import java.util.Objects;

public class Phone {
    private String model;
    private String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }
//testt
    @Override
    public boolean equals(Object o) {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        return Objects.equals(model, phone.model) &&
                Objects.equals(color, phone.color);
    }

    @Override
    public int hashCode() {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        return Objects.hash(model, color);
    }
}