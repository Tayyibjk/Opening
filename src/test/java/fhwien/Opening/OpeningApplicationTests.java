package fhwien.Opening;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

@SpringBootTest
class OpeningApplicationTests {

	private OpeningHoursService openingHoursService;

	@BeforeEach
	void setUp() {
		openingHoursService = new OpeningHoursService();
	}

	@Test
	void testGetOpeningHours() {
		Map<String, String> openingHours = openingHoursService.getOpeningHours();

		assertNotNull(openingHours);
		assertEquals(7, openingHours.size());
		assertEquals("9:00 - 17:00", openingHours.get("Mo"));
		assertEquals("closed", openingHours.get("Su"));
	}

	@Test
	void testResetOpeningHours() {
		openingHoursService.resetOpeningHours();
		Map<String, String> openingHours = openingHoursService.getOpeningHours();

		assertNotNull(openingHours);
		assertEquals(7, openingHours.size());
		assertEquals("9:00 - 17:00", openingHours.get("Mo"));
		assertEquals("closed", openingHours.get("Su"));
	}

	@Test
	void testSetOpeningHours() {
		openingHoursService.setOpeningHours("Mo", "10:00", "18:00");
		Map<String, String> openingHours = openingHoursService.getOpeningHours();

		assertNotNull(openingHours);
		assertEquals(7, openingHours.size());
		assertEquals("10:00 - 18:00", openingHours.get("Mo"));
		assertEquals("closed", openingHours.get("Su"));
	}

	@Test
	void testCloseDay() {
		openingHoursService.closeDay("Mo");
		Map<String, String> openingHours = openingHoursService.getOpeningHours();

		assertNotNull(openingHours);
		assertEquals(7, openingHours.size());
		assertEquals("closed", openingHours.get("Mo"));
		assertEquals("closed", openingHours.get("Su"));
	}
}
