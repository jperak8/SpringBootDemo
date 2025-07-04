package hr.java.spring.boot.example.hardware.controller;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.service.HardwareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardware")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.getAllHardware();
    }

    @GetMapping("/{code}")
    public List<HardwareDTO> getHardwareByCode(@PathVariable String code) {
        return hardwareService.getHardwareByCode(code);
    }
}
