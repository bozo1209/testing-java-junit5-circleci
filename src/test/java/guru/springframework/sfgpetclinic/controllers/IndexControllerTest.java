package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "wrong view returned");
        assertEquals("index", controller.index(), () -> "expensive message" +
                "make only if you have to");

        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    @Disabled("demo of timeout")
    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("i got here");
        });
    }

    @Disabled("demo of timeout")
    @Test
    void testTimeOutPrempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("i got here 2");
        });
    }

    @Test
    void testAssumptionTrue(){
        assumeTrue("bozo".equalsIgnoreCase(System.getenv("bozo_runtime")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue(){
        assumeTrue("bozo".equalsIgnoreCase("bozo"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows(){

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11(){

    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testMeOnJava17(){

    }

    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    @Test
    void testMeOnJava11_17(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "bozo")
    @Test
    void testIfUserBozo(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred(){

    }

}