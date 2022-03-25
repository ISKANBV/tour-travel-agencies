package az.coders.tourmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",columnDefinition = "varchar(45)")
    private String name;

    @Column(name = "original_filename",columnDefinition = "varchar(45)")
    private String originalFilename;

    @Column(name = "content_type",columnDefinition = "varchar(45)")
    private String contentType;

    @Column(name = "size")
    private Long size;

    @Lob
    @Column(name = "image")
    private byte[] bytes;
}
