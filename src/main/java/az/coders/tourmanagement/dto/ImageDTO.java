package az.coders.tourmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {

    private Long id;

    private String name;

    private String originalFilename;

    private String contentType;

    private Long size;

    private byte[] bytes;

}
