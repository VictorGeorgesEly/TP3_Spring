package isep.web.sakila.webapi.model;

import junit.framework.TestCase;

public class AddressWOTest extends TestCase {

	public static final int EXPECTED_ADDRESS_ID = 0001;
	public static final String EXPECTED_ADDRESS = "rue du bois";
	public static final String EXPECTED_ADRESS2 = "complement";
	public static final String EXPECTED_DISTRICT = "hood";
	public static final String EXPECTED_POSTALCODE = "75001";
	public static final String EXPECTED_PHONE = "0148112233";

	private AddressWO Address;
	protected void setUp() throws Exception {
		Address = new AddressWO(0001, "rue du bois", "complement", "hood", "75001", "0148112233");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test AddressWO Completed");
	}

    public void testUserDetails() throws Exception {
        assertEquals(EXPECTED_ADDRESS_ID, Address.getAddressId());
        assertEquals(EXPECTED_ADDRESS, Address.getAddress());
        assertEquals(EXPECTED_ADRESS2, Address.getAddress2());
        assertEquals(EXPECTED_DISTRICT, Address.getDistrict());
        assertEquals(EXPECTED_POSTALCODE, Address.getPostalCode());
        assertEquals(EXPECTED_PHONE, Address.getPhone());

    }
}
