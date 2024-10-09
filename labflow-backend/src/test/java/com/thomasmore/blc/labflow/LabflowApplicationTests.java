package com.thomasmore.blc.labflow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LabflowApplicationTests {

	@Test
	void helloWorld() {
		String x = "Jan met de pet";
		Assertions.assertEquals("Jan met de pet", x);
	}

}
