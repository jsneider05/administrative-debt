package com.administrative.debt.infrastructure.configuration.objectmapper;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

  private static final String DATE_PATTERN = "dd-MM-yyyy";

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();

    JavaTimeModule javaTimeModule = new JavaTimeModule();

    SimpleModule module = new SimpleModule();


    module.addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
      @Override
      public void serialize(LocalDate localDate, JsonGenerator gen, SerializerProvider serializers)
          throws IOException {
        gen.writeString(DateTimeFormatter.ofPattern(DATE_PATTERN).format(localDate));
      }
    });


    module.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {
      @Override
      public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(jp.getText(), DateTimeFormatter.ofPattern(DATE_PATTERN));
      }
    });


    objectMapper.registerModule(javaTimeModule);

    objectMapper.registerModule(module);
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    objectMapper.setSerializationInclusion(NON_NULL);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    return objectMapper;
  }

}
