package com.CRUDTelephony.CRUDTelephony;

import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.PostgreSQLPersonPhoneRepository;
import com.CRUDTelephony.CRUDTelephony.Services.PostgreSQLPersonPhoneService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import java.util.Date;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

@SpringBootTest
class CrudTelephonyApplicationTests {

	@Mock
	private PostgreSQLPersonPhoneRepository personRepository;

	@InjectMocks
	private PostgreSQLPersonPhoneService personService;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
	}

	@Test
	public void testReadPersonById() {
		// Arrange
		int personId = 1;
		PostgreSQLPersonPhone expectedPerson = new PostgreSQLPersonPhone();
		expectedPerson.setId(personId);
		expectedPerson.setName("Dimash");
		expectedPerson.setBirthYear(2001);
		expectedPerson.setPhoneFirst("+77473334215");
		expectedPerson.setPhoneSecond("+77473334215");
		expectedPerson.setCreationDate(new Date());


		when(personRepository.findById(personId)).thenReturn(Optional.of(expectedPerson));

		// Act
		PostgreSQLPersonPhone actualPerson = personService.getByIdOrPhoneNumber(String.valueOf(personId));

		// Assert
		assertNotNull(actualPerson);
		assertEquals(actualPerson.getId(), 1);
		assertEquals(actualPerson.getName(), "Dimash");
	}
	@Test
	void contextLoads() {
	}

}
