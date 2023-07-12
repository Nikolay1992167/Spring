package by.it.academy.truck;

import by.it.academy.truck.extensions.LoggingExtensions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.platform.commons.util.StringUtils.isNotBlank;

@ExtendWith(LoggingExtensions.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DisplayName("Test class")
public class CommonTest {

    private Logger logger;

    @Test
    @DisplayName("Провверка инструментария JUnit 5")
    void availableUserTest() {
        //Assertions.assertEquals("Dima","Dima");
        Assertions.assertEquals("Dima", "Nikolay");
        Assertions.assertNotNull(5);
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.parseInt("one"));
    }

    //@Test
    @ParameterizedTest
    @ValueSource(strings = {"Hello world, Alex", "I am programmer", "I like coffee"})
    @DisplayName("Проверка вхождения символа в строку")
    void checkOccurrenceCharacterInString(String sentence) {
        IntStream chars = sentence.chars();
        Assertions.assertEquals(4, chars.filter(value -> value == 'l').count(), "Должно быть больше или равно 4");
    }

    @Test
    @Tag("production")
    @DisplayName("Проверка порядка символов в строке")
    void checkSymbolOrder() {
        System.setProperty("profile", "PROD");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("profile")));
        char[] chars = "Hello world, Alex".toCharArray();
        Assertions.assertAll("Hello world, Alex",
                () -> Assertions.assertEquals(chars[0], 'H'),
                () -> Assertions.assertEquals(chars[1], 'e'),
                () -> Assertions.assertEquals(chars[chars.length - 1], 'x')
        );
    }

    @Test
    @DisplayName("Should throws NFE when string converting to number")
    void expectExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Integer.parseInt("one"));
    }

    @ParameterizedTest
    @CsvSource(value = {"Hello:HELLO", "java:JAVA", "clevertec:CLEVER"}, delimiter = ':')
    void checkUpperCase(String expected, String actual) {
        Assertions.assertEquals(expected.toUpperCase(Locale.ROOT), actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1, delimiter = ':')
    void checkUpperCaseTwo(String expected, String actual) {
        Assertions.assertEquals(expected.toUpperCase(Locale.ROOT), actual);
    }

    @ParameterizedTest
    @MethodSource("getInputParameters")
    void checkIsNotBlank(String input) {
        Assumptions.assumeTrue(isNotBlank(input));
    }

    private static Stream<String> getInputParameters() {
        return Stream.of(
                "hello:HELLO",
                "java:JAVA",
                "clevertec:CLEVERTEC",
                null
        );
    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }


    @AfterEach
    void tearDown() {

    }

    @BeforeEach
    void setUp() {

    }

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }
}
