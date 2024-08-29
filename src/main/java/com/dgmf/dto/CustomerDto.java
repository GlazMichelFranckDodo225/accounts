package com.dgmf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerDto {
    @NotEmpty(message = "Name Can Not Be Null or Empty")
    @Size(min = 5, max = 30, message = "Length of Customer Name Should Be Between 5 and 30")
    private String name;
    @NotEmpty(message = "Email Address Can Not Be Null or Empty")
    @Email(message = "Email Address Should Be a Valid Value")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number Must Be 10 Digits")
    private String mobileNumber;
    private AccountsDto accountsDto;
}
