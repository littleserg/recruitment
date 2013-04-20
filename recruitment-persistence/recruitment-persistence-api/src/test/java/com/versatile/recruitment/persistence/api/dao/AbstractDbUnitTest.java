package com.versatile.recruitment.persistence.api.dao;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:recruitment-persistence-*.xml"})
@Transactional(propagation = Propagation.REQUIRED)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public abstract class AbstractDbUnitTest extends DatabaseTestCase {

    /** Holds <code>LOG</code> value. */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDbUnitTest.class);

    /** Holds <code>context</code> value. */
    @Autowired
    private ApplicationContext context;

    /** Holds <code>dataSet</code> value. */
    private IDataSet dataSet = null;

    /**
     * {@inheritDoc}
     *
     * @see org.dbunit.DatabaseTestCase#setUp()
     */
    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.dbunit.DatabaseTestCase#tearDown()
     */
    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.dbunit.DatabaseTestCase#getConnection()
     */
    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        return new DatabaseConnection(dataSource.getConnection());
    }

    /**
     * {@inheritDoc}
     *
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        if (dataSet == null) {
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            builder.setColumnSensing(true);
            dataSet = builder.build(getClass().getClassLoader().getResourceAsStream(getDataSetPath()));
        }
        return dataSet;
    }

    protected void log(String text, Object... params) {
        LOG.debug(text, params);
    }

    protected String getDataSetPath() {
        return "dataset.xml";
    }

}
