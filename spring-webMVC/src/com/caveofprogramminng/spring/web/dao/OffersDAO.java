package com.caveofprogramminng.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="offersDAO")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	
	
	public OffersDAO() {
		
		System.out.println("Successfully Loaded offersDAO");
		

	}
	
	@Autowired
	public void setJdbc(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Offer> getOffers() {
		
		
	/*	MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Syed");*/
		
		List<Offer> offersList = jdbc.query("SELECT * from offer", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setValue(rs.getString("value"));
				
				return offer;
			}
		});
		
		return offersList;		
	}
	
	
	public Offer getOffer(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		Offer offer = jdbc.queryForObject("SELECT * from offer where id=:id",params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setValue(rs.getString("value"));
				
				return offer;
			}
		});
		
		return offer;		
	}
	
	public boolean addOffer(Offer offer) {
		
		BeanPropertySqlParameterSource offerBean = new BeanPropertySqlParameterSource(offer);
		
		return (jdbc.update("INSERT into offer(name, email, value) values(:name, :email, :value)", offerBean) == 1);
	
		
	}
	

	public int[] addOffer(List<Offer> offers) {
		
		SqlParameterSource[] batchparams = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT into offer(id, name, email, value) values(:id, :name, :email, :value)", batchparams);
	}

	
	public boolean deleteOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("DELETE from offer where id=:id",params) == 1;
	}
	

}
