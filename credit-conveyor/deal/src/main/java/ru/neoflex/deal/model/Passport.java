package ru.neoflex.deal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private String series;
    private String number;
    private LocalDate issueDate;
    private String issueBranch;
}
