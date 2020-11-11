/*Creado por Diego Alor Chavarria*/
package pe.edu.upeu.proyecto.daoImp;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.proyecto.dao.PersonaDao;
import pe.edu.upeu.proyecto.entity.Persona;

@Repository
public class PersonaDaoImp implements PersonaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Persona persona) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_PERSONA.PR_INS_PERSONA(?,?,?,?,?,?,?,?,?)", persona.getNombre(), 
									persona.getApellidos(), persona.getDni(), persona.getFec_nacimiento(), persona.getCelular(),
									persona.getCorreo(), persona.getUsuario(), persona.getClave(), persona.getIdestado_civil());
	}

	@Override
	public int update(Persona persona) {
		// TODO Auto-generated method stub
		System.out.println("se va a editar " + persona.getNombre());
		return jdbcTemplate.update("call PKG_PERSONA.PR_UPD_PERSONA(?,?,?,?,?,?,?,?,?,?)", persona.getIdpersona(), persona.getNombre(), 
				persona.getApellidos(), persona.getDni(), persona.getFec_nacimiento(), persona.getCelular(),
				persona.getCorreo(), persona.getUsuario(), persona.getClave(), persona.getIdestado_civil());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_PERSONA.PR_DEL_PERSONA(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_BUS_PERSONA").withCatalogName("PKG_PERSONA")
														 .declareParameters(new SqlOutParameter("CUR_PERSONA", OracleTypes.CURSOR,
														  new ColumnMapRowMapper()), new SqlParameter("IDPERSONA", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("IDPERSONA", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_PERSONA").withProcedureName("PR_LIS_PERSONA")
														 .declareParameters(new SqlOutParameter("CUR_PERSONA", OracleTypes.CURSOR,
														  new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
}