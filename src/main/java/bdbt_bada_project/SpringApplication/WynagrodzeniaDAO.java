package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WynagrodzeniaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wynagrodzenia> list(){
        String sql = "SELECT * FROM wynagrodzenia WHERE nr_pracownika = 1";

        List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return listWynagrodzenia;
    }

}
