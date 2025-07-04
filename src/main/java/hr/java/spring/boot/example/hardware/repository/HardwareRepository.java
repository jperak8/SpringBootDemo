package hr.java.spring.boot.example.hardware.repository;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;

import java.util.List;

public interface HardwareRepository {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String code);
}
