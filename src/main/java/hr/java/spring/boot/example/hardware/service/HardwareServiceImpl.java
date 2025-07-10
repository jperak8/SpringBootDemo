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
    public HardwareDTO addHardware(HardwareDTO hardwareDTO) {
        return hardwareRepository.addHardware(hardwareDTO);
    }

    @Override
    public boolean updateHardware(String code, HardwareDTO hardwareDTO) {
        return hardwareRepository.updateHardware(code, hardwareDTO);
    }

    @Override
    public boolean deleteHardware(String code) {
        return hardwareRepository.deleteHardware(code);
    }
}


