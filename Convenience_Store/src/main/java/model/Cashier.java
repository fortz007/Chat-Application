package model;

import enums.Role;

public class Cashier extends Staff{
    public Cashier() {
    }

    public Cashier(Integer id, String name, Character sex, String contact, Role role) {
        super(id, name, sex, contact, role);
    }


}
