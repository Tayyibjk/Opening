package fhwien.Opening;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")

public class OpeningHoursController {

    private final OpeningHoursService openingHoursService;

    public OpeningHoursController(OpeningHoursService openingHoursService) {
        this.openingHoursService = openingHoursService;
    }

    @GetMapping("/hours")
    public Map<String, String> getOpeningHours() {
        return openingHoursService.getOpeningHours();
    }

    @PostMapping("/hours/reset")
    public void resetOpeningHours() {
        openingHoursService.resetOpeningHours();
    }

    @PostMapping("/hours/set")
    public void setOpeningHours(@RequestParam("day") String day,
                                @RequestParam("open") String open,
                                @RequestParam("close") String close) {
        openingHoursService.setOpeningHours(day, open, close);
    }

    @PostMapping("/hours/close")
    public void closeDay(@RequestParam("day") String day) {
        openingHoursService.closeDay(day);
    }
}
