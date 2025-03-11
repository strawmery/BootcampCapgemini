package com.example.demo.exampleTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.demo.example.Calculator;

class CalculatorTest {
	Calculator calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("Método: suma")
	class Suma {
		@Nested
		@DisplayName("Casos validos")
		class OK {
			@Test
			@DisplayName("Suma dos enteros")
			void testSuma() {
//		var calc = new Calculadora();

				var actual = calc.suma(2, 3);

				assertEquals(5, actual);
			}

			@Test
			@DisplayName("Suma dos reales")
			void testSuma2() {
				var calc = new Calculator();

				var actual = calc.suma(0.1, 0.2);

				assertEquals(0.3, actual);
			}

			@Test
			@DisplayName("Suma dos reales: resta")
			void testSuma3() {
				var calc = new Calculator();

				assertEquals(0.1, calc.suma(1, -0.9));
			}
		}

		@Nested
		@DisplayName("Casos invalidos")
		class KO {
			@Test
			@DisplayName("Suma dos enteros grandes")
			void testSumaInt() {
				var calc = new Calculator();

				var actual = calc.suma(Integer.MAX_VALUE, 1);
				assertEquals(5, actual);

				assertTrue(1.0 / 0 > 0);
				assertEquals(5, 1.0 / 0);
//		assertTrue(actual > 0);
			}
		}

	}

	@Nested
	@DisplayName("Método: divide")
	class Divide {
		@Nested
		@DisplayName("Casos validos")
		class OK {
			@Test
			@DisplayName("Divide dos enteros")
			void testDivide() {
				var calc = new Calculator();

				assertEquals(0.5, calc.divide(1.0, 2));
			}

			@Test
			@DisplayName("Divide por cero")
			void testDivide2() {
				var calc = new Calculator();
				var ex = assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
				assertEquals("/ by zero", ex.getMessage());
			}

			@Test
			@DisplayName("Divide por cero: try")
			void testDivide3() {
				var calc = new Calculator();
				try {
					calc.divide(1, 0);
					fail("No se ha lanzado excepcion");
				} catch (ArithmeticException ex) {
					assertEquals("/ by zero", ex.getMessage());
				}
			}
		}
	}
}