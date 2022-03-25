package az.coders.tourmanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tours")
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String title;

    @NotBlank
    @Column(length = 450)
    private String overview;

    @NotBlank
    @Column(length = 50)
    private String destination;

    @NotBlank
    private int duration;

    @NotBlank
    @Column(name = "group_size")
    private byte groupSize;

    @NotBlank
    private BigDecimal price;

    @Column
    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
