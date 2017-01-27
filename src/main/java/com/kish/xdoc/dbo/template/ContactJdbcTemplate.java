package com.kish.xdoc.dbo.template;

import com.kish.xdoc.dbo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ThejKishore on 1/3/2017.
 */
@Component
public class ContactJdbcTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String lastIndex="Select max(id) from contact";
    private final String getContactList="Select id,name,email,telephone,address from contact";
    private final String getContactById="Select id,name,email,telephone,address from contact where id=? ";
    private final String getContactByName="Select id,name,email,telephone,address from contact where name like ";
    private final String insertContact = "Insert into contact(id,name,email,telephone,address) values(?,?,?,?,?)";
    private final String updateContact = "update contact set name=?,email=?,telephone=?,address=? where id =?";
    private final String deleteContact = "delete from contact where id =?";

    /**
     *
     * @param contact
     * @return the contactId for future reference
     */
    public Contact insertContact(Contact contact){
        Long contactId = getLastInsertedId();
        int updateCount = jdbcTemplate.update(insertContact,new Object[]{contactId,contact.getName(),contact.getEmail(),contact.getTelephone(),contact.getAddress()});
        if(updateCount == 1){
            contact.setId(contactId);
            return contact;
        }
        return null;
    }




    /**
     *
     * @param contact
     * @return  if record is updated successfully would return the updated record id else null
     */
    public Long updateContact(Long contactId, Contact contact){
        Contact lhs = getContactByID(contactId);
        Contact diffObject = lhs.getDifferenceObject(contact);
        int updateCount = jdbcTemplate.update(updateContact, new Object[]{diffObject.getName(), diffObject.getEmail(), diffObject.getTelephone(), diffObject.getAddress(), contactId});
        if (updateCount == 1) {
            return lhs.getId();
        }
        return null;
    }


    /**
     *
     * @param contactId
     * @return if record is deleted successfully would return the deleted record id else null
     */
    public Long delectContact(Long contactId){
        int updateCount = jdbcTemplate.update(deleteContact, new Object[]{contactId});
        if (updateCount == 1) {
            return contactId;
        }
        return null;
    }

    private Long getLastInsertedId(){
        return jdbcTemplate.queryForObject(lastIndex,Long.class) + 1;
    }

    public Contact getContactByID(Long contactId){
        List<Contact> contactList = jdbcTemplate.query(getContactById, new Object[]{contactId}, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                return getContactFromResultSet(rs);
            }
        });
        return contactList.get(0);
    }

    public List<Contact> getContactByName(String name){
        String searchQuery = getContactByName + "'%"+name+"%'";
        List<Contact> contactList = jdbcTemplate.query(searchQuery, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                return getContactFromResultSet(rs);
            }
        });
        return contactList;
    }

    public List<Contact> getContactList(){
        List<Contact> contactList = jdbcTemplate.query(getContactList, new Object[]{}, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                return getContactFromResultSet(rs);
            }
        });
        return contactList;
    }

    private Contact getContactFromResultSet(ResultSet rs) throws SQLException{
        Contact contact = new Contact();
        contact.setId(rs.getLong("id"));
        contact.setName(rs.getString("name"));
        contact.setTelephone(rs.getString("telephone"));
        contact.setEmail(rs.getString("email"));
        contact.setAddress(rs.getString("address"));
        return contact;
    }

}
