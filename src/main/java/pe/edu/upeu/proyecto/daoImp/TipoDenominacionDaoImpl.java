package pe.edu.upeu.proyecto.daoImp;

import java.util.Map;

import java.sql.Types;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.proyecto.dao.TipoDenominacionDao;
import pe.edu.upeu.proyecto.entity.TipoDenominacion;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


@Component
public class TipoDenominacionDaoImpl implements TipoDenominacionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
		@Override
		public int create(TipoDenominacion d) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update("call PKG_TIPO_DENOMINACION.PR_INS_TIPO_DENOMINACION(?)", d.getNombre());
		}

		@Override
		public int update(TipoDenominacion d) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update("call PKG_TIPO_DENOMINACION.PR_UPD_TIPO_DENOMINACION(?,?)", d.getIdtipo_denominacion(),d.getNombre());
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update("call PKG_TIPO_DENOMINACION.PR_DEL_TIPO_DENOMINACION(?)", id);
		}

		@Override
		public Map<String, Object> read(int id) {
			// TODO Auto-generated method stub
			System.out.println(id);
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withCatalogName("PKG_TIPO_DENOMINACION")
					.withProcedureName("PR_BUS_TIPO_DENOMINACION")
					.declareParameters(new SqlOutParameter("CUR_TIPO_DENOMINACION", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("IDTIPO_DENOMINACION", Types.INTEGER));
					SqlParameterSource in = new MapSqlParameterSource().addValue("IDTIPO_DENOMINACION", id);
					return simpleJdbcCall.execute(in);
		}

		@Override
		public Map<String, Object> readAll() {
			// TODO Auto-generated method stub
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withCatalogName("PKG_TIPO_DENOMINACION") //nombre del paquete
					.withProcedureName("PR_LIS_TIPO_DENOMINACION") //nombre del procedimiento
					.declareParameters(new SqlOutParameter("CUR_TIPO_DENOMINACION", OracleTypes.CURSOR, new ColumnMapRowMapper()));
					return simpleJdbcCall.execute();
		}

	}