package org.hibernateapp.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "student_detail")
public class StudentDetail  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    public StudentDetail() {
    }

    public StudentDetail(String address, String contact) {
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
