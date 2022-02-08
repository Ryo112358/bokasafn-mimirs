package dev.koicreek.bokasafn.mimir.catalog.cfg;

import dev.koicreek.bokasafn.mimir.catalog.model.AuthorCM;
import dev.koicreek.bokasafn.mimir.catalog.model.BookCM;
import dev.koicreek.bokasafn.mimir.catalog.model.LanguageCM;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class BeanConfig {

    @Bean
    static SessionFactory getSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
            .configure( "hibernate.cfg.xml" )
            .build();

        Metadata metadata = buildSessionFactoryMetadata(standardRegistry);

        return metadata.getSessionFactoryBuilder().build();
    }

    //#region Helpers

    static Metadata buildSessionFactoryMetadata(StandardServiceRegistry standardRegistry) {

        return new MetadataSources( standardRegistry )
                .addAnnotatedClass( BookCM.class )
                .addAnnotatedClass( AuthorCM.class )
                .addAnnotatedClass( LanguageCM.class )
                .getMetadataBuilder()
                .build();
    }

    //#endRegion

//    @Bean
//    static EntityManagerFactory getEntityManagerFactory() {
//        return Persistence.createEntityManagerFactory("dev.koicreek.bokasafn.mimir.catalog");
//    }

}