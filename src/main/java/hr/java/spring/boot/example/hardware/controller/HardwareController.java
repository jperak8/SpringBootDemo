package hr.java.spring.boot.example.hardware.controller;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/hardware")
@AllArgsConstructor
public class HardwareController {

    private final HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware();
    }

    @GetMapping("/{code}")
    public List<HardwareDTO> getHardwareByCode(@PathVariable String code) {
        return hardwareService.getHardwareByCode(code);
    }

    @PostMapping
    public void addHardware(@RequestBody HardwareDTO hardwareDTO) {
        hardwareService.addHardware(hardwareDTO);
    }

    @PutMapping("/{code}")
    public void updateHardware(@PathVariable String code, @RequestBody HardwareDTO hardwareDTO) {
        hardwareService.updateHardware(code, hardwareDTO);
    }

    @DeleteMapping("/{code}")
    public void deleteHardware(@PathVariable String code) {
        hardwareService.deleteHardware(code);
    }
}
