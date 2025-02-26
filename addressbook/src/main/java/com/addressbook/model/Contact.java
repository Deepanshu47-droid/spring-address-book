package com.addressbook.model;

import com.addressbook.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Contact(ContactDTO contactDTO) {
        this.name = contactDTO.getName();
        this.email = contactDTO.getEmail();
        this.phone = contactDTO.getPhone();
    }
}
