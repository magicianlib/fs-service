package io.magicianlib.fs.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.io.File;

public class LoggingDirValidator implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    public static final String ENV_LOG_FILE_DIR = "logging.file.dir";
    private static final Logger LOGGER = LogManager.getLogger(LoggingDirValidator.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        String dir = event.getEnvironment().getProperty(ENV_LOG_FILE_DIR);
        if (StringUtils.isBlank(dir)) {
            throw new IllegalStateException("未设置日志输出目录配置项：" + ENV_LOG_FILE_DIR);
        }

        File f = new File(dir);
        if (!f.exists() || !f.isDirectory()) {
            throw new IllegalStateException("设置的日志输出目录不存在或不可访问：" + ENV_LOG_FILE_DIR);
        }
    }
}