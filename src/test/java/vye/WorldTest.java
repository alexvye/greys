package vye;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import vye.config.AppConfig;
import vye.es.ESClient;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class})

public class WorldTest implements ApplicationContextAware {
	
    private static final Logger logger = LogManager.getLogger(WorldTest.class);

    @Autowired
    WebApplicationContext webApplicationContext;
    
    private ApplicationContext applicationContext;


    @Before
    public void setup() {
    }
    
    @Test
    public void sampleTest() throws Exception  {
    	MobFactory mf = new MobFactory();
    	mf.loadMobs(100);
    }
    
    @Test
    public void postTest() throws Exception  {
    	Mob mob = new Mob("alex","vye");
        
    	ESClient.post(mob);
    }

   // @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}