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
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klienci> list(){
        String sql = "SELECT * FROM KLIENCI";

        List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
        return listKlienci;
    }

    public void save(Klienci Klienci) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI").usingColumns();

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Klienci);
        insertActor.execute(param);
    }

    public Klienci get(int nr_klienta){
        Object[] args = {nr_klienta};
        String sql = "SELECT * FROM klienci WHERE nr_klienta" + args[0];
        Klienci klienci = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klienci.class));

        return klienci;
    }

    public void update(Klienci klienci){
        String sql = "UPDATE klienci SET .... WHERE nr_klienta=:nr_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

}

