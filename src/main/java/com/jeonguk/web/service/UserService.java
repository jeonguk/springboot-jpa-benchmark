package com.jeonguk.web.service;

import com.jeonguk.web.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final EntityManagerFactory factory;
    private static final int BATCH_SIZE = 500;

    public void jpaPersistBench() {

        final long startTime = System.currentTimeMillis();
        EntityManager entityManager = factory.createEntityManager();
        final EntityTransaction tx = entityManager.getTransaction();

        tx.begin();

        int cont = 0;
        for (int i = 0; i < 15000; i++) {
            final User user = new User();
            user.setName("name" + i);
            user.setCreatedAt(LocalDateTime.now());
            entityManager.persist(user);
            cont++;
            if (cont % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
                tx.commit();
                tx.begin();
            }
        }

        tx.commit();
        entityManager.close();

        final long endTime = System.currentTimeMillis();
        //final long secDiffTime = endTime - startTime;
        log.info("estimatedTime {}", (endTime - startTime)/1000.0);

    }

}
