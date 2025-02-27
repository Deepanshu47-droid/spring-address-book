package com.addressbook.model;

import com.addressbook.dto.ContactDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;

    public Contact(ContactDTO contactDTO) {
        this.name = contactDTO.getName();
        this.email = contactDTO.getEmail();
        this.phone = contactDTO.getPhone();
    }
}
