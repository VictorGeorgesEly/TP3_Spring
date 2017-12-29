package isep.web.sakila.webapi.model;

import junit.framework.TestCase;

public class ActorWOTest extends TestCase {

	public static final String EXPECTED_FIRST_NAME = "Dupont";
    public static final String EXPECTED_LAST_NAME = "Fred";
    public static final int EXPECTED_ID = 00001;
    private ActorWO Actor;

	protected void setUp() throws Exception {
		super.setUp();
		Actor = new ActorWO(00001, "Fred", "Dupont");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Test ActorWO Completed");
	}

	public void testUserDetails() throws Exception {
        assertEquals(EXPECTED_FIRST_NAME, Actor.getFirstName());
        assertEquals(EXPECTED_LAST_NAME, Actor.getLastName());
        assertEquals(EXPECTED_ID, Actor.getActorId());

    }
}
