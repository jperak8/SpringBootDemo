package hr.java.spring.boot.example.hardware.dto;

import hr.java.spring.boot.example.hardware.model.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDTO {

    private String name;
    private Double price;
    private HardwareType type;
    private Integer quantity;


}
