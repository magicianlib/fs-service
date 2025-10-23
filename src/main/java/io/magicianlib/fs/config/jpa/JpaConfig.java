package io.magicianlib.fs.config.jpa;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    /**
     * 将自定义拦截器实例添加到 Hibernate 配置中
     */
    @Bean
    public HibernatePropertiesCustomizer interceptorCustomizer(SqlStatementDeleteInterceptor sqlStatementDeleteInterceptor) {
        return hibernateProperties -> hibernateProperties.put("hibernate.session_factory.statement_inspector", sqlStatementDeleteInterceptor);
    }
}