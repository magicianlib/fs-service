package io.magicianlib.fs.config.jpa;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HibernateEventListenerRegistry {
    private final EntityManagerFactory entityManagerFactory;
    private final JpaDeleteEventListener jpaDeleteEventListener;

    public HibernateEventListenerRegistry(EntityManagerFactory entityManagerFactory, JpaDeleteEventListener jpaDeleteEventListener) {
        this.entityManagerFactory = entityManagerFactory;
        this.jpaDeleteEventListener = jpaDeleteEventListener;
    }

    @PostConstruct
    public void registerListeners() {
        SessionFactoryImpl factory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = factory.getServiceRegistry().getService(EventListenerRegistry.class);
        Objects.requireNonNull(registry, "HibernateEventListenerRegistry 初始化失败：EventListenerRegistry 不存在！");
        registry.getEventListenerGroup(EventType.DELETE).prependListener(jpaDeleteEventListener);
    }
}