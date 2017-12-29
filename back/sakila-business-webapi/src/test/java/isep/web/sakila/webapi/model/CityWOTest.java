package isep.web.sakila.webapi.model;

import junit.framework.TestCase;

public class CityWOTest extends TestCase {

	private int EXPECTED_ID = 0001;
	private String EXPECTED_CITY = "Paris";
	private CityWO City;

	protected void setUp() throws Exception {
		super.setUp();
		City = new CityWO(0001, "Paris");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test CityWO Completed");
	}

    public void testUserDetails() throws Exception {
        assertEquals(EXPECTED_ID, City.getCityId());
        assertEquals(EXPECTED_CITY, City.getCity());

    }
}
