package pl.WeronikaK98.firstApp.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCommandTest {

    @Test
    void shouldBuildCorrectUserInputCommand() {
    // given
        String input = "parent add ParentName";

        // when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        // then
        assertEquals("parent", userInputCommand.getCommand());
        assertEquals("add", userInputCommand.getAction());
        assertLinesMatch(List.of("ParentName"), userInputCommand.getParam());
    }

    @Test
    void shouldBuildCorrectUserInputCommandWithMultipleParams() {
        // given
        String input = "command action param1 param2 param3";

        // when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        // then
        assertEquals("command", userInputCommand.getCommand());
        assertEquals("action", userInputCommand.getAction());
        assertLinesMatch(List.of("param1", "param2", "param3"), userInputCommand.getParam());
    }

    @Test
    void shouldBuildCorrectUserInputCommandWithoutParams() {
        // given
        String input = "command action";

        // when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        // then
        assertEquals("command", userInputCommand.getCommand());
        assertEquals("action", userInputCommand.getAction());
        assertEquals(0, userInputCommand.getParam().size());
    }
}