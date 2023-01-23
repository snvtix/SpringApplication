package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.List;

public class FirmyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public FirmyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Firmy> list(){
        String sql = "SELECT * FROM sprzety";

        List<Firmy> listFirmy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Firmy.class));
        return listFirmy;
    }
    public void save(Firmy firmy) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("Sprzety").usingColumns("nr_sprzetu", "nazwa", "model", "data_zakupu", "nr_rozglosni", "nr_studia", "nr_firmy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(firmy);
        insert.execute(param);
    }

    public Firmy get(int nr_firmy){
        Object[] args = {nr_firmy};
        String sql = "SELECT * FROM sprzety WHERE nr_sprzetu" + args[0];
        Firmy firmy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Firmy.class));

        return firmy;
    }

    public void update(Firmy firmy){
        String sql = "UPDATE oferty SET .... WHERE nr_oferty=:nr_oferty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(firmy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_firmy){
        String sql = "DELETE FROM sprzety WHERE nr_sprzetu = ?";
        jdbcTemplate.update(sql, nr_firmy);
    }

}
