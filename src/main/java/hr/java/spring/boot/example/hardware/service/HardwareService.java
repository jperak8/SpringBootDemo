package hr.java.spring.boot.example.hardware.service;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByCode(String code);
    HardwareDTO addHardware(HardwareDTO hardwareDTO);
    boolean updateHardware(String code, HardwareDTO hardwareDTO);
    boolean deleteHardware(String code);
}