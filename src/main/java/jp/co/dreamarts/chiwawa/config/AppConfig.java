package jp.co.dreamarts.chiwawa.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ninja.cero.sqltemplate.core.SqlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfig {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    private static final DateTimeFormatter DATE_PARSER = DateTimeFormatter.ofPattern("y[-][/]M[-][/]d hh:mm:ss");

    @Bean
    public SqlTemplate sqlTemplate(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new SqlTemplate(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return Jackson2ObjectMapperBuilder.json()
            .indentOutput(true)
            .serializerByType(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                @Override
                public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
                    jgen.writeString(value.format(DATE_FORMATTER));
                }
        })
        .deserializerByType(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
                return LocalDateTime.parse(jp.getValueAsString(), DATE_PARSER);
            }
        })
        .modules(new JavaTimeModule());
    }
}
