package com.example.onlineShopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "id_seq",
            sequenceName = "id_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_seq"
    )
    @Column(name = "customer_id")
    private int customerId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @Pattern(regexp = "^[FM]$")
    private String gender;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank
    private String address;
    @Digits(message="Number should contain 6 digits.", fraction = 0, integer = 6)
    @Positive
    private String pincode;
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    @Positive
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_num", referencedColumnName = "cardNum")
    @JsonIgnoreProperties("customer")
    private Card card;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference("order-customer-defaultReference")
    private List<OrderDetails> orders;
}
