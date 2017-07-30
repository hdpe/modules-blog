package me.hdpe.modulesblog.diary.service;

import me.hdpe.modulesblog.diary.api.DiaryService;
import me.hdpe.modulesblog.spring.Exported;
import me.hdpe.modulesblog.spring.ExportedConfiguration;

import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	CacheAutoConfiguration.class,
	ExportedConfiguration.class
})
@EnableCaching
public class DiaryConfig {
	
	@Exported
	@Bean
	public DiaryService diary() {
		return new CraigDiaryService();
	}
}
