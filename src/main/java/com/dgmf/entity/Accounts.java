package com.dgmf.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Accounts extends  BaseEntity {
    @Id // Will Be generated Manually
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
}