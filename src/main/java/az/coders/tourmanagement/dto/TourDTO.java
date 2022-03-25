package az.coders.tourmanagement.dto;

import az.coders.tourmanagement.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO {

    private Long id;

    private String title;

    private String overview;

    private String destination;

    private int duration;

    private byte groupSize;

    private BigDecimal price;

    private LocalDate date;

    private ImageEntity image;

    private LocalDateTime createdAt;
}
