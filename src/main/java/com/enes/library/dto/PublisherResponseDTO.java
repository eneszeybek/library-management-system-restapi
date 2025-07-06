package com.enes.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponseDTO {
    private Long id;
    private String name;
    private int establishmentYear;
}
