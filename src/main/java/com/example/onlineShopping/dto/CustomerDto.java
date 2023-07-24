package com.example.onlineShopping.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @NotBlank
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
}
