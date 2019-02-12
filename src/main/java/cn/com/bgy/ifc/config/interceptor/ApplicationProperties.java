/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.bgy.ifc.config.interceptor;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * {@link ConfigurationProperties} for a web server (e.g. port and path settings).
 *
 * @author chenlie
 */

@Component
@ConfigurationProperties(prefix = ApplicationProperties.APPLICATION)
public class ApplicationProperties {
	public static final String APPLICATION = "application";
	public  final ApplicationProperties.File file = new ApplicationProperties.File();

	public  File getFile() {
		return file;
	}
	public static class File{
		private Properties properties = new Properties();

		public Properties getProperties() {
			return properties;
		}

		public String getStaticAccessPath() {
			return properties.getProperty("staticAccessPath");
		}

		public void setStaticAccessPath(String staticAccessPath) {
			properties.setProperty("staticAccessPath", staticAccessPath);
		}
		public String getUploadFolder() {
			return properties.getProperty("uploadFolder");
		}

		public void setUploadFolder(String uploadFolder) {
			properties.setProperty("uploadFolder", uploadFolder);
		}

		public String getFilePath() {
			return properties.getProperty("filePath");
		}

		public void setFilePath(String filePath) {
			properties.setProperty("filePath", filePath);
		}
	}
}
