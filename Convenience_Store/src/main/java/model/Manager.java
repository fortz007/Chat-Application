package model;

import enums.Role;

public class Manager extends Staff {

    public Manager() {
    }

    public Manager(Integer id, String name, Character sex, String contact, Role role) {
        super(id, name, sex, contact, role);
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }
}