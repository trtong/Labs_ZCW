import com.j256.ormlite.dao.Dao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;


public class AcctServiceTest {

    AcctService testService;
    Dao<Account, Integer> dao;
    Account acc;

    @Before
    public void setUp() {
        dao = new MockDao();
        testService = new AcctService(dao);
        acc = new Account("Jared", "Walrus");
    }

    @Test
    public void testCreate() throws Exception {
        int exp = 500;
        int actual = testService.create(new Account("Biggie", "Moot"));
        Assert.assertEquals(exp, actual);
    }


    @Test
    public void testUpdate() throws SQLException {
        String name = "Biggie";

        acc.setName(name);
        int actual = dao.update(acc);

        Assert.assertEquals(700, actual);

    }

    @Test
    public void testDelete() throws SQLException {

        int actual = testService.destroy(acc);
        Assert.assertEquals(666, actual);
    }

}