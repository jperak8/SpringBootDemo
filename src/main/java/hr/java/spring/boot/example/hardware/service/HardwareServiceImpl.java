package hr.java.spring.boot.example.hardware.service;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware();
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String code) {
        return hardwareRepository.getHardwareByCode(code);
    }

    @Override
    public void addHardware(HardwareDTO hardwareDTO) {
        hardwareRepository.addHardware(hardwareDTO);
    }

    @Override
    public void updateHardware(String code, HardwareDTO hardwareDTO) {
        hardwareRepository.updateHardware(code, hardwareDTO);
    }

    @Override
    public void deleteHardware(String code) {
        hardwareRepository.deleteHardware(code);
    }
}

