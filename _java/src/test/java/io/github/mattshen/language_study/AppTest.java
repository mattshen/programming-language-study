package io.github.mattshen.language_study;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
