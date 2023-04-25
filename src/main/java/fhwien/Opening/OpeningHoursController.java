package fhwien.Opening;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OpeningHoursController {

    private Map<String, String> openingHours = new HashMap<>();

    @GetMapping("/api/hours")
    public Map<String, String> getOpeningHours() {
        return openingHours;
    }

    @PostMapping("/api/hours/reset")
    public void resetOpeningHours() {
        openingHours.clear();
        // add default opening hours here
    }

    @PostMapping("/api/hours/set")
    public void setOpeningHoursForDay(@RequestParam String day, @RequestParam String open, @RequestParam String close) {
        String hours = open + " - " + close;
        openingHours.put(day, hours);
    }

    @PostMapping("/api/hours/close")
    public void closeDay(@RequestParam String day) {
        openingHours.put(day, "closed");
    }
}

