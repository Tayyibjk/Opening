package fhwien.Opening;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpeningHoursService {

    private Map<String, String> openingHours;

    public OpeningHoursService() {
        // Initialize opening hours with default values
        openingHours = new HashMap<>();
        openingHours.put("Mo", "9:00 - 17:00");
        openingHours.put("Tu", "9:00 - 17:00");
        openingHours.put("We", "9:00 - 17:00");
        openingHours.put("Th", "9:00 - 17:00");
        openingHours.put("Fr", "9:00 - 17:00");
        openingHours.put("Sa", "10:00 - 14:00");
        openingHours.put("Su", "closed");
    }

    public Map<String, String> getOpeningHours() {
        return openingHours;
    }

    public void resetOpeningHours() {
        // Reset opening hours to default values
        openingHours.put("Mo", "9:00 - 17:00");
        openingHours.put("Tu", "9:00 - 17:00");
        openingHours.put("We", "9:00 - 17:00");
        openingHours.put("Th", "9:00 - 17:00");
        openingHours.put("Fr", "9:00 - 17:00");
        openingHours.put("Sa", "10:00 - 14:00");
        openingHours.put("Su", "closed");
    }

    public void setOpeningHours(String day, String open, String close) {
        // Set new opening hours for a day
        String hours = open + " - " + close;
        openingHours.put(day, hours);
    }

    public void closeDay(String day) {
        // Close a day
        openingHours.put(day, "closed");
    }
}

