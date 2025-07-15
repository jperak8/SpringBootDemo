package hr.java.spring.boot.example.hardware.repository;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.model.Hardware;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import static hr.java.spring.boot.example.hardware.model.HardwareType.*;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static List<Hardware> hardwareList;

    static {

        hardwareList = new ArrayList<>();

        Hardware cpuHardware = new Hardware("Intel Core i7", "CPU123", 299.99, CPU, 10);
        Hardware gpuHardware = new Hardware("NVIDIA RTX 4090", "GPU999", 1999.99, GPU, 5);
        Hardware mboHardware = new Hardware("ASUS ROG Strix Z790", "MBO456", 399.99, MBO, 7);
        Hardware ramHardware = new Hardware("Corsair Vengeance 32GB DDR5", "RAM321", 169.99, RAM, 20);

        hardwareList.add(cpuHardware);
        hardwareList.add(gpuHardware);
        hardwareList.add(mboHardware);
        hardwareList.add(ramHardware);

    }

    @Override
    public List<HardwareDTO> getAllHardware() {
        List<HardwareDTO> dtoList = new ArrayList<>();
        for (Hardware hardware : hardwareList) {
            dtoList.add(mapToDTO(hardware));
        }
        return dtoList;
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String code) {
        List<HardwareDTO> dtoList = new ArrayList<>();
        for (Hardware hardware : hardwareList) {
            if (hardware.getCode().equalsIgnoreCase(code)) {
                dtoList.add(mapToDTO(hardware));
            }
        }
        return dtoList;
    }

    private HardwareDTO mapToDTO(Hardware hardware) {
        return new HardwareDTO(
                hardware.getName(),
                hardware.getCode(),
                hardware.getPrice(),
                hardware.getType(),
                hardware.getQuantity()
        );
    }

    @Override
    public HardwareDTO addHardware(HardwareDTO dto) {
        String code = "HW" + (hardwareList.size() + 1);
        Hardware hw = new Hardware(dto.getName(), code, dto.getPrice(), dto.getType(), dto.getQuantity());
        hardwareList.add(hw);
        return mapToDTO(hw);
    }

    @Override
    public boolean updateHardware(String code, HardwareDTO dto) {
        for (Hardware hw : hardwareList) {
            if (hw.getCode().equalsIgnoreCase(code)) {
                hw.setName(dto.getName());
                hw.setPrice(dto.getPrice());
                hw.setType(dto.getType());
                hw.setQuantity(dto.getQuantity());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteHardware(String code) {
        return hardwareList.removeIf(hw -> hw.getCode().equalsIgnoreCase(code));
    }


    private String generateUniqueCode() {
        return "HW" + (hardwareList.size() + 1);
    }
}
