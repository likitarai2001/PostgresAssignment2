package com.example.onlineShopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @Pattern(regexp = "/d{4}-/d{4}-/d{4}-/d{4}")
    private String cardNum;
    @NotNull
    private String bank;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate validity;
    @Enumerated(EnumType.STRING)
    private CardType type;

    @OneToOne(mappedBy = "card")
    @JsonIgnore
    private Customer customer;
}
