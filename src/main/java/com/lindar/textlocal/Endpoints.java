package com.lindar.textlocal;

interface Endpoints {

    String BASE = "http://api.txtlocal.com";

    interface Contacts {
        String CREATE_GROUP = BASE + "/create_group";
        String GET_GROUPS = BASE + "/get_groups";
        String CREATE_CONTACTS_BULK = BASE + "/create_contacts_bulk";
        String DELETE_CONTACT = BASE + "/delete_contact";
    }
}
