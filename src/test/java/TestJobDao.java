import org.example.dao.JobsDAO;
import org.example.models.Jobs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

@ExtendWith(MockitoExtension.class)
    public class TestJobDao {
    @InjectMocks
    JobsDAO dao;

    @Test
    void testUpdateJob() throws SQLException, ClassNotFoundException {

        Jobs Jobs = new Jobs(18,"Test",4000,10000);

        Assertions.assertDoesNotThrow(()-> dao.updateJob(Jobs));

        Jobs newJ = dao.selectJob(Jobs.getJob_id());

        Assertions.assertNotNull(newJ);
        Assertions.assertEquals(newJ.getJob_id(),Jobs.getJob_id());
        Assertions.assertEquals(newJ.getJob_title(),Jobs.getJob_title());
    }
}