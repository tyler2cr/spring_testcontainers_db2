package tyler2cr.spring.testcontainers;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Db2Container;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@DirtiesContext
public abstract class TestContainersTest {

    @Container
    public static Db2Container db2Container =
            new Db2Container(DockerImageName.parse("ibmcom/db2:11.5.7.0"))
                    .withDatabaseName("test")
                    .withStartupTimeoutSeconds(30)
                    .withExposedPorts(50000);

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", db2Container::getJdbcUrl);
        registry.add("spring.datasource.username", db2Container::getUsername);
        registry.add("spring.datasource.password", db2Container::getPassword);
    }
}