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
public class StudiaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public StudiaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Studia> list(){
        String sql = "SELECT * FROM studia";

        List<Studia> listStudia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Studia.class));
        return listStudia;
    }

    public Studia get(int nr_studia){
        Object[] args = {nr_studia};
        String sql = "SELECT * FROM sprzety WHERE nr_sprzetu" + args[0];
        Studia studia = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Studia.class));

        return studia;
    }

    public void update(Studia studia){
        String sql = "UPDATE oferty SET .... WHERE nr_oferty=:nr_oferty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(studia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

}
