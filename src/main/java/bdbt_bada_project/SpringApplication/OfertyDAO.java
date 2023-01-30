package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OfertyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public OfertyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oferty> list(){
        String sql = "SELECT * FROM OFERTY";

        List<Oferty> listOferty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferty.class));
        return listOferty;
    }
    public void save(Oferty oferty) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("OFERTY").usingColumns("NR_OFERTY", "NAZWA_PRODUKTU", "OFEROWANA_CENA", "OPIS", "NR_ROZGLOSNI");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oferty);
        insertActor.execute(param);
    }

    public Oferty get(int nr_oferty){
        Object[] args = {nr_oferty};
        String sql = "SELECT * FROM OFERTY WHERE NR_OFERTY" + args[0];
        Oferty oferty = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Oferty.class));

        return oferty;
    }

    public void update(Oferty oferty){
        String sql = "UPDATE OFERTY SET .... WHERE NR_OFERTY=:NR_OFERTY";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oferty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

}

