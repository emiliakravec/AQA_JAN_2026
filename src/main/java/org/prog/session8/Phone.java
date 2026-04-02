package org.prog.session8;

public abstract class Phone implements IPhone {
    protected String model;
    protected String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;

        Phone phone = (Phone) o;
        return model.equals(phone.model) && color.equals(phone.color);
    }

    @Override
    public int hashCode() {
        return model.hashCode() + color.hashCode();
    }
}
