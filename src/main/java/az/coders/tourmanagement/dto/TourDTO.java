package az.coders.tourmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String image;

    private LocalDateTime createdAt;
}
