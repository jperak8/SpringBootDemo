package hr.java.spring.boot.example.hardware.repository;

import hr.java.spring.boot.example.hardware.dto.HardwareDTO;
import hr.java.spring.boot.example.hardware.model.HardwareType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class HardwareJdbcRepository implements HardwareRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HardwareJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HardwareDTO> getAllHardware() {
        String sql = "SELECT * FROM hardware";
        return jdbcTemplate.query(sql, new HardwareRowMapper());
    }

    @Override
    public List<HardwareDTO> getHardwareByCode(String code) {
        String sql = "SELECT * FROM hardware WHERE code = ?";
        return jdbcTemplate.query(sql, new HardwareRowMapper(), code);
    }

    @Override
    public HardwareDTO addHardware(HardwareDTO dto) {
        String code = "HW" + System.currentTimeMillis();
        jdbcTemplate.update(
                "INSERT INTO hardware (name, code, price, type, quantity) VALUES (?, ?, ?, ?, ?)",
                dto.getName(), code, dto.getPrice(), dto.getType().toString(), dto.getQuantity()
        );

        return new HardwareDTO(dto.getName(), code, dto.getPrice(), dto.getType(), dto.getQuantity());
    }

    @Override
    public boolean updateHardware(String code, HardwareDTO dto) {
        int updated = jdbcTemplate.update(
                "UPDATE hardware SET name = ?, price = ?, type = ?, quantity = ? WHERE code = ?",
                dto.getName(), dto.getPrice(), dto.getType().toString(), dto.getQuantity(), code
        );
        return updated > 0;
    }

    @Override
    public boolean deleteHardware(String code) {
        int deleted = jdbcTemplate.update("DELETE FROM hardware WHERE code = ?", code);
        return deleted > 0;
    }

    private static class HardwareRowMapper implements RowMapper<HardwareDTO> {
        @Override
        public HardwareDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HardwareDTO(
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getDouble("price"),
                    HardwareType.valueOf(rs.getString("type")),
                    rs.getInt("quantity")
            );
        }
    }
}