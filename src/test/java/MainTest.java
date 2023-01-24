import data.DataTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

// JUnit5 nie ma @Category, tylko @Tag
@Tag("app")
class MainTest {
    DataTest dataTest;

    @BeforeEach
    void setUp() {
        dataTest = new DataTest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void clientView() {
    }

    @Test
    void workerView() {
    }
}