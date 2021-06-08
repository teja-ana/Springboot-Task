package com.spring.movies.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.movies.model.*;

public class MoviesRepoImpl implements MoviesRepoCustom {

	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	static RowMapper<Movies> rowMapper = (rs,rownum)->{
		
		//System.out.println("MID " + rs.getObject("mid",Movies.class));	
		Movies movies=new Movies();
		movies.setMid(rs.getInt("mid"));
		movies.setTitle(rs.getString("title"));
		//System.out.println("title "+ rs.getString("title") );
		movies.setGenre(rs.getString("genre"));
		movies.setDuration(rs.getString("duration"));
		movies.setRating(rs.getFloat("rating"));
		 
		/*
	
		 Director director = new Director(); director.setDname(rs.getString("dname"));
		 System.out.print("DNAME "+ rs.getString("dname"));
		 movies.setDirector(director);
		 
		 Singer singer = new Singer(); singer.setSname(rs.getString("sname"));
		 movies.setSinger(singer);
		 
		 List<Actor> list=new ArrayList<>(); Actor actor=new Actor();
		 actor.setAname(rs.getString("aname")); list.add(actor);
		 movies.setActors(list);   
		 
		 */
		 
	 		return movies ;
	};

	@Override
	public List<Movies> getTitleContainsString(String title) {

		// String q = "select movies.mid,movies.gid,movies.title,director.did,singer.sid
		// from movies,director,singer where title like '%"+title+"%'";
		// String q= "select * from movies,director,singer where title like
		// '%"+title+"%' order by mid asc" ;
		// String q= "select
		// movies.mid,movies.gid,movies.title,director.dname,singer.sname from
		// movies,director,singer where title like '%"+title+"%' and
		// movies.director_did=director.did and movies.singer_sid=singer.sid";

		String q = "select * from movies where title like '%" + title + "%' ";
		// String q = "select
		// movies.mid,movies.genre,movies.title,director.dname,singer.sname from
		// movies,director,singer where title like '%"+title+"%' and
		// movies.did=director.did and movies.sid=singer.sid";

		
		jdbcTemplate = jdbcTemplate();
		
		/*
		
		String q = "select movies.mid,movies.title,singer.sname,director.dname,actor.aname from movies\r\n"
				+ " inner join singer on movies.sid=singer.sid \r\n"
				+ " inner join director on movies.did=director.did \r\n"
				+ " inner join movie_actor on movies.mid=movie_actor.mid\r\n"
				+ " inner join actor on actor.aid=movie_actor.aid\r\n"
				+ "where title='%"+title+"%'";
		 
		*/
		
		/*
		 * List<Movies> l = jdbcTemplate.query(q,rowMapper);
		 * System.out.println(l.size()); for(Movies m:l) { m.getDirector().getDname();
		 * m.getSinger().getSname(); System.out.println(m.getDirector().getDname()+" " +
		 * m.getSinger().getSname()); } return l ;
		 */
		return jdbcTemplate.query(q, rowMapper);
	}

}
