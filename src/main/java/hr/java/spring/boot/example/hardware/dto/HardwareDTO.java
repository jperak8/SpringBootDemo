package hr.java.spring.boot.example.hardware.dto;

import hr.java.spring.boot.example.hardware.model.HardwareType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    @NotNull(message = "Hardware type is required")
    private HardwareType type;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be zero or more")
    private Integer quantity;
}
