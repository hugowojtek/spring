package pl.sdacademy.spring.car_dealer.repository;

import java.time.LocalDate;
import java.util.Map;

public interface AccountancyFinder {
    Map<LocalDate, Long> purchasesValueByDate();
}
