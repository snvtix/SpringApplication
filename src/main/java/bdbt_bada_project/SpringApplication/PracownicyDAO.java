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
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM pracownicy WHERE nr_pracownika = 1";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }

    public Pracownicy get(int nr_pracownika){
        Object[] args = {nr_pracownika};
        String sql = "SELECT * FROM sprzety WHERE nr_sprzetu" + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return pracownicy;
    }

    public void update(Pracownicy pracownicy){
        String sql = "UPDATE pracownicy SET .... WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

}
