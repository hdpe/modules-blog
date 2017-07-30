package me.hdpe.modulesblog.app;

import me.hdpe.modulesblog.diary.service.DiaryConfig;
import me.hdpe.modulesblog.web.WebConfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import(DevToolsImportSelector.class)
public class Application {
	public static void main(String[] args) {
		
		new SpringApplicationBuilder()
			.sources(Application.class).web(false)
			.child(DiaryConfig.class).web(false)
			.sibling(WebConfig.class).web(true)
			.run(args);
	}
}
