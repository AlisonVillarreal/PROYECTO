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

import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.proyecto.dao.TipoOrganizacionDao;
import pe.edu.upeu.proyecto.entity.TipoOrganizacion;
@Component
public class TipoOrganizacionDaoImpl implements TipoOrganizacionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(TipoOrganizacion o) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_TIPO_ORGANIZACION.PR_INS_TIPO_ORGANIZACION?)", o.getNombre());
	}

	@Override
	public int update(TipoOrganizacion o) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_TIPO_ORGANIZACION.PR_UPD_TIPO_ORGANIZACION(?,?)", o.getIdtipo_organizacion(),o.getNombre());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_TIPO_ORGANIZACION.PR_DEL_TIPO_ORGANIZACION(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_TIPO_ORGANIZACION")
				.withProcedureName("PR_UPD_TIPO_ORGANIZACION")
				.declareParameters(new SqlOutParameter("cursor_tipo_organizacion", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("idtipo_organizacion", Types.INTEGER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("itipo_organizacion", id);
				return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PR_DEL_TIPO_ORGANIZACION") //nombre del paquete
				.withProcedureName("PR_DEL_TIPO_ORGANIZACION") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("cursor_tipo_organizacion", OracleTypes.CURSOR, new ColumnMapRowMapper()));
				return simpleJdbcCall.execute();
	}


}