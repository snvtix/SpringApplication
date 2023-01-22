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
public class SprzetyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public SprzetyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sprzety> list(){
        String sql = "SELECT * FROM sprzety";

        List<Sprzety> listSprzety = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sprzety.class));
        return listSprzety;
    }
    public void save(Sprzety sprzety) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("Sprzety").usingColumns("nr_sprzetu", "nazwa", "model", "data_zakupu", "nr_rozglosni", "nr_studia", "nr_firmy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sprzety);
        insert.execute(param);
    }

    public Sprzety get(int nr_sprzetu){
        Object[] args = {nr_sprzetu};
        String sql = "SELECT * FROM sprzety WHERE nr_sprzetu" + args[0];
        Sprzety sprzety = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Sprzety.class));

        return sprzety;
    }

    public void update(Sprzety sprzety){
        String sql = "UPDATE oferty SET .... WHERE nr_oferty=:nr_oferty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sprzety);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_sprzetu){
        String sql = "DELETE FROM sprzety WHERE nr_sprzetu = ?";
        jdbcTemplate.update(sql, nr_sprzetu);
    }

}
