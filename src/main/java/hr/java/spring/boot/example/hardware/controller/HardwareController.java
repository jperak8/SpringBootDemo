package hr.java.spring.boot.example.hardware.controller;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/hardware")
@AllArgsConstructor
public class HardwareController {

    private final HardwareService hardwareService;

    @GetMapping
    public ResponseEntity<List<HardwareDTO>> getAllHardware() {
        List<HardwareDTO> hardware = hardwareService.getAllHardware();
        return ResponseEntity.ok(hardware);
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<HardwareDTO>> getHardwareByCode(@PathVariable String code) {
        List<HardwareDTO> result = hardwareService.getHardwareByCode(code);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> addHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        HardwareDTO created = hardwareService.addHardware(hardwareDTO);
        URI location = URI.create("/api/hardware/" + created.getCode());

        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Void> updateHardware(@PathVariable String code, @Valid @RequestBody HardwareDTO hardwareDTO) {
        boolean updated = hardwareService.updateHardware(code, hardwareDTO);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteHardware(@PathVariable String code) {
        boolean deleted = hardwareService.deleteHardware(code);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
