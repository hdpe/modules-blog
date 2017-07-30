package me.hdpe.modulesblog.app;

import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class DevToolsImportSelector extends AutoConfigurationImportSelector {

	private static final String AUTO_CONFIGURATION_CLASS =
		"org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration";

	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {

		try {
			Class.forName(AUTO_CONFIGURATION_CLASS);
		}
		catch (ClassNotFoundException exception) {
			return new String[0];
		}

		return new String[] {AUTO_CONFIGURATION_CLASS};
	}
}
