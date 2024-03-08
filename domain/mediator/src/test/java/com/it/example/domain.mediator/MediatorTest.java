package com.it.example.domain.mediator;

import com.it.example.domain.mediator.exception.NoHandlerForActionException;
import com.it.example.domain.mediator.stubs.TestMediatorFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MediatorTest {

    public static final String QUERY_HANDLED_RESULT = "Query handled";
    Mediator underTest = TestMediatorFactory.createMediator(List.of(new CommandHandler(), new QueryHandler()));

    @Test
    public void givenCommandShouldNotThrowAndReturnNull() {

        assertThatNoException().isThrownBy(() -> {
            Object result = underTest.execute(new Command());
            assertThat(result).isNull();
        });
    }

    @Test
    public void givenQueryShouldNotThrowAndReturnString() {

        assertThatNoException().isThrownBy(() -> {
            Object result = underTest.execute(new Query());
            assertThat(result).isEqualTo(QUERY_HANDLED_RESULT);
        });
    }

    @Test
    public void givenUnManagedActionShouldThrowNoHandlerForActionException() {

        assertThatThrownBy(() -> underTest.execute(new UnManagedAction()))
                .isExactlyInstanceOf(NoHandlerForActionException.class)
                .hasMessage("No handler for action UnManagedAction");
    }
}

class Command implements Action {
}

class Query implements Action {
}

class UnManagedAction implements Action {
}

class CommandHandler implements Handler<Command, Void> {
    @Override
    public Void handle(Command action) {
        return null;
    }

    @Override
    public <P extends Action> boolean canHandle(P action) {
        return action instanceof Command;
    }
}

class QueryHandler implements Handler<Query, String> {
    @Override
    public String handle(Query action) {
        return "Query handled";
    }

    @Override
    public <P extends Action> boolean canHandle(P action) {
        return action instanceof Query;
    }
}