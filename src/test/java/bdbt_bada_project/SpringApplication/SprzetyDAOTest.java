package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SprzetyDAOTest {

    private SprzetyDAO dao;

    @BeforeEach
    void setUp() throws Exception{

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("NSLEPOWR");
        dataSource.setPassword("NSLEPOWR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new SprzetyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList(){
        List<Sprzety> listSprzety = dao.list();
        assertTrue(listSprzety.isEmpty());
    }

}
