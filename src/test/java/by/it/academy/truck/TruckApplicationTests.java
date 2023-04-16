package by.it.academy.truck;

import org.springframework.boot.test.context.SpringBootTest;

import by.it.academy.truck.dto.UserResponse;
import by.it.academy.truck.services.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserService.class})
@RequiredArgsConstructor
class TruckApplicationTests {

	private final UserService userServiceImpl;

	@Test
	public void getUserById() {
		UUID idTest = UUID.randomUUID();
		UserResponse found = userServiceImpl.getUser(idTest);
	}
}
