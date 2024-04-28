package com.buyogo.assessment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TraningCenter {

    //this is the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //the max size for this property is 39
    @Size(min = 1,max = 39,message = "the size of center name should be less than 40 characters")
    @NotNull
    private String centerName;

    //this centercode should be exactly 12 characters
    @Size(min = 12,max = 12,message = "the size of center code should be exactly 12")
    private String centerCode;

    @Embedded
    private Address address;

    @NotNull
    private Integer studentCapacity;

    private List<String> coursesOffered;

    //this created on will be set by system means the current date time
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    // the email is uses validation annotations to check wheather the email is in email format or not
    @Email(message = "Not a valid mail")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "not a valid mail")
    private String contactEmail;

    // contact phone is also validated that the size of the phone number is 10
    @Pattern(regexp = "^\\d{10}$",message = "phn number should be valid of size 10 ")
    private String contactPhone;


}
