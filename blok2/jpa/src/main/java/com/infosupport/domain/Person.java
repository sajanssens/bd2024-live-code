package com.infosupport.domain;

import com.infosupport.util.BooleanTFConverter;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.FetchType.LAZY;

@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
@Data
// @NamedQueries({
@NamedQuery(name = "findAll", query = "select p from Person p") //,
@NamedQuery(name = "findBy", query = "select p from Person p where name = :n")
// })
public class Person {

    @Id @GeneratedValue
    private int id;

    private String name;

    @Builder.Default
    private int age = 42;

    // @Pattern(regexp = "....") // nóg een dep nodig: expressly
    @Email // Bean validation API: twee deps: jakarta.validation-api en hibernate-validator
    private String emailAddress;

    // Advanced features for single fields ----------------

    // @Temporal(value = TIMESTAMP)
    // private Date birthday;

    // Better:
    private LocalDate birthdate;

    @Enumerated(EnumType.ORDINAL)
    private ContactType type;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "workStreet")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "workHouseNumber")),
            @AttributeOverride(name = "zip", column = @Column(name = "workZip")),
            @AttributeOverride(name = "city", column = @Column(name = "workCity"))
    })
    private Address addressWork;

    @Lob // CLOB Character large object
    @Basic(fetch = LAZY) // only loaded when explicitly called (with getResume()) on a managed object.
    private String resume;

    @Lob // BLOB Binary large object
    @Basic(fetch = LAZY)
    private byte[] image;

    @Convert(converter = BooleanTFConverter.class)
    private Boolean hasDriversLicence;

    //  Relationships -------------------------------------------

    @ManyToOne(cascade = MERGE)
    private Department worksAt;

    @ManyToOne
    private Clearance clearance;

    @ManyToMany
    @Builder.Default @ToString.Exclude
    private List<Course> courses = new ArrayList<>();

    public void setClearance(Clearance clearance) {
        this.clearance.getPersons().remove(this);
        this.clearance = clearance;
        if (clearance != null) {
            this.clearance.getPersons().add(this);
        }
    }
}
