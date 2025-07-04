package hr.java.spring.boot.example.hardware.service;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream().toList();
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String code) {
        return hardwareRepository.getHardwareByCode(code).stream().toList();
    }
}
