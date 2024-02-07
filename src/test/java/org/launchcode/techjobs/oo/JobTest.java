package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //Job object created using the full constructor with sample data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //assertTrue(job instanceof Job);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    //assertTrue and assertEquals statements used to verify that the constructor correctly assigns both the class and value of each field
    @Test
    public void testJobsForEquality() {
        //created two job objects, identical other than the id field
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    //The assertFalse method is used to verify that the equals method returns false for these two objects
    }
}
