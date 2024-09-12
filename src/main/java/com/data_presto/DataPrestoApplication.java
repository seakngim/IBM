package com.data_presto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {JdbcRepositoriesAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class DataPrestoApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DataPrestoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// Query from Presto (replace 'your_table' with actual table name)
		String sql = "SELECT * FROM \"iceberg_data\".\"preston_data\".\"tb_banking\"";

		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

		// Process the result set
		for (Map<String, Object> row : results) {
			System.out.println(row);
		}
	}

}
