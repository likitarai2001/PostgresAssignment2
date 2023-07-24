package com.example.onlineShopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private String orderId;
    private int orderTotal;
    private LocalDate orderDate;
    private LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "customer_id")
    @JsonBackReference("order-customer-defaultReference")
    private Customer customer;
}
