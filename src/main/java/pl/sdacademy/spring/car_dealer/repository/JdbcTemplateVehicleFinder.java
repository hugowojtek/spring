package pl.sdacademy.spring.car_dealer.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sdacademy.spring.car_dealer.model.Vehicle;

import java.util.List;

@Repository
public class JdbcTemplateVehicleFinder implements VehicleFinder {

    private static final String SELECT_ALL = "SELECT id, manufacturer, model, productionYear, mileage, fuel, price, sold, version FROM Vehicle";

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateVehicleFinder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = jdbcTemplate.query(
                SELECT_ALL,
                new BeanPropertyRowMapper<>(Vehicle.class));
        return vehicles;
    }

    @Override
    public List<Vehicle> getAvailable() {
        return null;
    }
}
