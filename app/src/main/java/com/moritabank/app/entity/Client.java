package com.moritabank.app.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", nullable = false, length = 150)
    private Long clientId;

    @Column(name = "typeDocument", nullable = false, length = 150)
    private String typeId;

    @Column(name = "numDocument" , nullable = false,length = 150)
    private  Long numberId;
    @Column (name = "firstName", nullable = false, length = 150)
    private String firstName;

    @Column (name = "secondName", nullable = false, length = 150)
    private String secondName;

    @Column (name = "firstLastName", nullable = false, length = 150)
    private  String firstLastName;

    @Column (name = "secondLastName", nullable = false, length = 150)
    private String secondLastName;

    @Column (name = "typeClient", nullable = false,length = 150)
    private String typeClient;
    @Column (name = "address" , nullable = false, length = 150 )
    private String address;

    @Column (name = "phone", nullable = false, length = 150)
    private String phone;

    @Column (name = "mail",nullable = false, length = 150)
    private String mail;

    @Column (name = "bornDate", nullable = false, length = 50)
    private LocalDate bornDate ;

    @Column (name = "creationUser", nullable = false, length = 150)
    private String creationUser;
    @Column (name = "creationDate", nullable = false, length = 50)
    private LocalDate creationDate;
    @Column (name = "statusClient", nullable = false, length = 150)
    private String statusClient;

    @Column (name = "modificationDate", nullable = false, length =  150)
    private LocalDate modificationDate;

    @Column (name = "modificationUser", nullable = true, length = 150)
    private String modificationUser;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> Accounts= new ArrayList<>();


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Long getNumberId() {
        return numberId;
    }

    public void setNumberId(Long numberId) {
        this.numberId = numberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public String getStatusClient() {
        return statusClient;
    }

    public void setStatusClient(String statusClient) {
        this.statusClient = statusClient;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public List<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(List<Account> accounts) {
        Accounts = accounts;
    }
}

