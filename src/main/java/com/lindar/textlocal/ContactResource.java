package com.lindar.textlocal;

import com.google.gson.Gson;
import com.lindar.textlocal.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactResource extends BaseResource {

    private static final String GROUP_NAME_FIELD = "name";
    private static final String GROUP_ID_FIELD = "group_id";
    private static final String CONTACTS_FIELD = "contacts";
    private static final String NUMBER_FIELD = "number";


    private static final int MAX_BULK_CONTACTS = 1500;

    ContactResource(String apiKey) {
        super(apiKey);
    }

    public TextlocalGroupCreateResponse createGroup(String groupName){

        if(groupName == null || groupName.isEmpty()) throw new IllegalArgumentException("Group Name must not be blank");

        Map<String, String> params = new HashMap<>();
        params.put(GROUP_NAME_FIELD, groupName);
        return newPostRequest(Endpoints.Contacts.CREATE_GROUP, params)
                .fromJson()
                .castTo(TextlocalGroupCreateResponse.class);
    }

    public TextlocalGroupListResponse listGroups(){
        return newPostRequest(Endpoints.Contacts.GET_GROUPS)
                .fromJson()
                .castTo(TextlocalGroupListResponse.class);
    }

    public TextlocalBulkCreateContactsResponse createBulkContacts(List<TextlocalContact> contacts, long groupId){

        if(contacts == null || contacts.isEmpty()) throw new IllegalArgumentException("Contacts must not be empty");
        if(contacts.size() > MAX_BULK_CONTACTS) throw new IllegalArgumentException("You can only create up to " + MAX_BULK_CONTACTS + " contacts at a time");

        Map<String, String> params = new HashMap<>();
        params.put(GROUP_ID_FIELD, String.valueOf(groupId));
        params.put(CONTACTS_FIELD, new Gson().toJson(contacts));

        return newPostRequest(Endpoints.Contacts.CREATE_CONTACTS_BULK, params)
                .fromJson()
                .castTo(TextlocalBulkCreateContactsResponse.class);
    }

    public TextlocalContactDeleteResponse deleteContact(String number, long groupId){
        Map<String, String> params = new HashMap<>();
        params.put(GROUP_ID_FIELD, String.valueOf(groupId));
        params.put(NUMBER_FIELD, number);

        return newPostRequest(Endpoints.Contacts.DELETE_CONTACT, params)
                .fromJson()
                .castTo(TextlocalContactDeleteResponse.class);
    }
}
