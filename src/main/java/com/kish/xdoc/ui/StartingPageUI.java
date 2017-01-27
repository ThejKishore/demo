/*
package com.kish.xdoc.ui;

import com.kish.xdoc.dbo.Contact;
import com.kish.xdoc.rs.service.client.RestContactTemplate;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

*/
/**
 * Created by ThejKishore on 12/29/2016.
 *//*

@SpringUI
public class StartingPageUI extends UI {

    private TextField textField;
    private Tree tree;
    private Object treeNode;

    @Autowired
    RestContactTemplate restContactTemplate;

    protected void init(VaadinRequest vaadinRequest){
//        setContent(new Label("Hello World tTextFieldhis is Vaadin label"));
        VerticalLayout basePage = new VerticalLayout();
        BeanContainer<Long,Contact> beanItemContainer = new BeanContainer<Long,Contact>(Contact.class);

        Contact[] contactList = restContactTemplate.getContacts();
        Contact contact1 = null;

        for (Contact contact : contactList){
            beanItemContainer.addBean(contact);
            contact1 = contact;
        }
//        beanItemContainer.setBeanIdProperty(contact1.getId());
        beanItemContainer.setBeanIdResolver(Contact::getId);
        Table table =new Table();
       // table.setColumnHeader(contact1.getId(),"id");
        table.setColumnHeader(contact1.getName(),"Name");
        table.setColumnHeader(contact1.getTelephone(),"Telephone");
        table.setColumnHeader(contact1.getEmail(),"Email");
        table.setColumnHeader(contact1.getAddress(),"Address");
        table.setVisibleColumns(contact1.getName(),contact1.getTelephone(),contact1.getEmail(),contact1.getAddress());
        table.setContainerDataSource(beanItemContainer);
        basePage.addComponent(table);

        setContent(basePage);


    }
}
*/
