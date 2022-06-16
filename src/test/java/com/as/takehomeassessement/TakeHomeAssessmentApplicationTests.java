package com.as.takehomeassessement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TakeHomeAssessmentApplicationTests {

	@Test
	@DisplayName("Context Load")
	void contextLoads(ApplicationContext context) {
		Assertions.assertNotNull(context);
	}

}
