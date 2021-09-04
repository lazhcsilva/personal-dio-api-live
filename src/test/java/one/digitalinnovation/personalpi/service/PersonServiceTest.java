package one.digitalinnovation.personalpi.service;

import one.digitalinnovation.personalpi.dto.request.PersonDTO;
import one.digitalinnovation.personalpi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personalpi.entity.Person;
import one.digitalinnovation.personalpi.repository.PersonRepository;
import one.digitalinnovation.personalpi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personalpi.utils.PersonUtils.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson);

        MessageResponseDTO successMessage = personService.createPerson(personDTO);
    }

    private MessageResponseDTO createExpectedMessageResponse(Person expectedSavedPerson) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + expectedSavedPerson.getId())
                .build();
    }
}
