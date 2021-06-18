package es.antoniogo.management.shared.infrastructure.persistence;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
public class ManagementHibernateConfiguration {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        List<Resource> mappingFiles = searchMappingFiles();

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

        return sessionFactory;
    }

    private List<Resource> searchMappingFiles() {
        String path = "./src/management/src/main/java/es/antoniogo/management/";

        String[]     modules   = subdirectoriesFor(path);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(path + module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(path + module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private String[] subdirectoriesFor(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        File file = new File("./");
        System.out.println("RUTA COMPLETA:!!!!!!!!!!!!!!!!!!!!!!!!! "+file.getAbsolutePath());
        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://192.168.1.10:3307/management?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSourceBuilder.username("management");
        dataSourceBuilder.password("zL0@Z@hQTq");
        return dataSourceBuilder.build();

//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl(
//                "jdbc:mysql://localhost:3306/mooc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//
//        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "true");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        return hibernateProperties;
    }
}
